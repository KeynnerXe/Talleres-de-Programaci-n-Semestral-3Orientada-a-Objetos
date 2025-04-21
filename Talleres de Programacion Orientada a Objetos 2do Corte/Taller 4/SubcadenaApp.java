import javax.swing.*;

public class SubcadenaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Buscar Subcadena");
        JTextField txtFrase = new JTextField();
        JTextField txtSubcadena = new JTextField();
        JButton btnAnalizar = new JButton("Analizar");
        JLabel lblInicio = new JLabel();
        JLabel lblFin = new JLabel();
        JLabel lblAntes = new JLabel();
        JLabel lblDespues = new JLabel();

        txtFrase.setBounds(20, 20, 400, 30);
        txtSubcadena.setBounds(20, 60, 200, 30);
        btnAnalizar.setBounds(20, 100, 100, 30);
        lblInicio.setBounds(20, 140, 400, 20);
        lblFin.setBounds(20, 170, 400, 20);
        lblAntes.setBounds(20, 200, 400, 20);
        lblDespues.setBounds(20, 230, 400, 20);

        frame.add(txtFrase);
        frame.add(txtSubcadena);
        frame.add(btnAnalizar);
        frame.add(lblInicio);
        frame.add(lblFin);
        frame.add(lblAntes);
        frame.add(lblDespues);

        frame.setSize(500, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText();
            String palabra = txtSubcadena.getText();

            int posInicio = frase.indexOf(palabra);
            int posFin = frase.lastIndexOf(palabra);

            if (posInicio == -1) {
                JOptionPane.showMessageDialog(null, "La palabra no se encuentra en la frase.");
                lblInicio.setText("");
                lblFin.setText("");
                lblAntes.setText("");
                lblDespues.setText("");
            } else {
                lblInicio.setText("Posición inicial: " + posInicio);
                lblFin.setText("Posición final: " + posFin);
                lblAntes.setText("Texto anterior: " + frase.substring(0, posInicio).trim());
                lblDespues.setText("Texto posterior: " + frase.substring(posFin + palabra.length()).trim());
            }
        });
    }
}
