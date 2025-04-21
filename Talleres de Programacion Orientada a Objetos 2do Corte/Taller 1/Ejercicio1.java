import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio1 extends JFrame implements ActionListener {
    private JLabel etiNombre, etiCiudad;
    private JButton btnOcultarNombre, btnVisuNombre, btnOcultarCiudad, btnVisuCiudad;

    public Ejercicio1() {
        setLayout(new FlowLayout());
        
        etiNombre = new JLabel("Mi Nombre");
        add(etiNombre);
        
        etiCiudad = new JLabel("Mi Ciudad");
        add(etiCiudad);
        
        btnOcultarNombre = new JButton("Ocultar Nombre");
        btnOcultarNombre.addActionListener(this);
        add(btnOcultarNombre);
        
        btnVisuNombre = new JButton("Visualizar Nombre");
        btnVisuNombre.addActionListener(this);
        add(btnVisuNombre);
        
        btnOcultarCiudad = new JButton("Ocultar Ciudad");
        btnOcultarCiudad.addActionListener(this);
        add(btnOcultarCiudad);
        
        btnVisuCiudad = new JButton("Visualizar Ciudad");
        btnVisuCiudad.addActionListener(this);
        add(btnVisuCiudad);
        
        setTitle("Ejercicio 1");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOcultarNombre) {
            etiNombre.setVisible(false);
        } else if (e.getSource() == btnVisuNombre) {
            etiNombre.setVisible(true);
        } else if (e.getSource() == btnOcultarCiudad) {
            etiCiudad.setVisible(false);
        } else if (e.getSource() == btnVisuCiudad) {
            etiCiudad.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Ejercicio1();
    }
}