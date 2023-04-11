package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class SwitchController {
    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers;

    public SwitchController() throws IOException {
        serverSocket = NetworkUtils.createServerSocket();
        clientHandlers = new ArrayList<>();
        // código para inicializar la interfaz gráfica de usuario
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    Socket clientSocket = NetworkUtils.acceptClientSocket(serverSocket);
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clientHandlers.add(clientHandler);
                    clientHandler.start();
                } catch (IOException e) {
                    // manejar la excepción
                }
            }
        }).start();
    }

    public void stop() throws IOException {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.stop();
        }
        serverSocket.close();
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        }

//        @Override
//        public void run() {
//            while (!isInterrupted()) {
//                try {
//                    byte[] headerBytes = NetworkUtils.readBytes(inputStream, Packet.HEADER_LENGTH);
//                    Packet packet = new Packet(headerBytes);
//                    byte[] dataBytes = NetworkUtils.readBytes(inputStream, packet.getDataLength());
//                    packet.setData(dataBytes);
//                    // código para procesar la trama recibida
//                } catch (IOException | PacketFormatException e) {
//                    // manejar la excepción
//                }
//            }
//        }

        public void sendPacket(Packet packet) throws IOException {
            byte[] packetBytes = packet.serialize();
            NetworkUtils.writeBytes(outputStream, packetBytes);
        }

//        @Override
//        public void stop() throws IOException {
//            interrupt();
//            socket.close();
//            inputStream.close();
//            outputStream.close();
//        }
    }
}

