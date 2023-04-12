/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.switch_application.gui;

import Controller.ServidorThread;
import com.mycompany.switch_application.connection.Servidor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;


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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(btnUnicast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatusServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnARPTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnInit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatusServer)))
                .addGap(28, 28, 28)
                .addComponent(btnARPTabla)
                .addGap(31, 31, 31)
                .addComponent(btnBroadcast)
                .addGap(32, 32, 32)
                .addComponent(btnUnicast)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroadcastActionPerformed
         servidor.broadcast("¿quien está conectado en la red?");
         
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblStatusServer;
    // End of variables declaration//GEN-END:variables
}
