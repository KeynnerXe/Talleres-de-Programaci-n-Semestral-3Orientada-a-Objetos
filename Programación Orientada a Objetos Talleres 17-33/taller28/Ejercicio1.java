/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller28;
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
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);  // Usar layout nulo para colocar los componentes manualmente

        // Crear el cuadro de texto donde aparecerán los dígitos
        JTextField textField = new JTextField();
        textField.setBounds(10, 10, 260, 30);  // Posición y tamaño del cuadro de texto
        frame.add(textField);

        // Crear los botones para los números 0-9
        JButton[] botones = new JButton[10];
        int[] vectorX = {10, 40, 70, 10, 40, 70, 10, 40, 70, 10};
        int[] vectorY = {50, 50, 50, 80, 80, 80, 110, 110, 110, 140};

        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton(String.valueOf(i));
            botones[i].setBounds(vectorX[i], vectorY[i], 20, 20);
            frame.add(botones[i]);

            // Acción para cada botón de números
            final int index = i;
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + index);
                }
            });
        }

        // Crear el botón "Borrar"
        JButton borrarButton = new JButton("Borrar");
        borrarButton.setBounds(10, 170, 260, 30);
        frame.add(borrarButton);

        // Acción para el botón "Borrar"
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        // Hacer la ventana visible y centrada
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
