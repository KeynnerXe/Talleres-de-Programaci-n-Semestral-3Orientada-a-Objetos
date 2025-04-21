import javax.swing.*;
import java.awt.event.*;

public class SueldoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sueldo Total");
        JTextField txtSueldoBase = new JTextField();
        JTextField txtMeses = new JTextField();
        JButton btnCalcular = new JButton("Calcular");
        JLabel etiResultado = new JLabel("Total:");

        txtSueldoBase.setBounds(20, 20, 150, 30);
        txtMeses.setBounds(20, 60, 150, 30);
        btnCalcular.setBounds(20, 100, 150, 30);
        etiResultado.setBounds(20, 140, 200, 30);

        frame.add(txtSueldoBase);
        frame.add(txtMeses);
        frame.add(btnCalcular);
        frame.add(etiResultado);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pass = JOptionPane.showInputDialog("Introduzca la contraseña:");
                if (!"1234".equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    return;
                }

                try {
                    double sueldoBase = Double.parseDouble(txtSueldoBase.getText());
                    int meses = Integer.parseInt(txtMeses.getText());

                    double total = (sueldoBase - (sueldoBase * 0.1)) * meses;
                    etiResultado.setText("Total: " + total);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos");
                }
            }
        });
    }
}
