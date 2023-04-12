/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.switch_application.gui;

import Controller.ServidorThread;
import com.mycompany.switch_application.connection.Servidor;
import gui_logic.ConsolePrintStream;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JScrollPane;


/**
 *
 * @author sergi
 */
public class MainGui extends javax.swing.JFrame {

    /**
     * Creates new form MainGui
     */
    private final Servidor servidor;
    private ServidorThread servidorThread;
    
    public MainGui() {
        servidor = new Servidor(1234);
        initComponents();
        console.setEditable(false);
        //JScrollPane scrollPane = new JScrollPane(console);
        //scrollPane.setPreferredSize(new Dimension(400, 200));
        //getContentPane().add(scrollPane, BorderLayout.CENTER);
        ConsolePrintStream consolePrintStream = new ConsolePrintStream(console, System.out);
        System.setOut(consolePrintStream);
        System.setErr(consolePrintStream);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnARPTabla = new javax.swing.JButton();
        btnBroadcast = new javax.swing.JButton();
        btnUnicast = new javax.swing.JButton();
        btnInit = new javax.swing.JButton();
        lblStatusServer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SWITCH APPLICATION");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnARPTabla.setText("Tabla ARP");
        btnARPTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARPTablaActionPerformed(evt);
            }
        });

        btnBroadcast.setText("Broadcast");
        btnBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroadcastActionPerformed(evt);
            }
        });

        btnUnicast.setText("Unicast");
        btnUnicast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnicastActionPerformed(evt);
            }
        });

        btnInit.setText("Iniciar");
        btnInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitActionPerformed(evt);
            }
        });

        lblStatusServer.setText("Server no iniciado");

        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(btnUnicast, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(btnARPTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnInit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatusServer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInit)
                        .addGap(18, 18, 18)
                        .addComponent(btnARPTabla)
                        .addGap(32, 32, 32)
                        .addComponent(btnBroadcast)
                        .addGap(26, 26, 26)
                        .addComponent(btnUnicast)
                        .addGap(28, 28, 28)
                        .addComponent(lblStatusServer)
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
         servidor.broadcast("Servidor: quien esta conectado en la red?");
    }//GEN-LAST:event_btnBroadcastActionPerformed

    private void btnInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitActionPerformed
       servidorThread = new ServidorThread(1234, servidor);
       servidorThread.start();
       lblStatusServer.setText("Servidor iniciado en el puerto " + 1234);
       btnInit.setEnabled(false);
    }//GEN-LAST:event_btnInitActionPerformed

    private void btnARPTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARPTablaActionPerformed
      TablaArpGui tablaAroGui = new TablaArpGui(servidor.getTablaArp());
      Point point = dimScreen(tablaAroGui);
      tablaAroGui.setLocation(point);
      tablaAroGui.setVisible(true);
    }//GEN-LAST:event_btnARPTablaActionPerformed

    private void btnUnicastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnicastActionPerformed
        // TODO add your handling code here:
      UnicastGui unicastGui = new UnicastGui(servidor.getTablaArp(), servidor);
      Point point = dimScreen(unicastGui);
      unicastGui.setLocation(point);
      unicastGui.setVisible(true);
    }//GEN-LAST:event_btnUnicastActionPerformed

    private Point  dimScreen(javax.swing.JFrame jFrame){
        // Obtener el tamaño de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición del JFrame para que quede en el centro
        int x = (pantalla.width - jFrame.getWidth()) / 2;
        int y = (pantalla.height - jFrame.getHeight()) / 2;
        return new Point(x, y);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnARPTabla;
    private javax.swing.JButton btnBroadcast;
    private javax.swing.JButton btnInit;
    private javax.swing.JButton btnUnicast;
    private javax.swing.JTextArea console;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatusServer;
    // End of variables declaration//GEN-END:variables
}
