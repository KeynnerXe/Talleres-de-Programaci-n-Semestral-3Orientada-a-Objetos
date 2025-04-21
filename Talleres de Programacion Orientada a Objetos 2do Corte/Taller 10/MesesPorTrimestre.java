import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MesesPorTrimestre extends JFrame {
    JList<String> lstMeses;
    DefaultListModel<String> modeloMeses;
    JRadioButton optTri1, optTri2, optTri3, optTri4;
    JButton btnRellenar, btnVaciar;
    JLabel etiMes;

    public MesesPorTrimestre() {
        setTitle("Meses por Trimestre");
        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Lista de meses
        modeloMeses = new DefaultListModel<>();
        lstMeses = new JList<>(modeloMeses);
        JScrollPane scroll = new JScrollPane(lstMeses);
        scroll.setBounds(20, 20, 150, 100);
        add(scroll);

        // Panel de trimestres
        JPanel panelTrimestres = new JPanel();
        panelTrimestres.setBorder(BorderFactory.createTitledBorder("Trimestres"));
        panelTrimestres.setLayout(new GridLayout(4, 1));
        panelTrimestres.setBounds(200, 20, 150, 120);

        optTri1 = new JRadioButton("Trimestre 1");
        optTri2 = new JRadioButton("Trimestre 2");
        optTri3 = new JRadioButton("Trimestre 3");
        optTri4 = new JRadioButton("Trimestre 4");

        ButtonGroup grupoTrimestres = new ButtonGroup();
        grupoTrimestres.add(optTri1);
        grupoTrimestres.add(optTri2);
        grupoTrimestres.add(optTri3);
        grupoTrimestres.add(optTri4);

        panelTrimestres.add(optTri1);
        panelTrimestres.add(optTri2);
        panelTrimestres.add(optTri3);
        panelTrimestres.add(optTri4);

        add(panelTrimestres);

        // Botones
        btnRellenar = new JButton("Rellenar");
        btnRellenar.setBounds(60, 140, 100, 30);
        add(btnRellenar);

        btnVaciar = new JButton("Vaciar");
        btnVaciar.setBounds(200, 160, 100, 30);
        add(btnVaciar);

        // Etiqueta resultado
        etiMes = new JLabel("Mes seleccionado", SwingConstants.CENTER);
        etiMes.setBorder(new LineBorder(Color.BLACK));
        etiMes.setBounds(100, 210, 180, 40);
        add(etiMes);

        // Eventos
        btnRellenar.addActionListener(e -> rellenarMeses());
        btnVaciar.addActionListener(e -> modeloMeses.clear());

        lstMeses.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                etiMes.setText(lstMeses.getSelectedValue());
            }
        });
    }

    private void rellenarMeses() {
        modeloMeses.clear();
        if (optTri1.isSelected()) {
            modeloMeses.addElement("Enero");
            modeloMeses.addElement("Febrero");
            modeloMeses.addElement("Marzo");
        } else if (optTri2.isSelected()) {
            modeloMeses.addElement("Abril");
            modeloMeses.addElement("Mayo");
            modeloMeses.addElement("Junio");
        } else if (optTri3.isSelected()) {
            modeloMeses.addElement("Julio");
            modeloMeses.addElement("Agosto");
            modeloMeses.addElement("Septiembre");
        } else if (optTri4.isSelected()) {
            modeloMeses.addElement("Octubre");
            modeloMeses.addElement("Noviembre");
            modeloMeses.addElement("Diciembre");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un trimestre", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MesesPorTrimestre().setVisible(true));
    }
}
