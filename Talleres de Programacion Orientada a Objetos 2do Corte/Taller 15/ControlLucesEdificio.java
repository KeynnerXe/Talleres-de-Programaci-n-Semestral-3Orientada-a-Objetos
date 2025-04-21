import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;

public class ControlLucesEdificio extends JFrame {

    private JCheckBox[][] chkLuces = new JCheckBox[3][3]; // [Oficina][Luz: Principal1, Principal2, Seguridad]
    private JPanel[] panOficinas = new JPanel[3];
    private JMenuBar menuBar;
    private JMenu menuActivacion, menuInfo;
    private JMenuItem itemApagarTodas, itemEncenderTodas, itemSalir;
    private JMenu menuDia, menuNoche;
    private JMenuItem[] itemDiaOficina = new JMenuItem[3];
    private JMenuItem itemDiaTodas, itemNocheTodas;
    private JMenuItem[] itemNocheOficina = new JMenuItem[3];
    private JMenuItem itemPrincipales, itemSecundarias, itemSeguridad, itemAcercaDe;


    public ControlLucesEdificio() {
        initComponents();
        configurarVentana();
    }

    private void initComponents() {
        // Inicializar Checkboxes
        for (int i = 0; i < 3; i++) {
            chkLuces[i] = new JCheckBox[3];
            chkLuces[i][0] = new JCheckBox("Principal 1");
            chkLuces[i][1] = new JCheckBox("Principal 2");
            chkLuces[i][2] = new JCheckBox("Seguridad");
        }

        // Inicializar Paneles de Oficina
        for (int i = 0; i < 3; i++) {
            panOficinas[i] = new JPanel(new GridLayout(4, 1)); // Layout para 3 luces + título
            panOficinas[i].add(new JLabel("Oficina " + (i + 1))); // Título del panel
            for (int j = 0; j < 3; j++) {
                panOficinas[i].add(chkLuces[i][j]);
            }
            panOficinas[i].setBorder(new TitledBorder("Oficina " + (i + 1))); // Borde con título
        }

        // Inicializar Menú
        menuBar = new JMenuBar();
        menuActivacion = new JMenu("Activación");
        menuInfo = new JMenu("Info");

        // Opciones de Activación
        itemApagarTodas = new JMenuItem("Apagar Todas");
        itemEncenderTodas = new JMenuItem("Encender Todas");
        menuDia = new JMenu("Día");
        menuNoche = new JMenu("Noche");
        itemSalir = new JMenuItem("Salir");

        //Subopciones de Día y Noche
        for (int i = 0; i < 3; i++) {
            itemDiaOficina[i] = new JMenuItem("Oficina " + (i + 1));
            menuDia.add(itemDiaOficina[i]);
            itemNocheOficina[i] = new JMenuItem("Oficina " + (i + 1));
            menuNoche.add(itemNocheOficina[i]);
        }
        itemDiaTodas = new JMenuItem("Todas");
        menuDia.add(itemDiaTodas);
        itemNocheTodas = new JMenuItem("Todas");
        menuNoche.add(itemNocheTodas);


        menuActivacion.add(itemApagarTodas);
        menuActivacion.add(itemEncenderTodas);
        menuActivacion.add(menuDia);
        menuActivacion.add(menuNoche);
        menuActivacion.add(new JSeparator());
        menuActivacion.add(itemSalir);

        // Opciones de Info
        itemPrincipales = new JMenuItem("Principales");
        itemSecundarias = new JMenuItem("Secundarias");
        itemSeguridad = new JMenuItem("Seguridad");
        itemAcercaDe = new JMenuItem("Acerca de...");

        menuInfo.add(itemPrincipales);
        menuInfo.add(itemSecundarias);
        menuInfo.add(itemSeguridad);
        menuInfo.add(new JSeparator());
        menuInfo.add(itemAcercaDe);

        menuBar.add(menuActivacion);
        menuBar.add(menuInfo);

        setJMenuBar(menuBar); // Añadir la barra de menú a la ventana


        // Configurar Listeners
        itemApagarTodas.addActionListener(new ActivacionListener());
        itemEncenderTodas.addActionListener(new ActivacionListener());
        itemSalir.addActionListener(new ActivacionListener());

        for (int i = 0; i < 3; i++) {
            itemDiaOficina[i].addActionListener(new ActivacionListener());
            itemNocheOficina[i].addActionListener(new ActivacionListener());
        }
        itemDiaTodas.addActionListener(new ActivacionListener());
        itemNocheTodas.addActionListener(new ActivacionListener());

        itemPrincipales.addActionListener(new InfoListener());
        itemSecundarias.addActionListener(new InfoListener());
        itemSeguridad.addActionListener(new InfoListener());
        itemAcercaDe.addActionListener(new InfoListener());


        // Diseño del Layout
        setLayout(new FlowLayout());
        for (JPanel panOficina : panOficinas) {
            add(panOficina);
        }
    }

