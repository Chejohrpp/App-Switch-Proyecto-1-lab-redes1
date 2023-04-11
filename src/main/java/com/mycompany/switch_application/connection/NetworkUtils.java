package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetworkUtils {
    public static final int PORT = 5000;

    public static Socket connectToServer(String ipAddress) throws IOException {
        return new Socket(ipAddress, PORT);
    }

    public static ServerSocket createServerSocket() throws IOException {
        return new ServerSocket(PORT);
    }

    public static Socket acceptClientSocket(ServerSocket serverSocket) throws IOException {
        return serverSocket.accept();
    }

    public static byte[] readBytes(InputStream inputStream, int length) throws IOException {
        byte[] bytes = new byte[length];
        int bytesRead = 0;
        while (bytesRead < length) {
            int result = inputStream.read(bytes, bytesRead, length - bytesRead);
            if (result == -1) {
                break;
            }
            bytesRead += result;
        }
        return bytes;
    }

    public static void writeBytes(OutputStream outputStream, byte[] bytes) throws IOException {
        outputStream.write(bytes);
        outputStream.flush();
    }

    public static String getIPAddress() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        return inetAddress.getHostAddress();
    }
}

