package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ManejadorCliente implements Runnable {

    private Socket socket;
    private List<ManejadorCliente> clientes;
    private String macAdress;

    public ManejadorCliente(Socket socket, List<ManejadorCliente> clientes, String macAdress) {
        this.socket = socket;
        this.clientes = clientes;
        this.macAdress = macAdress;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Agregamos esta instancia a la lista de clientes
            clientes.add(this);
            String mensaje;
            String mac = macAdress;
            while ((mensaje = entrada.readLine()) != null) {
                // Enviamos el mensaje a todos los otros clientes
                for (ManejadorCliente cliente : clientes) {
                    if (cliente != this) {
                        cliente.enviarMensaje(mac,mensaje);
                    } 
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el manejo del cliente: " + e.getMessage());
        } finally {
            // Eliminamos esta instancia de la lista de clientes al finalizar
            clientes.remove(this);
            try {
                System.out.println("SOCKET CERRADO " + socket.getInetAddress());
                socket.close();
            } catch (IOException e) {
                // Manejo del error
            }
        }
    }

    // Método para enviar un mensaje a este cliente
    public void enviarMensaje(String mac, String mensaje) {
        try {
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            String mensajeServer ="[" + mac + "]: " + mensaje; 
            salida.println(mensajeServer);
            System.out.println(mensajeServer);
        } catch (IOException e) {
            System.out.println("Error al enviar mensaje: " + e.getMessage());
        }
    }

    public String getMacAdress() {
        return macAdress;
    }
    
    
}


