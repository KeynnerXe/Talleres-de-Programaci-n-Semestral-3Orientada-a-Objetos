/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller31;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anton
 */
public class DialogoPresentacion extends JDialog {
    private JLabel etiNombrePrograma;
    private JLabel etiVersion;
    private JLabel etiNombreProgramador;
    private JButton btnEmpezar;

    // Constructor
    public DialogoPresentacion(Frame owner) {
        super(owner, "Pantalla de Presentación", true);
        // Configuramos el layout y el borde
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Información del Programa"));

        // Etiquetas para mostrar los datos
        etiNombrePrograma = new JLabel("Nombre del Programa: ");
        etiVersion = new JLabel("Versión: ");
        etiNombreProgramador = new JLabel("Programador: ");

        // Agregamos las etiquetas al panel
        panel.add(etiNombrePrograma);
        panel.add(etiVersion);
        panel.add(etiNombreProgramador);

        // Botón "Empezar"
        btnEmpezar = new JButton("Empezar");
        panel.add(btnEmpezar);

        // Agregamos el panel a la ventana del diálogo
        add(panel, BorderLayout.CENTER);

        // Acción del botón "Empezar"
        btnEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo
            }
        });

        // Configuramos el tamaño y el cierre del diálogo
        setSize(300, 200);
        setLocationRelativeTo(owner); // Centra el diálogo
    }

    // Métodos para asignar la información
    public void setNombrePrograma(String nombre) {
        etiNombrePrograma.setText("Nombre del Programa: " + nombre);
    }

    public void setVersion(String version) {
        etiVersion.setText("Versión: " + version);
    }

    public void setNombreProgramador(String programador) {
        etiNombreProgramador.setText("Programador: " + programador);
    }
}
