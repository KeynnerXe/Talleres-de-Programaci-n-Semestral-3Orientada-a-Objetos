import javax.swing.*;

public class PrepararDNIApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Preparar DNI");
        JTextField txtDNI = new JTextField();
        JButton btnPreparar = new JButton("Preparar DNI");
        JLabel etiDNI = new JLabel();

        txtDNI.setBounds(20, 20, 300, 30);
        btnPreparar.setBounds(20, 60, 150, 30);
        etiDNI.setBounds(20, 100, 300, 30);

        frame.add(txtDNI);
        frame.add(btnPreparar);
        frame.add(etiDNI);

        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnPreparar.addActionListener(e -> {
            String dni = txtDNI.getText();
            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Debe ingresar un DNI.");
                return;
            }

            // Quitar espacios, puntos, guiones
            String limpio = dni.replaceAll("[.\\-\\s]", "");
            etiDNI.setText("DNI Preparado: " + limpio);
        });
    }
}
