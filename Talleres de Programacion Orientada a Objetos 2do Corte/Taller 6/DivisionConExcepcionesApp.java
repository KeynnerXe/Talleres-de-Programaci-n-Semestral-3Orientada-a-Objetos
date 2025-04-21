import javax.swing.*;

public class DivisionConExcepcionesApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("División y Resto");
        JTextField txtNum1 = new JTextField(), txtNum2 = new JTextField();
        JButton btnCalcular = new JButton("Calcular");

        JLabel resultado = new JLabel();

        txtNum1.setBounds(20, 20, 100, 30);
        txtNum2.setBounds(130, 20, 100, 30);
        btnCalcular.setBounds(240, 20, 100, 30);
        resultado.setBounds(20, 70, 400, 30);

        frame.setLayout(null);
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(txtNum1); frame.add(txtNum2);
        frame.add(btnCalcular); frame.add(resultado);

        btnCalcular.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(txtNum1.getText());
                int n2 = Integer.parseInt(txtNum2.getText());

                if (n1 < 0 || n1 > 100 || n2 < 0 || n2 > 100) {
                    throw new NumeroFueraDeRangoException("Número fuera del rango permitido (0-100)");
                }

                int mayor = Math.max(n1, n2);
                int menor = Math.min(n1, n2);
                int division = mayor / menor;
                int resto = mayor % menor;

                resultado.setText("División: " + division + " | Resto: " + resto);
            } catch (NumeroFueraDeRangoException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Rango Inválido", JOptionPane.WARNING_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, "No se puede dividir entre cero.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese números válidos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Excepción: " + ex.getMessage());
            }
        });
    }
}

class NumeroFueraDeRangoException extends Exception {
    public NumeroFueraDeRangoException(String mensaje) {
        super(mensaje);
    }
}
