/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller24;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author anton
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Etiqueta Interactiva");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Usar null layout para posicionar las etiquetas libremente

        // Crear la etiqueta negra
        JLabel etiquetaNegra = new JLabel();
        etiquetaNegra.setOpaque(true);
        etiquetaNegra.setBackground(Color.BLACK);
        etiquetaNegra.setBounds(50, 50, 150, 50);

        // Crear la etiqueta gris
        JLabel etiquetaGris = new JLabel("Etiqueta");
        etiquetaGris.setOpaque(true);
        etiquetaGris.setBackground(Color.GRAY);
        etiquetaGris.setForeground(Color.WHITE);
        etiquetaGris.setBounds(50, 50, 150, 50);  // Inicialmente en la misma posición que la etiqueta negra

        // Agregar el evento mouseEntered
        etiquetaGris.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                etiquetaGris.setText("Pulsame");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaGris.setText("Etiqueta");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Cambiar texto y mover la etiqueta para simular un "pulsado"
                etiquetaGris.setText("Está pulsado");
                etiquetaGris.setLocation(55, 55);  // Mover la etiqueta ligeramente hacia abajo y a la derecha
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Volver a la posición original y cambiar el texto
                etiquetaGris.setText("Pulsado");
                etiquetaGris.setLocation(50, 50);
            }
        });

        // Agregar las etiquetas al panel
        panel.add(etiquetaNegra);
        panel.add(etiquetaGris);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
