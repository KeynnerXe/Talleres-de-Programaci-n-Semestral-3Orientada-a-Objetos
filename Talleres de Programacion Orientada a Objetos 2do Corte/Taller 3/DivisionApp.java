import javax.swing.*;
import java.awt.event.*;

public class DivisionApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("División");
        JTextField txtA = new JTextField();
        JTextField txtB = new JTextField();
        JButton btnDivision = new JButton("Calcular División");
        JLabel etiResultado = new JLabel("Resultado:");

        txtA.setBounds(20, 20, 100, 30);
        txtB.setBounds(20, 60, 100, 30);
        btnDivision.setBounds(20, 100, 150, 30);
        etiResultado.setBounds(20, 140, 200, 30);

        frame.add(txtA);
        frame.add(txtB);
        frame.add(btnDivision);
        frame.add(etiResultado);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());

                    if (a < 0 || b < 0) {
                        JOptionPane.showMessageDialog(null, "Los valores no pueden ser negativos");
                    } else if (b == 0) {
                        JOptionPane.showMessageDialog(null, "No se puede dividir entre cero");
                    } else {
                        double resultado = a / b;
                        etiResultado.setText("Resultado: " + resultado);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos");
                }
            }
        });
    }
}
