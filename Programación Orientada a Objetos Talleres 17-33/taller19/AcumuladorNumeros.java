/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller19;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class AcumuladorNumeros extends JFrame {
    private JTextField txtNumero;
    private JButton btnAcumular, btnResultados, btnReiniciar;
    private JLabel etiMayor, etiSuma, etiMedia, etiCuenta;

    // Variables globales
    private double mayor = 0;
    private double suma = 0;
    private int cuenta = 0;

    public AcumuladorNumeros() {
        setTitle("Acumulador de Números");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        txtNumero = new JTextField();
        btnAcumular = new JButton("Acumular");
        btnResultados = new JButton("Resultados");
        btnReiniciar = new JButton("Reiniciar");

        etiMayor = new JLabel("Mayor: ");
        etiSuma = new JLabel("Suma: ");
        etiMedia = new JLabel("Media: ");
        etiCuenta = new JLabel("Cuenta: ");

        etiMayor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiSuma.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiMedia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiCuenta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnAcumular.addActionListener(e -> acumular());
        btnResultados.addActionListener(e -> mostrarResultados());
        btnReiniciar.addActionListener(e -> reiniciar());

        add(txtNumero);
        add(btnAcumular);
        add(btnResultados);
        add(btnReiniciar);
        add(etiMayor);
        add(etiSuma);
        add(etiMedia);
        add(etiCuenta);
    }

    private void acumular() {
        try {
            double num = Double.parseDouble(txtNumero.getText());
            if (num >= 0) {
                suma += num;
                cuenta++;
                if (num > mayor) {
                    mayor = num;
                }
                txtNumero.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Solo se permiten números positivos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
        }
    }

    private void mostrarResultados() {
        if (cuenta > 0) {
            etiMayor.setText("Mayor: " + mayor);
            etiSuma.setText("Suma: " + suma);
            etiMedia.setText("Media: " + (suma / cuenta));
            etiCuenta.setText("Cuenta: " + cuenta);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha introducido ningún número.");
        }
    }

    private void reiniciar() {
        mayor = 0;
        suma = 0;
        cuenta = 0;

        etiMayor.setText("Mayor: ");
        etiSuma.setText("Suma: ");
        etiMedia.setText("Media: ");
        etiCuenta.setText("Cuenta: ");
        txtNumero.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AcumuladorNumeros().setVisible(true);
        });
    }
}
