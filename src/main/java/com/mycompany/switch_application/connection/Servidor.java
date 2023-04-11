package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private static final int PUERTO = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado en el puerto " + PUERTO);

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde " + cliente.getInetAddress());

            // Creamos un hilo para atender al cliente
            Thread hiloCliente = new Thread(new ManejadorCliente(cliente));
            hiloCliente.start();
        }
    }
}

