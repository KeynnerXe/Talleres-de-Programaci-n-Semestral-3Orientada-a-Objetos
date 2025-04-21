import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraRaiz extends JFrame {
    private JTextField txtNumero;
    private JLabel etiRaiz;

    public CalculadoraRaiz() {
        setLayout(new GridLayout(2, 2));
        
        add(new JLabel("Número:"));
        txtNumero = new JTextField();
        txtNumero.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                calcularRaiz();
            }
        });
        add(txtNumero);
        
        add(new JLabel("Raíz cuadrada:"));
        etiRaiz = new JLabel("");
        add(etiRaiz);
        
        setTitle("Calculadora de Raíz Cuadrada");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void calcularRaiz() {
        try {
            double numero = Double.parseDouble(txtNumero.getText());
            
            if (numero < 0) {
                etiRaiz.setText("Error: número negativo");
                etiRaiz.setForeground(Color.RED);
            } else {
                double raiz = Math.sqrt(numero);
                etiRaiz.setText(String.format("%.4f", raiz));
                etiRaiz.setForeground(Color.BLACK);
            }
        } catch (NumberFormatException ex) {
            etiRaiz.setText("Ingrese un número");
            etiRaiz.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        new CalculadoraRaiz();
    }
}