import java.awt.*;
import javax.swing.*;

public class ProgresionNumerica extends JFrame {
    JComboBox<String> cboProgresion;
    JTextField txtInicio, txtFin, txtIntervalo;
    JButton btnRellenar, btnVaciar;
    JLabel etiResultado;

    public ProgresionNumerica() {
        setTitle("Progresión");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblInicio = new JLabel("Inicio:");
        lblInicio.setBounds(30, 20, 50, 20);
        add(lblInicio);

        txtInicio = new JTextField();
        txtInicio.setBounds(80, 20, 80, 25);
        add(txtInicio);

        JLabel lblFin = new JLabel("Fin:");
        lblFin.setBounds(180, 20, 30, 20);
        add(lblFin);

        txtFin = new JTextField();
        txtFin.setBounds(210, 20, 80, 25);
        add(txtFin);

        JLabel lblIntervalo = new JLabel("Intervalo:");
        lblIntervalo.setBounds(30, 60, 70, 20);
        add(lblIntervalo);

        txtIntervalo = new JTextField();
        txtIntervalo.setBounds(100, 60, 80, 25);
        add(txtIntervalo);

        cboProgresion = new JComboBox<>();
        cboProgresion.setBounds(200, 60, 150, 25);
        add(cboProgresion);

        btnRellenar = new JButton("Rellenar");
        btnRellenar.setBounds(60, 100, 100, 30);
        add(btnRellenar);

        btnVaciar = new JButton("Vaciar");
        btnVaciar.setBounds(200, 100, 100, 30);
        add(btnVaciar);

        etiResultado = new JLabel("Resultado", SwingConstants.CENTER);
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiResultado.setBounds(100, 150, 200, 40);
        add(etiResultado);

        btnRellenar.addActionListener(e -> rellenarProgresion());
        btnVaciar.addActionListener(e -> cboProgresion.removeAllItems());

        cboProgresion.addActionListener(e -> {
            if (cboProgresion.getSelectedItem() != null)
                etiResultado.setText(cboProgresion.getSelectedItem().toString());
        });
    }

    private void rellenarProgresion() {
        try {
            int inicio = Integer.parseInt(txtInicio.getText());
            int fin = Integer.parseInt(txtFin.getText());
            int paso = Integer.parseInt(txtIntervalo.getText());

            if (inicio >= fin || paso <= 0) {
                throw new IllegalArgumentException();
            }

            cboProgresion.removeAllItems();
            for (int i = inicio; i < fin; i += paso) {
                cboProgresion.addItem(String.valueOf(i));
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben contener números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "El inicio debe ser menor que el fin y el intervalo mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgresionNumerica().setVisible(true));
    }
}
