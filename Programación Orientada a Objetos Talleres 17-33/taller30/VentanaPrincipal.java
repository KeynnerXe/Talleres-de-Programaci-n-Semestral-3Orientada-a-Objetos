/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller30;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author anton
 */
public class VentanaPrincipal extends JFrame {
    private EtiquetaTemperatura etiTemp; // Etiqueta para mostrar la temperatura
    private JTextField tfGrados; // Cuadro de texto para ingresar los grados
    private JButton btnSumar, btnRestar, btnFahrenheit;

    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Control de Temperatura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear la etiqueta de temperatura, inicialmente en 0 ºC
        etiTemp = new EtiquetaTemperatura();
        etiTemp.setTemperatura(0);
        add(etiTemp);

        // Crear el cuadro de texto para ingresar grados
        tfGrados = new JTextField(10);
        add(tfGrados);

        // Crear los botones
        btnSumar = new JButton("+");
        btnRestar = new JButton("-");
        btnFahrenheit = new JButton("Fahrenheit");

        add(btnSumar);
        add(btnRestar);
        add(btnFahrenheit);

        // Acción del botón "+"
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double grados = Double.parseDouble(tfGrados.getText());
                    etiTemp.cambiarTemperatura(grados);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
                }
            }
        });

        // Acción del botón "-"
        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double grados = Double.parseDouble(tfGrados.getText());
                    etiTemp.cambiarTemperatura(-grados);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido");
                }
            }
        });

        // Acción del botón "Fahrenheit"
        btnFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temperaturaCelsius = etiTemp.getTemperatura();
                double temperaturaFahrenheit = (temperaturaCelsius * 9 / 5) + 32;
                JOptionPane.showMessageDialog(null, "Temperatura en Fahrenheit: " + temperaturaFahrenheit + " °F");
            }
        });
    }

    public static void main(String[] args) {
        // Iniciar la ventana
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setLocationRelativeTo(null); // Centrar la ventana
        ventana.setVisible(true);
    }
}
