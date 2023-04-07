package com.mycompany.switch_application.connection;

 // @author sergi
import java.net.*;
import java.util.*;

public class Switch {
    // Mapa para la tabla ARP
    private final Map<String, String> arpTable;

    public Switch() {
        // Inicializar la tabla ARP
        arpTable = new HashMap<>();
    }

    public void start() {
        try {
            // Crear el socket para escuchar en el puerto 5000
            DatagramSocket socket = new DatagramSocket(5000);

            while (true) {
                // Crear el paquete para recibir los datos
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Esperar a recibir un paquete
                socket.receive(packet);

                // Obtener la dirección MAC de origen del paquete
                String srcMac = getAddress(packet.getData());

                // Obtener la dirección MAC de destino del paquete
                String destMac = getAddress(Arrays.copyOfRange(packet.getData(), 6, 12));

                // Actualizar la tabla ARP con la dirección MAC de origen
                arpTable.put(srcMac, packet.getAddress().getHostAddress());

                // Si la dirección MAC de destino es de broadcast, enviar el paquete a todas las interfaces
                if (destMac.equals("ff:ff:ff:ff:ff:ff")) {
                    broadcast(packet);
                }
                // Si la dirección MAC de destino está en la tabla ARP, enviar el paquete a la dirección correspondiente
                else if (arpTable.containsKey(destMac)) {
                    unicast(packet, arpTable.get(destMac));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    // Método para enviar un paquete de broadcast
    private void broadcast(DatagramPacket packet) throws Exception {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();

            if (ni.isLoopback() || !ni.isUp()) {
                continue;
            }

            for (InterfaceAddress address : ni.getInterfaceAddresses()) {
                InetAddress broadcast = address.getBroadcast();

                if (broadcast == null) {
                    continue;
                }

                DatagramPacket broadcastPacket = new DatagramPacket(packet.getData(), packet.getLength(), broadcast, packet.getPort());
                try (DatagramSocket socket = new DatagramSocket()) {
                    socket.setBroadcast(true);
                    socket.send(broadcastPacket);
                }
            }
        }
    }

    // Método para enviar un paquete unicast
    private void unicast(DatagramPacket packet, String destAddress) throws Exception {
        InetAddress address = InetAddress.getByName(destAddress);
        DatagramPacket unicastPacket = new DatagramPacket(packet.getData(), packet.getLength(), address, packet.getPort());
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.send(unicastPacket);
        }
    }

    // Método para obtener la dirección MAC de una trama Ethernet
    private String getAddress(byte[] data) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            builder.append(String.format("%02X%s", data[i], (i < 5) ? ":" : ""));
        }

        return builder.toString();
    }
}