    private void configurarVentana() {
        setTitle("Control de Luces del Edificio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300); // Tamaño adecuado para mostrar los paneles
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Clase interna para manejar los eventos del menú "Activación"
    private class ActivacionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == itemApagarTodas) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        chkLuces[i][j].setSelected(false);
                    }
                }
            } else if (e.getSource() == itemEncenderTodas) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        chkLuces[i][j].setSelected(true);
                    }
                }
            } else if (e.getSource() == itemSalir) {
                System.exit(0);
            } else {
                // Manejar las opciones de Día y Noche
                for (int i = 0; i < 3; i++) {
                    if (e.getSource() == itemDiaOficina[i]) {
                        setLucesDia(i);
                        return;
                    } else if (e.getSource() == itemNocheOficina[i]) {
                        setLucesNoche(i);
                        return;
                    }
                }
                if (e.getSource() == itemDiaTodas) {
                    for (int i = 0; i < 3; i++) {
                        setLucesDia(i);
                    }
                } else if (e.getSource() == itemNocheTodas) {
                    for (int i = 0; i < 3; i++) {
                        setLucesNoche(i);
                    }
                }
            }
        }

        private void setLucesDia(int oficina) {
            chkLuces[oficina][0].setSelected(true); // Principal 1
            chkLuces[oficina][1].setSelected(true); // Principal 2
            chkLuces[oficina][2].setSelected(false); // Seguridad
        }

        private void setLucesNoche(int oficina) {
            chkLuces[oficina][0].setSelected(false); // Principal 1
            chkLuces[oficina][1].setSelected(false); // Principal 2
            chkLuces[oficina][2].setSelected(true); // Seguridad
        }
    }

    // Clase interna para manejar los eventos del menú "Info"
    private class InfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == itemPrincipales) {
                mostrarInfoLuces("Principales");
            } else if (e.getSource() == itemSecundarias) {
                mostrarInfoLuces("Secundarias");
            } else if (e.getSource() == itemSeguridad) {
                mostrarInfoLuces("Seguridad");
            } else if (e.getSource() == itemAcercaDe) {
                JOptionPane.showMessageDialog(ControlLucesEdificio.this, "Control de Luces del Edificio\nProgramador: [Tu Nombre]", "Acerca de...", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void mostrarInfoLuces(String tipoLuz) {
            int encendidas = 0;
            int apagadas = 0;
            for (int i = 0; i < 3; i++) {
                int indiceLuz = (tipoLuz.equals("Principal")) ? 0 : (tipoLuz.equals("Secundarias")) ? 1 : 2;
                if (tipoLuz.equals("Principales") || tipoLuz.equals("Secundarias")) {
                    if (chkLuces[i][0].isSelected()) encendidas++;
                    if (chkLuces[i][1].isSelected()) encendidas++;
                    if (!chkLuces[i][0].isSelected()) apagadas++;
                    if (!chkLuces[i][1].isSelected()) apagadas++;


                } else {
                    if (chkLuces[i][indiceLuz].isSelected()) {
                        encendidas++;
                    } else {
                        apagadas++;
                    }
                }
            }
            JOptionPane.showMessageDialog(ControlLucesEdificio.this,
                    "Luces " + tipoLuz + ": Encendidas = " + encendidas + ", Apagadas = " + apagadas,
                    "Info Luces " + tipoLuz, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ControlLucesEdificio();
            }
        });
    }
}