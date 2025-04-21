import javax.swing.*;

public class CompararCadenasApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparar Frases");
        JTextField txtFrase = new JTextField();
        JTextField txtPalabra1 = new JTextField();
        JTextField txtPalabra2 = new JTextField();
        JTextField txtPalabra3 = new JTextField();
        JTextField txtPalabra4 = new JTextField();
        JButton btnAnalizar = new JButton("Analizar");

        JLabel lblIgual = new JLabel();
        JLabel lblEmpieza = new JLabel();
        JLabel lblTermina = new JLabel();
        JLabel lblContiene = new JLabel();

        txtFrase.setBounds(20, 20, 400, 30);
        txtPalabra1.setBounds(20, 60, 200, 30);
        txtPalabra2.setBounds(20, 100, 200, 30);
        txtPalabra3.setBounds(20, 140, 200, 30);
        txtPalabra4.setBounds(20, 180, 200, 30);
        btnAnalizar.setBounds(20, 220, 100, 30);

        lblIgual.setBounds(20, 260, 400, 20);
        lblEmpieza.setBounds(20, 290, 400, 20);
        lblTermina.setBounds(20, 320, 400, 20);
        lblContiene.setBounds(20, 350, 400, 20);

        frame.add(txtFrase);
        frame.add(txtPalabra1);
        frame.add(txtPalabra2);
        frame.add(txtPalabra3);
        frame.add(txtPalabra4);
        frame.add(btnAnalizar);
        frame.add(lblIgual);
        frame.add(lblEmpieza);
        frame.add(lblTermina);
        frame.add(lblContiene);

        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText();
            String p1 = txtPalabra1.getText();
            String p2 = txtPalabra2.getText();
            String p3 = txtPalabra3.getText();
            String p4 = txtPalabra4.getText();

            lblIgual.setText("¿Frase igual a palabra1?: " + frase.equals(p1));
            lblEmpieza.setText("¿Empieza por palabra2?: " + frase.startsWith(p2));
            lblTermina.setText("¿Termina por palabra3?: " + frase.endsWith(p3));

            if (frase.contains(p4)) {
                lblContiene.setText("Contiene palabra4 en posición: " + frase.indexOf(p4));
            } else {
                lblContiene.setText("No contiene palabra4.");
            }
        });
    }
}
