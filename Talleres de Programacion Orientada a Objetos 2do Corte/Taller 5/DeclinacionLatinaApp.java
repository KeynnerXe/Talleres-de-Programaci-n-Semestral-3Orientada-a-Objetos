import javax.swing.*;

public class DeclinacionLatinaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Declinación Latina");
        JTextField txtPalabra = new JTextField();
        JButton btnDeclinar = new JButton("Declinar");

        JLabel[] casos = new JLabel[12];
        String[] nombres = {
            "NOMINATIVO SINGULAR", "NOMINATIVO PLURAL",
            "VOCATIVO SINGULAR", "VOCATIVO PLURAL",
            "ACUSATIVO SINGULAR", "ACUSATIVO PLURAL",
            "GENITIVO SINGULAR", "GENITIVO PLURAL",
            "DATIVO SINGULAR", "DATIVO PLURAL",
            "ABLATIVO SINGULAR", "ABLATIVO PLURAL"
        };

        txtPalabra.setBounds(20, 20, 300, 30);
        btnDeclinar.setBounds(20, 60, 100, 30);
        frame.add(txtPalabra);
        frame.add(btnDeclinar);

        for (int i = 0; i < 12; i++) {
            casos[i] = new JLabel();
            casos[i].setBounds(20, 100 + (i * 25), 400, 20);
            frame.add(casos[i]);
        }

        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnDeclinar.addActionListener(e -> {
            String palabra = txtPalabra.getText().toLowerCase().trim();
            if (!palabra.endsWith("a")) {
                JOptionPane.showMessageDialog(frame, "La palabra no pertenece a la primera declinación.");
                return;
            }

            String base = palabra.substring(0, palabra.length() - 1);

            String[] resultados = {
                palabra, base + "ae",  // NOM
                palabra, base + "ae",  // VOC
                base + "am", base + "as",  // ACU
                base + "ae", base + "arum",  // GEN
                base + "ae", base + "is",    // DAT
                palabra, base + "is"         // ABL
            };

            for (int i = 0; i < 12; i++) {
                casos[i].setText(nombres[i] + ": " + capitalize(resultados[i]));
            }
        });
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
