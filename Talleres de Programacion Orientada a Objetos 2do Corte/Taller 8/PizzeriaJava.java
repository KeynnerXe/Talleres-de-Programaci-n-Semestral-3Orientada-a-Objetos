import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PizzeriaJava extends JFrame {

    JCheckBox chkBacon, chkAnchoas, chkCebolla, chkPimiento;
    JRadioButton optPequenia, optMediana, optFamiliar;
    JButton btnTotal;
    JLabel etiResultado;
    ButtonGroup grupoTamanos;

    public PizzeriaJava() {
        setTitle("PIZZERÍA JAVA");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        // Panel de Ingredientes
        JPanel panelIngredientes = new JPanel();
        panelIngredientes.setLayout(new GridLayout(4, 1));
        panelIngredientes.setBorder(new TitledBorder("Ingredientes"));
        panelIngredientes.setBounds(20, 20, 150, 120);

        chkBacon = new JCheckBox("Bacon");
        chkAnchoas = new JCheckBox("Anchoas");
        chkCebolla = new JCheckBox("Cebolla");
        chkPimiento = new JCheckBox("Pimiento");

        panelIngredientes.add(chkBacon);
        panelIngredientes.add(chkAnchoas);
        panelIngredientes.add(chkCebolla);
        panelIngredientes.add(chkPimiento);

        add(panelIngredientes);

        // Panel de Tamaños
        JPanel panelTamanos = new JPanel();
        panelTamanos.setLayout(new GridLayout(3, 1));
        panelTamanos.setBorder(new TitledBorder("Tamaño"));
        panelTamanos.setBounds(200, 20, 150, 100);

        optPequenia = new JRadioButton("Pequeña");
        optMediana = new JRadioButton("Mediana");
        optFamiliar = new JRadioButton("Familiar", true); // por defecto

        grupoTamanos = new ButtonGroup();
        grupoTamanos.add(optPequenia);
        grupoTamanos.add(optMediana);
        grupoTamanos.add(optFamiliar);

        panelTamanos.add(optPequenia);
        panelTamanos.add(optMediana);
        panelTamanos.add(optFamiliar);

        add(panelTamanos);

        // Botón Total
        btnTotal = new JButton("Total");
        btnTotal.setBounds(140, 160, 100, 30);
        add(btnTotal);

        // Etiqueta de resultado
        etiResultado = new JLabel("Total: 0.00 €", SwingConstants.CENTER);
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiResultado.setBounds(100, 210, 200, 40);
        add(etiResultado);

        // Evento botón Total
        btnTotal.addActionListener(e -> calcularPrecio());

        // Confirmación al cerrar
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void calcularPrecio() {
        double total = 0;

        // Precio base según tamaño
        if (optPequenia.isSelected()) total += 7;
        else if (optMediana.isSelected()) total += 9;
        else if (optFamiliar.isSelected()) total += 11;

        // Ingredientes
        if (chkBacon.isSelected()) total += 1.50;
        if (chkAnchoas.isSelected()) total += 1.80;
        if (chkCebolla.isSelected()) total += 1.00;
        if (chkPimiento.isSelected()) total += 1.20;

        etiResultado.setText(String.format("Total: %.2f €", total));
    }

    public static void main(String[] args) {
        // Mostrar mensaje inicial
        JOptionPane.showMessageDialog(null, "PIZZERÍA JAVA\nDesarrollado por [Tu Nombre]", "Información", JOptionPane.INFORMATION_MESSAGE);

        // Mostrar ventana
        SwingUtilities.invokeLater(() -> {
            new PizzeriaJava().setVisible(true);
        });
    }
}
