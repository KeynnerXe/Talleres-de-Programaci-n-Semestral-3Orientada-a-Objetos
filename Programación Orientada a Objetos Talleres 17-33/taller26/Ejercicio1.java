/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller26;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Eventos de Ventana");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centrar la ventana

        // Crear una etiqueta en el centro de la ventana
        JLabel label = new JLabel("Esperando acción...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Crear un panel para contener la etiqueta
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        // Asignar el WindowListener al frame para manejar los eventos de ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                label.setText("La ventana se ha activado");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                label.setText("La ventana se ha desactivado");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // Mostrar un mensaje de bienvenida al abrir la ventana
                JOptionPane.showMessageDialog(frame, "¡Bienvenido a la ventana!");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar un mensaje de despedida al cerrar la ventana
                JOptionPane.showMessageDialog(frame, "¡Hasta luego!");
            }
        });

        // Agregar el panel al frame
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
