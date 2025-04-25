/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller17;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class ControlLuces extends JFrame {
    JCheckBox[][] luces = new JCheckBox[3][3]; // [oficina][0=principal,1=secundaria,2=seguridad]

    public ControlLuces() {
        setTitle("Control de Luces");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3));

        for (int i = 0; i < 3; i++) {
            add(crearPanelOficina(i));
        }

        crearMenuContextual();
    }

    private JPanel crearPanelOficina(int index) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Oficina " + (index + 1)));

        luces[index][0] = new JCheckBox("Luz Principal");
        luces[index][1] = new JCheckBox("Luz Secundaria");
        luces[index][2] = new JCheckBox("Luz Seguridad");

        panel.add(luces[index][0]);
        panel.add(luces[index][1]);
        panel.add(luces[index][2]);

        return panel;
    }

    private void crearMenuContextual() {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem apagarTodas = new JMenuItem("Apagar Todas");
        apagarTodas.addActionListener(e -> cambiarTodas(false));
        menu.add(apagarTodas);

        JMenuItem encenderTodas = new JMenuItem("Encender Todas");
        encenderTodas.addActionListener(e -> cambiarTodas(true));
        menu.add(encenderTodas);

        menu.addSeparator();

        JMenuItem modoDia = new JMenuItem("Modo Día");
        modoDia.addActionListener(e -> {
            for (int i = 0; i < 3; i++) modoDia(i);
        });
        menu.add(modoDia);

        JMenuItem modoNoche = new JMenuItem("Modo Noche");
        modoNoche.addActionListener(e -> {
            for (int i = 0; i < 3; i++) modoNoche(i);
        });
        menu.add(modoNoche);

        menu.addSeparator();

        JMenuItem principales = new JMenuItem("Principales");
        principales.addActionListener(e -> mostrarInfo(0, "Principales"));
        menu.add(principales);

        JMenuItem secundarias = new JMenuItem("Secundarias");
        secundarias.addActionListener(e -> mostrarInfo(1, "Secundarias"));
        menu.add(secundarias);

        JMenuItem seguridad = new JMenuItem("Seguridad");
        seguridad.addActionListener(e -> mostrarInfo(2, "Seguridad"));
        menu.add(seguridad);

        // Añadir el listener al fondo de la ventana
        this.getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) menu.show(e.getComponent(), e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) menu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void cambiarTodas(boolean encender) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                luces[i][j].setSelected(encender);
    }

    private void modoDia(int oficina) {
        luces[oficina][0].setSelected(true);   // principal
        luces[oficina][1].setSelected(true);   // secundaria
        luces[oficina][2].setSelected(false);  // seguridad
    }

    private void modoNoche(int oficina) {
        luces[oficina][0].setSelected(false);
        luces[oficina][1].setSelected(false);
        luces[oficina][2].setSelected(true);
    }

    private void mostrarInfo(int tipo, String nombre) {
        int encendidas = 0;
        int apagadas = 0;
        for (int i = 0; i < 3; i++) {
            if (luces[i][tipo].isSelected()) encendidas++;
            else apagadas++;
        }
        JOptionPane.showMessageDialog(this,
                nombre + " encendidas: " + encendidas + "\n" + nombre + " apagadas: " + apagadas,
                "Estado de " + nombre, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ControlLuces().setVisible(true);
        });
    }
}
