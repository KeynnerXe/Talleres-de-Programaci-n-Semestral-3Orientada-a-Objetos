import javax.swing.*;
import java.awt.event.*;

public class IMCApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora IMC");
        JTextField txtPeso = new JTextField();
        JTextField txtTalla = new JTextField();
        JButton btnCalcular = new JButton("Calcular");
        JButton btnLimpiar = new JButton("Limpiar");
        JLabel etiIMC = new JLabel("IMC:");

        txtPeso.setBounds(20, 20, 150, 30);
        txtTalla.setBounds(20, 60, 150, 30);
        btnCalcular.setBounds(20, 100, 100, 30);
        btnLimpiar.setBounds(130, 100, 100, 30);
        etiIMC.setBounds(20, 140, 200, 30);

        frame.add(txtPeso);
        frame.add(txtTalla);
        frame.add(btnCalcular);
        frame.add(btnLimpiar);
        frame.add(etiIMC);

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(txtPeso.getText());
                    double talla = Double.parseDouble(txtTalla.getText());

                    double imc = peso / (talla * talla);
                    etiIMC.setText("IMC: " + String.format("%.2f", imc));

                    String mensaje;
                    if (imc < 18) mensaje = "Anorexia";
                    else if (imc < 20) mensaje = "Delgadez";
                    else if (imc < 27) mensaje = "Normalidad";
                    else if (imc < 30) mensaje = "Obesidad (grado 1)";
                    else if (imc < 35) mensaje = "Obesidad (grado 2)";
                    else if (imc < 40) mensaje = "Obesidad (grado 3)";
                    else mensaje = "Obesidad mórbida";

                    JOptionPane.showMessageDialog(null, "Su IMC indica que tiene: " + mensaje);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores válidos");
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar los datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    txtPeso.setText("");
                    txtTalla.setText("");
                    etiIMC.setText("IMC:");
                }
            }
        });
    }
}
