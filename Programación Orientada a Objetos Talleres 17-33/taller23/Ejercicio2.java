/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller23;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author anton
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Cálculo de Velocidad y Espacio");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Crear un panel con Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Crear los componentes
        JLabel espacioLabel = new JLabel("Espacio:");
        JTextField espacioField = new JTextField();
        JLabel tiempoLabel1 = new JLabel("Tiempo:");
        JTextField tiempoField1 = new JTextField();
        JLabel resultadoLabel1 = new JLabel("Velocidad:");
        resultadoLabel1.setForeground(Color.YELLOW);

        JLabel velocidadLabel = new JLabel("Velocidad:");
        JTextField velocidadField = new JTextField();
        JLabel tiempoLabel2 = new JLabel("Tiempo:");
        JTextField tiempoField2 = new JTextField();
        JLabel resultadoLabel2 = new JLabel("Espacio:");
        resultadoLabel2.setForeground(Color.RED);

        // Agregar los componentes al panel
        panel.add(espacioLabel);
        panel.add(espacioField);
        panel.add(tiempoLabel1);
        panel.add(tiempoField1);
        panel.add(resultadoLabel1);
        panel.add(velocidadLabel);
        panel.add(velocidadField);
        panel.add(tiempoLabel2);
        panel.add(tiempoField2);
        panel.add(resultadoLabel2);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Evento de campo de texto Espacio
        espacioField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double espacio = Double.parseDouble(espacioField.getText());
                    double tiempo = Double.parseDouble(tiempoField1.getText());
                    double velocidad = espacio / tiempo;
                    resultadoLabel1.setText("Velocidad: " + velocidad);
                } catch (NumberFormatException ex) {
                    resultadoLabel1.setText("Error en los valores");
                }
            }
        });

        // Evento de campo de texto Tiempo 1 (Espacio/Velocidad)
        tiempoField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double espacio = Double.parseDouble(espacioField.getText());
                    double tiempo = Double.parseDouble(tiempoField1.getText());
                    double velocidad = espacio / tiempo;
                    resultadoLabel1.setText("Velocidad: " + velocidad);
                } catch (NumberFormatException ex) {
                    resultadoLabel1.setText("Error en los valores");
                }
            }
        });

        // Evento de campo de texto Velocidad
        velocidadField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double velocidad = Double.parseDouble(velocidadField.getText());
                    double tiempo = Double.parseDouble(tiempoField2.getText());
                    double espacio = velocidad * tiempo;
                    resultadoLabel2.setText("Espacio: " + espacio);
                } catch (NumberFormatException ex) {
                    resultadoLabel2.setText("Error en los valores");
                }
            }
        });

        // Evento de campo de texto Tiempo 2 (Espacio/Velocidad)
        tiempoField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double velocidad = Double.parseDouble(velocidadField.getText());
                    double tiempo = Double.parseDouble(tiempoField2.getText());
                    double espacio = velocidad * tiempo;
                    resultadoLabel2.setText("Espacio: " + espacio);
                } catch (NumberFormatException ex) {
                    resultadoLabel2.setText("Error en los valores");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}