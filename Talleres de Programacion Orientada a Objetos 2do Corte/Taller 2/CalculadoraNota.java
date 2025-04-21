import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraNota extends JFrame implements ActionListener {
    private JTextField txtPrimerTrimestre, txtSegundoTrimestre, txtTercerTrimestre;
    private JLabel etiNotaFinal, etiResultado;
    private JButton btnCalcular;

    public CalculadoraNota() {
        setLayout(new GridLayout(6, 2));
        
        add(new JLabel("Primer trimestre:"));
        txtPrimerTrimestre = new JTextField();
        add(txtPrimerTrimestre);
        
        add(new JLabel("Segundo trimestre:"));
        txtSegundoTrimestre = new JTextField();
        add(txtSegundoTrimestre);
        
        add(new JLabel("Tercer trimestre:"));
        txtTercerTrimestre = new JTextField();
        add(txtTercerTrimestre);
        
        add(new JLabel("Nota final:"));
        etiNotaFinal = new JLabel("0.00");
        add(etiNotaFinal);
        
        add(new JLabel("Resultado:"));
        etiResultado = new JLabel("");
        add(etiResultado);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        setTitle("Calculadora de Nota Final");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double nota1 = Double.parseDouble(txtPrimerTrimestre.getText());
            double nota2 = Double.parseDouble(txtSegundoTrimestre.getText());
            double nota3 = Double.parseDouble(txtTercerTrimestre.getText());
            
            double notaFinal = (nota1 + nota2 + nota3) / 3;
            etiNotaFinal.setText(String.format("%.2f", notaFinal));
            
            if (notaFinal < 5) {
                etiResultado.setText("SUSPENSO");
                etiNotaFinal.setForeground(Color.RED);
                etiResultado.setForeground(Color.RED);
            } else {
                etiResultado.setText("APROBADO");
                etiNotaFinal.setForeground(Color.BLACK);
                etiResultado.setForeground(Color.BLACK);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos");
        }
    }

    public static void main(String[] args) {
        new CalculadoraNota();
    }
}