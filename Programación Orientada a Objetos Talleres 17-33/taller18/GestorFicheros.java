/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller18;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
/**
 *
 * @author anton
 */
public class GestorFicheros extends JFrame {
    private JLabel lblNombre, lblCamino, lblExiste;
    private JButton btnInfo, btnEliminar;
    private JFileChooser elegirFichero;

    public GestorFicheros() {
        setTitle("Gestor de Ficheros");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        elegirFichero = new JFileChooser();

        btnInfo = new JButton("Info Fichero");
        btnEliminar = new JButton("Eliminar Fichero");

        lblNombre = new JLabel("Nombre: ");
        lblCamino = new JLabel("Camino: ");
        lblExiste = new JLabel("¿Existe?: ");

        btnInfo.addActionListener(e -> mostrarInfoFichero());
        btnEliminar.addActionListener(e -> eliminarFichero());

        add(btnInfo);
        add(btnEliminar);
        add(lblNombre);
        add(lblCamino);
        add(lblExiste);
    }

    private void mostrarInfoFichero() {
        int resp = elegirFichero.showOpenDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File f = elegirFichero.getSelectedFile();
            if (f.exists()) {
                lblNombre.setText("Nombre: " + f.getName());
                lblCamino.setText("Camino: " + f.getPath());
                lblExiste.setText("¿Existe?: Sí");
            } else {
                lblNombre.setText("Nombre: ");
                lblCamino.setText("Camino: ");
                lblExiste.setText("¿Existe?: No");
                JOptionPane.showMessageDialog(this, "El fichero no existe.");
            }
        }
    }

    private void eliminarFichero() {
        int resp = elegirFichero.showOpenDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File f = elegirFichero.getSelectedFile();
            if (f.exists()) {
                int confirmar = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de que desea eliminar el fichero?\n" + f.getName(),
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirmar == JOptionPane.YES_OPTION) {
                    boolean borrado = f.delete();
                    if (borrado) {
                        JOptionPane.showMessageDialog(this, "Fichero eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar el fichero.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "El fichero no existe.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestorFicheros().setVisible(true);
        });
    }
}
