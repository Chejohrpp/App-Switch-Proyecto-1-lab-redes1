package com.mycompany.switch_application;

 // @author sergi
import com.mycompany.switch_application.gui.MainGui;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Main {
    public static void main(String[] args) {
        
        MainGui mainGui = new MainGui();
        
        // Obtener el tamaño de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcular la posición del JFrame para que quede en el centro
        int x = (pantalla.width - mainGui.getWidth()) / 2;
        int y = (pantalla.height - mainGui.getHeight()) / 2;

        // Establecer la posición del JFrame
        mainGui.setLocation(x, y);
        mainGui.setVisible(true);
    }
    
}
