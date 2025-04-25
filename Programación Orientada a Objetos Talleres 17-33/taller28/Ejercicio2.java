/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller28;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author anton
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Ejercicio 2");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());  // Usar FlowLayout para organizar las etiquetas

        // Vectores de etiquetas y provincias
        String[] provincias = {"Almería", "Cádiz", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla", "Córdoba"};
        JLabel[] etiquetas = new JLabel[provincias.length];

        // Crear etiquetas y agregar al vector
        for (int i = 0; i < provincias.length; i++) {
            etiquetas[i] = new JLabel(provincias[i]);
            etiquetas[i].setBackground(Color.BLUE);
            etiquetas[i].setForeground(Color.BLACK);
            etiquetas[i].setOpaque(true);  // Hacer la etiqueta opaca para poder cambiar el fondo
            frame.add(etiquetas[i]);

            // Evento de clic en la etiqueta (mouseClicked)
            final int index = i;
            etiquetas[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Cambiar color de fondo de la etiqueta seleccionada a verde
                    for (int j = 0; j < etiquetas.length; j++) {
                        if (j == index) {
                            etiquetas[j].setBackground(Color.GREEN);
                        } else {
                            etiquetas[j].setBackground(Color.BLUE);
                        }
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambiar color de texto al pasar el ratón
                    etiquetas[index].setForeground(Color.YELLOW);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Volver a color de texto negro al abandonar el ratón
                    etiquetas[index].setForeground(Color.BLACK);
                }
            });
        }

        // Hacer la ventana visible y centrada
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
