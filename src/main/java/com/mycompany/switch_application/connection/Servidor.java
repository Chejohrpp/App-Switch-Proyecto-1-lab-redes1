package com.mycompany.switch_application.connection;

 // @author sergi
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servidor {

    private int puerto;
    private List<ManejadorCliente> clientes;
    
    private HashMap<String, String> tablaARP;

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.clientes = new ArrayList<>();
        
         tablaARP = new HashMap<>();
    }

    public void iniciar() {
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);

            while (true) {
                // Esperamos a que se conecte un cliente
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado desde " + socket.getInetAddress());
                
                // Leer el MAC address enviado por el cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String macAddress = entrada.readLine();
                System.out.println("MAC Address del cliente: " + macAddress);
                
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println("OK");
                
                // Creamos un nuevo hilo para manejar al cliente
                ManejadorCliente manejador = new ManejadorCliente(socket, clientes,macAddress);
                Thread hiloCliente = new Thread(manejador);
                hiloCliente.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor(1234);
        servidor.iniciar();
    }
}


