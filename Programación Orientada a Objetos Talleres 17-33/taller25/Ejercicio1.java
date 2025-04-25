/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller25;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("JSlider y Rueda del Ratón");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Centrar la ventana

        // Crear un panel para contener los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Crear el JSlider con un valor inicial de 50, un mínimo de 0 y un máximo de 100
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(20);  // Marcas principales cada 20 unidades
        slider.setMinorTickSpacing(5);   // Marcas menores cada 5 unidades
        slider.setPaintTicks(true);      // Mostrar las marcas
        slider.setPaintLabels(true);    // Mostrar etiquetas en las marcas

        // Crear la etiqueta que mostrará el valor del slider
        JLabel label = new JLabel("Valor: 50");

        // Agregar un ChangeListener al JSlider para actualizar el valor en la etiqueta
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();  // Obtener el valor del JSlider
                label.setText("Valor: " + value);  // Actualizar el texto de la etiqueta
            }
        });

        // Agregar un MouseWheelListener para controlar el movimiento de la rueda del ratón
        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {
                int value = slider.getValue();  // Obtener el valor actual del JSlider
                value += evt.getUnitsToScroll();  // Ajustar el valor según el movimiento de la rueda
                // Limitar el valor del JSlider para que no se pase del rango
                value = Math.max(0, Math.min(value, 100));
                slider.setValue(value);  // Actualizar el valor del JSlider
            }
        });

        // Agregar los componentes al panel
        panel.add(slider);
        panel.add(label);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
