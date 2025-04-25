/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller27;
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
        // Crear la ventana principal
        JFrame frame = new JFrame("Ejercicio 1");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Crear los días de la semana
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        // Crear un vector de JToggleButton
        JToggleButton[] botones = new JToggleButton[dias.length];
        for (int i = 0; i < dias.length; i++) {
            botones[i] = new JToggleButton(dias[i]);
            frame.add(botones[i]);
        }

        // Crear el botón "Aceptar"
        JButton aceptarButton = new JButton("Aceptar");
        frame.add(aceptarButton);

        // Crear las etiquetas para mostrar resultados
        JLabel etiqueta1 = new JLabel("Número de días seleccionados: 0");
        JLabel etiqueta2 = new JLabel("Días seleccionados: ");
        frame.add(etiqueta1);
        frame.add(etiqueta2);

        // Acción del botón "Aceptar"
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int contador = 0;
                StringBuilder diasSeleccionados = new StringBuilder();

                // Contar los botones activados y construir la lista de días seleccionados
                for (JToggleButton boton : botones) {
                    if (boton.isSelected()) {
                        contador++;
                        diasSeleccionados.append(boton.getText()).append(" ");
                    }
                }

                // Actualizar las etiquetas con la información
                etiqueta1.setText("Número de días seleccionados: " + contador);
                etiqueta2.setText("Días seleccionados: " + diasSeleccionados.toString());
            }
        });

        // Hacer la ventana visible y centrada en la pantalla
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
