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
public class Ejercicio2 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Ejercicio 2");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Crear un panel con Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear un JList con las ocho provincias andaluzas
        String[] provincias = {"Almería", "Cádiz", "Córdoba", "Granada", "Huelva", "Jaén", "Málaga", "Sevilla"};
        JList<String> listaProvincias = new JList<>(provincias);
        panel.add(new JScrollPane(listaProvincias), BorderLayout.EAST);  // Colocarlo en la parte derecha

        // Crear un JComboBox con tipos de artículos
        String[] tiposArticulos = {"Electrónica", "Ropa", "Juguetes", "Muebles", "Alimentos"};
        JComboBox<String> comboBox = new JComboBox<>(tiposArticulos);
        comboBox.setPopupVisible(true);  // Mostrar el combo desplegado
        panel.add(comboBox, BorderLayout.WEST);  // Colocarlo en la parte izquierda

        // Crear la etiqueta vacía con fondo CYAN
        JLabel etiquetaCyan = new JLabel();
        etiquetaCyan.setOpaque(true);
        etiquetaCyan.setBackground(Color.CYAN);
        panel.add(etiquetaCyan, BorderLayout.SOUTH);

        // Agregar el panel a la ventana
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
