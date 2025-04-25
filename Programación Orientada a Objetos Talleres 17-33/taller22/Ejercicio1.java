/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller22;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author anton
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Ejercicio 1");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Crear un panel para colocar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear la etiqueta RESULTADO
        JLabel resultadoLabel = new JLabel("RESULTADO", JLabel.CENTER);
        resultadoLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        panel.add(resultadoLabel, BorderLayout.NORTH);

        // Crear el JToggleButton
        JToggleButton toggleButton = new JToggleButton("metros/seg");
        toggleButton.setSelected(true);  // Activado por defecto
        panel.add(toggleButton, BorderLayout.CENTER);

        // Crear el JSlider
        JSlider slider = new JSlider(0, 100, 20);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        panel.add(slider, BorderLayout.SOUTH);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
