import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraPotencias extends JFrame implements ActionListener {
    private JTextField txtBase, txtExponente;
    private JLabel etiResultado;
    private JButton btnCalcular;

    public CalculadoraPotencias() {
        setLayout(new GridLayout(4, 2));
        
        add(new JLabel("Base:"));
        txtBase = new JTextField();
        add(txtBase);
        
        add(new JLabel("Exponente:"));
        txtExponente = new JTextField();
        add(txtExponente);
        
        add(new JLabel("Resultado:"));
        etiResultado = new JLabel("");
        add(etiResultado);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        setTitle("Calculadora de Potencias");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double base = Double.parseDouble(txtBase.getText());
            double exponente = Double.parseDouble(txtExponente.getText());
            
            double resultado = Math.pow(base, exponente);
            etiResultado.setText(String.format("%.2f", resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos");
        }
    }

    public static void main(String[] args) {
        new CalculadoraPotencias();
    }
}