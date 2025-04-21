import javax.swing.*;

public class ContarVocalesApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contador de Vocales");
        JTextField txtFrase = new JTextField();
        JButton btnAnalizar = new JButton("Analizar");
        JLabel lblA = new JLabel();
        JLabel lblE = new JLabel();
        JLabel lblI = new JLabel();
        JLabel lblO = new JLabel();
        JLabel lblU = new JLabel();

        txtFrase.setBounds(20, 20, 300, 30);
        btnAnalizar.setBounds(20, 60, 100, 30);
        lblA.setBounds(20, 100, 300, 20);
        lblE.setBounds(20, 130, 300, 20);
        lblI.setBounds(20, 160, 300, 20);
        lblO.setBounds(20, 190, 300, 20);
        lblU.setBounds(20, 220, 300, 20);

        frame.add(txtFrase);
        frame.add(btnAnalizar);
        frame.add(lblA);
        frame.add(lblE);
        frame.add(lblI);
        frame.add(lblO);
        frame.add(lblU);

        frame.setSize(400, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        btnAnalizar.addActionListener(e -> {
            String frase = txtFrase.getText();
            if (frase.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Debe ingresar una frase.");
                return;
            }

            frase = frase.toLowerCase();
            int a = 0, eCount = 0, i = 0, o = 0, u = 0;

            for (char c : frase.toCharArray()) {
                switch (c) {
                    case 'a' -> a++;
                    case 'e' -> eCount++;
                    case 'i' -> i++;
                    case 'o' -> o++;
                    case 'u' -> u++;
                }
            }

            lblA.setText("Cantidad de 'a': " + a);
            lblE.setText("Cantidad de 'e': " + eCount);
            lblI.setText("Cantidad de 'i': " + i);
            lblO.setText("Cantidad de 'o': " + o);
            lblU.setText("Cantidad de 'u': " + u);
        });
    }
}
