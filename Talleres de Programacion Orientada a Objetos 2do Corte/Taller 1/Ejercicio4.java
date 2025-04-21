import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio4 extends JFrame implements ActionListener {
    private JTextField txtNombre, txtCiudad;
    private JLabel txtFrase;
    private JButton btnAceptar, btnDesactivar, btnActivar;

    public Ejercicio4() {
        setLayout(new FlowLayout());
        
        txtNombre = new JTextField(20);
        add(txtNombre);
        
        txtCiudad = new JTextField(20);
        add(txtCiudad);
        
        txtFrase = new JLabel("");
        add(txtFrase);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(this);
        add(btnAceptar);
        
        btnDesactivar = new JButton("Desactivar");
        btnDesactivar.addActionListener(this);
        add(btnDesactivar);
        
        btnActivar = new JButton("Activar");
        btnActivar.addActionListener(this);
        add(btnActivar);
        
        setTitle("Ejercicio 4");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            txtFrase.setText("Usted se llama " + txtNombre.getText() + " y vive en " + txtCiudad.getText());
        } else if (e.getSource() == btnDesactivar) {
            txtNombre.setEnabled(false);
            txtCiudad.setEnabled(false);
        } else if (e.getSource() == btnActivar) {
            txtNombre.setEnabled(true);
            txtCiudad.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        new Ejercicio4();
    }
}