/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller21;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class VentanaPrincipal extends JFrame {
    private JTextField txtInstalacion, txtFormacion, txtMantenimiento;
    private JLabel lblTotal;

    public VentanaPrincipal() {
        setTitle("Coste de Implantación de Software");
        setLayout(new GridLayout(5, 3, 5, 5));

        // Campos de texto y botones
        txtInstalacion = new JTextField();
        JButton btnInstalacion = new JButton("...");
        txtFormacion = new JTextField();
        JButton btnFormacion = new JButton("...");
        txtMantenimiento = new JTextField();
        JButton btnMantenimiento = new JButton("...");

        JButton btnCalcular = new JButton("Calcular");
        lblTotal = new JLabel("Total: ", SwingConstants.CENTER);

        JButton btnAyuda = new JButton("?");

        add(new JLabel("Coste Instalación:"));
        add(txtInstalacion);
        add(btnInstalacion);

        add(new JLabel("Coste Formación:"));
        add(txtFormacion);
        add(btnFormacion);

        add(new JLabel("Coste Mantenimiento:"));
        add(txtMantenimiento);
        add(btnMantenimiento);

        add(new JLabel());
        add(btnCalcular);
        add(lblTotal);

        add(new JLabel("Ayuda:"));
        add(btnAyuda);
        add(new JLabel());

        // Listeners
        btnInstalacion.addActionListener(e -> mostrarDialogoInstalacion());
        btnFormacion.addActionListener(e -> mostrarDialogoFormacion());
        btnMantenimiento.addActionListener(e -> mostrarDialogoMantenimiento());

        btnCalcular.addActionListener(e -> calcularTotal());
        btnAyuda.addActionListener(e -> mostrarAyuda());

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void mostrarDialogoInstalacion() {
        JDialog dialog = new JDialog(this, "Coste Instalación", true);
        dialog.setLayout(new GridLayout(3, 2));

        JTextField txtSimplificada = new JTextField();
        JTextField txtCompleta = new JTextField();

        dialog.add(new JLabel("Copias Simplificadas:"));
        dialog.add(txtSimplificada);
        dialog.add(new JLabel("Copias Completas:"));
        dialog.add(txtCompleta);

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        btnAceptar.addActionListener(e -> {
            try {
                int simp = Integer.parseInt(txtSimplificada.getText());
                int comp = Integer.parseInt(txtCompleta.getText());
                int coste = simp * 120 + comp * 180;
                txtInstalacion.setText(String.valueOf(coste));
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Introduce solo números");
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarDialogoFormacion() {
        JDialog dialog = new JDialog(this, "Coste Formación", true);
        dialog.setLayout(new GridLayout(3, 2));

        JTextField txtAlumnos = new JTextField();
        JTextField txtHoras = new JTextField();

        dialog.add(new JLabel("Nº Alumnos:"));
        dialog.add(txtAlumnos);
        dialog.add(new JLabel("Horas Formación:"));
        dialog.add(txtHoras);

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        dialog.add(btnAceptar);
        dialog.add(btnCancelar);

        btnAceptar.addActionListener(e -> {
            try {
                int alumnos = Integer.parseInt(txtAlumnos.getText());
                int horas = Integer.parseInt(txtHoras.getText());
                int coste = alumnos * horas * 10;
                txtFormacion.setText(String.valueOf(coste));
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Introduce solo números");
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarDialogoMantenimiento() {
        JDialog dialog = new JDialog(this, "Coste Mantenimiento", true);
        dialog.setLayout(new GridLayout(4, 1));

        JRadioButton anual = new JRadioButton("Anual (600 €)");
        JRadioButton semestral = new JRadioButton("Semestral (350 €)");
        JRadioButton puesta = new JRadioButton("Puesta en funcionamiento (200 €)");
        ButtonGroup grupo = new ButtonGroup();

        grupo.add(anual);
        grupo.add(semestral);
        grupo.add(puesta);

        JPanel panelRadios = new JPanel(new GridLayout(3, 1));
        panelRadios.add(anual);
        panelRadios.add(semestral);
        panelRadios.add(puesta);

        dialog.add(panelRadios);

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        dialog.add(panelBotones);

        btnAceptar.addActionListener(e -> {
            if (anual.isSelected()) txtMantenimiento.setText("600");
            else if (semestral.isSelected()) txtMantenimiento.setText("350");
            else if (puesta.isSelected()) txtMantenimiento.setText("200");
            dialog.dispose();
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarAyuda() {
        JDialog ayuda = new JDialog(this, "Ayuda", false);
        ayuda.setAlwaysOnTop(true);
        ayuda.setLayout(new BorderLayout());

        JTextPane texto = new JTextPane();
        texto.setText("Este programa calcula el coste total de implantar un software incluyendo instalación, formación y mantenimiento.\n\nUse los botones (...) para abrir diálogos donde podrá introducir la información necesaria.");
        texto.setEditable(false);

        JScrollPane scroll = new JScrollPane(texto);
        ayuda.add(scroll, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> ayuda.dispose());
        ayuda.add(btnCerrar, BorderLayout.SOUTH);

        ayuda.setSize(300, 200);
        ayuda.setLocationRelativeTo(this);
        ayuda.setVisible(true);
    }

    private void calcularTotal() {
        try {
            int inst = Integer.parseInt(txtInstalacion.getText());
            int form = Integer.parseInt(txtFormacion.getText());
            int mant = Integer.parseInt(txtMantenimiento.getText());
            int total = inst + form + mant;
            lblTotal.setText("Total: " + total + " €");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Asegúrese de que todos los campos tienen valores válidos.");
        }
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();

        // Splash
        JDialog splash = new JDialog();
        splash.setUndecorated(true);
        splash.setSize(300, 150);
        JLabel lblSplash = new JLabel("Bienvenido al sistema", SwingConstants.CENTER);
        splash.add(lblSplash);

        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 -  splash.getWidth()/2);
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 -  splash.getHeight()/2);
        splash.setLocation(x, y);
        splash.setVisible(true);

        Timer timer = new Timer(2000, e -> {
            splash.dispose();
            ventana.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
