/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.switch_application.gui;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class TablaArpGui extends javax.swing.JFrame {

    /**
     * Creates new form TablaArpGui
     */
    private HashMap<String, String> tablaArp;

    public TablaArpGui(HashMap<String, String> tablaArp) {
        this.tablaArp = tablaArp;
        initComponents();
        generateTableArp();
    }

    private void generateTableArp() {
        // Obtener las claves y los valores de la tabla ARP
        Set<String> macAddresses = tablaArp.keySet();
        Collection<String> ipAddresses = tablaArp.values();

        // Crear una matriz bidimensional con los valores de la tabla ARP
        Object[][] data = new Object[tablaArp.size()][2];
        int i = 0;
        for (String mac : macAddresses) {
            String ip = tablaArp.get(mac);
            data[i][0] = mac;
            data[i][1] = ip;
            i++;
        }

        // Crear un objeto DefaultTableModel y establecer la matriz de datos y los nombres de las columnas
        DefaultTableModel model = new DefaultTableModel(data, new String[]{"MAC", "IP"});

        // Establecer el modelo de la tabla jTable
        tblArp.setModel(model);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArp = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tabla ARP");

        tblArp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "MAC", "IP"
            }
        ));
        jScrollPane1.setViewportView(tblArp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArp;
    // End of variables declaration//GEN-END:variables
}
