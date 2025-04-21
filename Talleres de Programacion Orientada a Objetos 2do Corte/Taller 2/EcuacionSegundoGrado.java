import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcuacionSegundoGrado extends JFrame implements ActionListener {
    private JTextField txtA, txtB, txtC;
    private JLabel etiResultado;
    private JButton btnCalcular;

    public EcuacionSegundoGrado() {
        setLayout(new GridLayout(5, 2));
        
        add(new JLabel("Coeficiente a:"));
        txtA = new JTextField();
        add(txtA);
        
        add(new JLabel("Coeficiente b:"));
        txtB = new JTextField();
        add(txtB);
        
        add(new JLabel("Coeficiente c:"));
        txtC = new JTextField();
        add(txtC);
        
        add(new JLabel("Soluciones:"));
        etiResultado = new JLabel("");
        etiResultado.setPreferredSize(new Dimension(200, 50));
        add(etiResultado);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        setTitle("Ecuación de Segundo Grado");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());
            
            if (a == 0) {
                etiResultado.setText("No es ecuación de segundo grado (a=0)");
                return;
            }
            
            double discriminante = Math.pow(b, 2) - 4 * a * c;
            
            if (discriminante < 0) {
                etiResultado.setText("No tiene soluciones reales");
            } else if (discriminante == 0) {
                double x = -b / (2 * a);
                etiResultado.setText("Solución única: x = " + String.format("%.2f", x));
            } else {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                etiResultado.setText("<html>Soluciones:<br>x1 = " + String.format("%.2f", x1) + 
                                   "<br>x2 = " + String.format("%.2f", x2) + "</html>");
            }
        } catch (NumberFormatException ex) {
            etiResultado.setText("Ingrese valores numéricos válidos");
        }
    }

    public static void main(String[] args) {
        new EcuacionSegundoGrado();
    }
}