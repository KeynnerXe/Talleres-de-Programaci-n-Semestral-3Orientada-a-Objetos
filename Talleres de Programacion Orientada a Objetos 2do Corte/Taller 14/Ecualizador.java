import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ecualizador extends JFrame {

    private JLabel[] etiFrecuencia = new JLabel[5];
    private JScrollBar[] desFrecuencia = new JScrollBar[5];
    private JCheckBox[] chkFrecuencia = new JCheckBox[5];
    private JRadioButton optPelicula, optConcierto, optPlano;
    private ButtonGroup grupoEcualizacion;

    public Ecualizador() {
        initComponents();
        configurarVentana();
    }

    private void initComponents() {
        // Inicializar componentes
        for (int i = 0; i < 5; i++) {
            etiFrecuencia[i] = new JLabel("5"); // Inicialmente a 5
            etiFrecuencia[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            desFrecuencia[i] = new JScrollBar(JScrollBar.VERTICAL, 5, 0, 0, 11); // 0-10, initial 5
            chkFrecuencia[i] = new JCheckBox("Bloquear");
        }

        optPelicula = new JRadioButton("Película");
        optConcierto = new JRadioButton("Concierto");
        optPlano = new JRadioButton("Plano");
        grupoEcualizacion = new ButtonGroup();
        grupoEcualizacion.add(optPelicula);
        grupoEcualizacion.add(optConcierto);
        grupoEcualizacion.add(optPlano);
        optPlano.setSelected(true); // Opción Plano seleccionada por defecto

        JPanel panelOpciones = new JPanel(new GridLayout(3, 1));
        panelOpciones.add(optPelicula);
        panelOpciones.add(optConcierto);
        panelOpciones.add(optPlano);
        panelOpciones.setBorder(new TitledBorder("Opciones de Ecualización"));

        // Configurar Listeners
        for (int i = 0; i < 5; i++) {
            final int index = i; // Necesario para acceder a 'i' dentro del listener

            desFrecuencia[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    etiFrecuencia[index].setText(String.valueOf(desFrecuencia[index].getValue()));
                }
            });

            chkFrecuencia[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    desFrecuencia[index].setEnabled(!chkFrecuencia[index].isSelected());
                }
            });
        }

        optPelicula.addActionListener(new EcualizacionListener());
        optConcierto.addActionListener(new EcualizacionListener());
        optPlano.addActionListener(new EcualizacionListener());


        // Diseño del Layout
        setLayout(new FlowLayout());

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(etiFrecuencia[i], BorderLayout.NORTH);
            panel.add(desFrecuencia[i], BorderLayout.CENTER);
            panel.add(chkFrecuencia[i], BorderLayout.SOUTH);
            add(panel);
        }
        add(panelOpciones);
    }

    private void configurarVentana() {
        setTitle("Ecualizador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300); // Tamaño de la ventana adecuado
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class EcualizacionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == optPelicula) {
                setFrecuencias(2, 5, 8, 5, 2);
            } else if (e.getSource() == optConcierto) {
                setFrecuencias(9, 5, 1, 5, 9);
            } else if (e.getSource() == optPlano) {
                setFrecuencias(5, 5, 5, 5, 5);
            }
        }

        private void setFrecuencias(int f1, int f2, int f3, int f4, int f5) {
            desFrecuencia[0].setValue(f1);
            desFrecuencia[1].setValue(f2);
            desFrecuencia[2].setValue(f3);
            desFrecuencia[3].setValue(f4);
            desFrecuencia[4].setValue(f5);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ecualizador();
            }
        });
    }
}