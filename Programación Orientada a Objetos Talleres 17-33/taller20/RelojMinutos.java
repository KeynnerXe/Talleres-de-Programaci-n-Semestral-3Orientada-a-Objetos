/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class RelojMinutos extends JFrame {

    // Componentes
    JTextField txtHoras, txtMinutos, txtCantidadMin;
    JButton btnSumar, btnRestar;
    JToolBar barraHerramientas;
    JButton herramientasSumar, herramientasRestar, herramientasReiniciar;
    JMenuBar barraMenus;
    JMenu menuAccion;
    JMenuItem menuSumar, menuRestar, menuReiniciar, menuSalir;

    // Variables globales
    int hora = 0;
    int minutos = 0;

    public RelojMinutos() {
        setTitle("Ejercicio - Reloj Minutos");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Etiquetas
        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(30, 30, 50, 30);
        add(lblHoras);

        JLabel lblMinutos = new JLabel("Minutos:");
        lblMinutos.setBounds(150, 30, 60, 30);
        add(lblMinutos);

        JLabel lblPuntos = new JLabel(":");
        lblPuntos.setBounds(120, 30, 10, 30);
        add(lblPuntos);

        // TextFields
        txtHoras = new JTextField("0");
        txtHoras.setBounds(80, 30, 40, 30);
        txtHoras.setEditable(false);
        add(txtHoras);

        txtMinutos = new JTextField("0");
        txtMinutos.setBounds(220, 30, 40, 30);
        txtMinutos.setEditable(false);
        add(txtMinutos);

        txtCantidadMin = new JTextField();
        txtCantidadMin.setBounds(30, 70, 100, 30);
        add(txtCantidadMin);

        // Botones
        btnSumar = new JButton("+");
        btnSumar.setBounds(150, 70, 60, 30);
        btnSumar.addActionListener(e -> sumar());
        add(btnSumar);

        btnRestar = new JButton("-");
        btnRestar.setBounds(220, 70, 60, 30);
        btnRestar.addActionListener(e -> restar());
        add(btnRestar);

        // Barra de herramientas
        barraHerramientas = new JToolBar();
        barraHerramientas.setBounds(0, 120, 400, 30);

        herramientasSumar = new JButton(new ImageIcon("sumar.png")); // puedes usar cualquier icono
        herramientasSumar.setToolTipText("Sumar");
        herramientasSumar.addActionListener(e -> sumar());
        barraHerramientas.add(herramientasSumar);

        herramientasRestar = new JButton(new ImageIcon("restar.png"));
        herramientasRestar.setToolTipText("Restar");
        herramientasRestar.addActionListener(e -> restar());
        barraHerramientas.add(herramientasRestar);

        herramientasReiniciar = new JButton(new ImageIcon("reiniciar.png"));
        herramientasReiniciar.setToolTipText("Reiniciar");
        herramientasReiniciar.addActionListener(e -> reiniciar());
        barraHerramientas.add(herramientasReiniciar);

        add(barraHerramientas);

        // Menú
        barraMenus = new JMenuBar();
        menuAccion = new JMenu("Acción");

        menuSumar = new JMenuItem("Sumar");
        menuSumar.addActionListener(e -> sumar());
        menuAccion.add(menuSumar);

        menuAccion.addSeparator();

        menuRestar = new JMenuItem("Restar");
        menuRestar.addActionListener(e -> restar());
        menuAccion.add(menuRestar);

        menuAccion.addSeparator();

        menuReiniciar = new JMenuItem("Reiniciar");
        menuReiniciar.addActionListener(e -> reiniciar());
        menuAccion.add(menuReiniciar);

        menuAccion.addSeparator();

        menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(e -> System.exit(0));
        menuAccion.add(menuSalir);

        barraMenus.add(menuAccion);
        setJMenuBar(barraMenus);

        setVisible(true);
    }

    // Métodos principales
    public void sumar() {
        try {
            int cantidad = Integer.parseInt(txtCantidadMin.getText());
            int total = hora * 60 + minutos + cantidad;
            hora = total / 60;
            minutos = total % 60;

            actualizarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduce un número válido.");
        }
    }

    public void restar() {
        try {
            int cantidad = Integer.parseInt(txtCantidadMin.getText());
            int total = hora * 60 + minutos - cantidad;

            if (total < 0) total = 0; // evitar negativos

            hora = total / 60;
            minutos = total % 60;

            actualizarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduce un número válido.");
        }
    }

    public void reiniciar() {
        hora = 0;
        minutos = 0;
        actualizarCampos();
    }

    public void actualizarCampos() {
        txtHoras.setText(String.valueOf(hora));
        txtMinutos.setText(String.valueOf(minutos));
    }

    public static void main(String[] args) {
        new RelojMinutos();
    }
}
