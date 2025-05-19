
package Vistas;

/**
 *
 * @author Dimerson
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;
import Modelos.Usuario;
import Modelos.Transaccion;
import java.util.List;

/**
 * Pantalla para visualizar el historial de transacciones de un usuario.
 */
public class HistorialFrame extends JFrame {

    private JTable tablaTransacciones;
    private JButton btnVolver;

    private LogicaBilletera logica;
    private Usuario usuarioActual;

    /**
     * Constructor que recibe la lógica y el usuario actual.
     * @param logica instancia de LogicaBilletera
     * @param usuario usuario actualmente logueado
     */
    public HistorialFrame(LogicaBilletera logica, Usuario usuario) {
        this.logica = logica;
        this.usuarioActual = usuario;
        initComponents();
    }

    /**
     * Método que configura los componentes visuales.
     */
    private void initComponents() {
        setTitle("Historial de Transacciones");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Historial de Transacciones", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        tablaTransacciones = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaTransacciones);
        add(scrollPane, BorderLayout.CENTER);

        btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 102, 102));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);

        JPanel panelBoton = new JPanel();
        panelBoton.add(btnVolver);
        add(panelBoton, BorderLayout.SOUTH);

        cargarTransacciones();

        eventosBotones();
    }

/**
 * Método que carga las transacciones del usuario en la tabla.
 */
private void cargarTransacciones() {
   
    List<Transaccion> historial = usuarioActual.getHistorial();

    String[] columnas = {"Tipo", "Monto", "Fecha"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    if (historial.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No tienes transacciones aún.", "Historial vacío", JOptionPane.INFORMATION_MESSAGE);
    } else {
        for (Transaccion t : historial) {
            Object[] fila = {t.getTipo(), "$" + t.getMonto(), t.getFecha().toString()};
            modelo.addRow(fila);
        }
    }

    tablaTransacciones.setModel(modelo);
}


    /**
     * Método para manejar eventos de botones.
     */
    private void eventosBotones() {
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAlHome();
            }
        });
    }

    /**
     * Método para volver al HomeFrame.
     */
    private void volverAlHome() {
        dispose();
        new HomeFrame(logica, usuarioActual).setVisible(true);
    }
}
