/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller27;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;
/**
 *
 * @author anton
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Ejercicio 2");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10)); // GridLayout para los componentes

        // Vectores de elementos
        Vector<JLabel> etiquetas = new Vector<>();
        Vector<JTextField> cuadrosTexto = new Vector<>();
        Vector<JButton> botones = new Vector<>();
        
        // Textos para las etiquetas
        String[] textosEtiquetas = {"Devoluciones", "Impagos", "Caducidad", "Robos"};

        // Crear etiquetas y agregar al vector
        for (String texto : textosEtiquetas) {
            etiquetas.add(new JLabel(texto));
        }

        // Crear cuadros de texto y agregar al vector
        for (int i = 0; i < 4; i++) {
            cuadrosTexto.add(new JTextField(10));
        }

        // Crear botones y agregar al vector
        for (int i = 0; i < 4; i++) {
            botones.add(new JButton("Botón " + (i + 1)));
        }

        // Agregar componentes a la ventana
        for (int i = 0; i < 4; i++) {
            frame.add(etiquetas.get(i));
            frame.add(cuadrosTexto.get(i));
            frame.add(botones.get(i));
        }

        // Hacer la ventana visible y centrada en la pantalla
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
