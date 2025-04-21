import javax.swing.*;

public class SubcadenaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Subcadena con Excepciones");
        JTextField txtFrase = new JTextField();
        JTextField txtPosIni = new JTextField();
        JTextField txtPosFin = new JTextField();
        JButton btnAnalizar = new JButton("Analizar");
        JLabel etiSubcadena = new JLabel();

        txtFrase.setBounds(20, 20, 300, 30);
        txtPosIni.setBounds(20, 60, 100, 30);
        txtPosFin.setBounds(130, 60, 100, 30);
        btnAnalizar.setBounds(240, 60, 100, 30);
        etiSubcadena.setBounds(20, 100, 400, 30);

        frame.setLayout(null);
        frame.setSize(450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(txtFrase);
        frame.add(txtPosIni);
        frame.add(txtPosFin);
        frame.add(btnAnalizar);
        frame.add(etiSubcadena);

        btnAnalizar.addActionListener(e -> {
            try {
                String frase = txtFrase.getText();
                if (frase.isEmpty()) throw new Exception("La frase está vacía.");

                int ini = Integer.parseInt(txtPosIni.getText());
                int fin = Integer.parseInt(txtPosFin.getText());

                String sub = frase.substring(ini, fin);
                etiSubcadena.setText("Subcadena: " + sub);
            } catch (StringIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Posiciones fuera de rango.\n" + ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Ingrese solo números válidos en las posiciones.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Excepción: " + ex.getMessage());
            }
        });
    }
}
