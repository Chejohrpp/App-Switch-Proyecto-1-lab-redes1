package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorCliente implements Runnable {
    private final Socket cliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

            while (true) {
                // Leemos el mensaje del cliente
                String mensaje = entrada.readLine();
                if (mensaje == null) {
                    System.out.println(cliente.getInetAddress() + " Desconectado");
                    break;
                }
                System.out.println("Mensaje recibido desde " + cliente.getInetAddress() + ": " + mensaje);

                // Enviamos una respuesta al cliente
                salida.println(mensaje);
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente " + cliente.getInetAddress());
        }
    }
}
