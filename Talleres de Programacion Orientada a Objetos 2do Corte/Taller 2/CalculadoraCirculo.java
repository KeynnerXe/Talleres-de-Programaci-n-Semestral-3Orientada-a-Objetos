import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraCirculo extends JFrame {
    private JTextField txtRadio;
    private JLabel etiArea, etiPerimetro;

    public CalculadoraCirculo() {
        setLayout(new GridLayout(4, 2));
        
        add(new JLabel("Radio:"));
        txtRadio = new JTextField();
        txtRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        add(txtRadio);
        
        add(new JLabel("Área:"));
        etiArea = new JLabel("");
        add(etiArea);
        
        add(new JLabel("Perímetro:"));
        etiPerimetro = new JLabel("");
        add(etiPerimetro);
        
        setTitle("Calculadora de Círculo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void calcular() {
        try {
            double radio = Double.parseDouble(txtRadio.getText());
            
            if (radio < 0) {
                etiArea.setText("Error");
                etiArea.setForeground(Color.RED);
                etiPerimetro.setText("Error");
                etiPerimetro.setForeground(Color.RED);
            } else {
                double area = Math.PI * Math.pow(radio, 2);
                double perimetro = 2 * Math.PI * radio;
                
                etiArea.setText(String.format("%.2f", area));
                etiArea.setForeground(Color.BLACK);
                etiPerimetro.setText(String.format("%.2f", perimetro));
                etiPerimetro.setForeground(Color.BLACK);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un valor numérico válido");
        }
    }

    public static void main(String[] args) {
        new CalculadoraCirculo();
    }
}