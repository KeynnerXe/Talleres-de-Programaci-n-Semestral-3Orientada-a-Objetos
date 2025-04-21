import javax.swing.*;

public class DistanciaPuntosApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Distancia entre puntos");
        JTextField txtX1 = new JTextField(), txtY1 = new JTextField();
        JTextField txtX2 = new JTextField(), txtY2 = new JTextField();
        JButton btnCalcular = new JButton("Calcular");

        JLabel resultado = new JLabel();

        txtX1.setBounds(20, 20, 80, 30);
        txtY1.setBounds(110, 20, 80, 30);
        txtX2.setBounds(200, 20, 80, 30);
        txtY2.setBounds(290, 20, 80, 30);
        btnCalcular.setBounds(380, 20, 100, 30);
        resultado.setBounds(20, 70, 400, 30);

        frame.setLayout(null);
        frame.setSize(520, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(txtX1); frame.add(txtY1);
        frame.add(txtX2); frame.add(txtY2);
        frame.add(btnCalcular); frame.add(resultado);

        btnCalcular.addActionListener(e -> {
            try {
                double x1 = Double.parseDouble(txtX1.getText());
                double y1 = Double.parseDouble(txtY1.getText());
                double x2 = Double.parseDouble(txtX2.getText());
                double y2 = Double.parseDouble(txtY2.getText());

                double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                resultado.setText("Distancia: " + distancia);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage() + "\nTipo: " + ex.getClass().getSimpleName());
            }
        });
    }
}
