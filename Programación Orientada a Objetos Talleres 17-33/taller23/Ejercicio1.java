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
public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Cálculo de Área y Perímetro de un Círculo");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Crear un panel con Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Crear los componentes
        JLabel radioLabel = new JLabel("Radio:");
        JTextField radioField = new JTextField("0");
        JButton areaButton = new JButton("Área");
        JButton perimetroButton = new JButton("Perímetro");
        JButton limpiarButton = new JButton("Limpiar");
        JLabel resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setForeground(Color.RED);

        // Agregar los componentes al panel
        panel.add(radioLabel);
        panel.add(radioField);
        panel.add(areaButton);
        panel.add(perimetroButton);
        panel.add(limpiarButton);
        panel.add(resultadoLabel);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Evento de botón Área
        areaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radio = Double.parseDouble(radioField.getText());
                    double area = Math.PI * Math.pow(radio, 2);
                    resultadoLabel.setText("Área: " + area);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Error en el valor del radio");
                }
            }
        });

        // Evento de botón Perímetro
        perimetroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double radio = Double.parseDouble(radioField.getText());
                    double perimetro = 2 * Math.PI * radio;
                    resultadoLabel.setText("Perímetro: " + perimetro);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Error en el valor del radio");
                }
            }
        });

        // Evento de botón Limpiar
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radioField.setText("0");
                resultadoLabel.setText("Resultado: ");
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

