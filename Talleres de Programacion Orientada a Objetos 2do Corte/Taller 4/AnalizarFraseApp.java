import javax.swing.*;

public class AnalizarFraseApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Análisis de Frase");
        JTextField txtFrase = new JTextField();
        JButton btnAnalizar = new JButton("Analizar");
        JLabel lblMayus = new JLabel();
        JLabel lblMinus = new JLabel();
        JLabel lblTotal = new JLabel();
        JLabel lblSinEspacios = new JLabel();

        txtFrase.setBounds(20, 20, 300, 30);
        btnAnalizar.setBounds(20, 60, 100, 30);
        lblMayus.setBounds(20, 100, 400, 20);
        lblMinus.setBounds(20, 130, 400, 20);
        lblTotal.setBounds(20, 160, 400, 20);
        lblSinEspacios.setBounds(20, 190, 400, 20);

        frame.add(txtFrase);
        frame.add(btnAnalizar);
        frame.add(lblMayus);
        frame.add(lblMinus);
        frame.add(lblTotal);
        frame.add(lblSinEspacios);

        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText();

            if (frase.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una frase.");
                return;
            }

            lblMayus.setText("Mayúsculas: " + frase.toUpperCase());
            lblMinus.setText("Minúsculas: " + frase.toLowerCase());
            lblTotal.setText("Nº de caracteres: " + frase.length());
            lblSinEspacios.setText("Sin espacios: " + frase.replace(" ", "").length());
        });
    }
}
