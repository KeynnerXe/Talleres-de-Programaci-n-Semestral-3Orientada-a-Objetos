import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio7 extends JFrame implements ActionListener {
    private JLabel etiTexto;
    private JButton btnAzul, btnRojo, btnVerde, btnFondoAzul, btnFondoRojo, btnFondoVerde, btnTransparente, btnOpaca;

    public Ejercicio7() {
        setLayout(new FlowLayout());
        
        etiTexto = new JLabel("Texto de ejemplo");
        etiTexto.setOpaque(true);
        etiTexto.setPreferredSize(new Dimension(200, 50));
        add(etiTexto);
        
        btnAzul = new JButton("Azul");
        btnAzul.addActionListener(this);
        add(btnAzul);
        
        btnRojo = new JButton("Rojo");
        btnRojo.addActionListener(this);
        add(btnRojo);
        
        btnVerde = new JButton("Verde");
        btnVerde.addActionListener(this);
        add(btnVerde);
        
        btnFondoAzul = new JButton("Fondo Azul");
        btnFondoAzul.addActionListener(this);
        add(btnFondoAzul);
        
        btnFondoRojo = new JButton("Fondo Rojo");
        btnFondoRojo.addActionListener(this);
        add(btnFondoRojo);
        
        btnFondoVerde = new JButton("Fondo Verde");
        btnFondoVerde.addActionListener(this);
        add(btnFondoVerde);
        
        btnTransparente = new JButton("Transparente");
        btnTransparente.addActionListener(this);
        add(btnTransparente);
        
        btnOpaca = new JButton("Opaca");
        btnOpaca.addActionListener(this);
        add(btnOpaca);
        
        setTitle("Ejercicio 7");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAzul) {
            etiTexto.setForeground(Color.BLUE);
        } else if (e.getSource() == btnRojo) {
            etiTexto.setForeground(Color.RED);
        } else if (e.getSource() == btnVerde) {
            etiTexto.setForeground(Color.GREEN);
        } else if (e.getSource() == btnFondoAzul) {
            etiTexto.setBackground(Color.BLUE);
        } else if (e.getSource() == btnFondoRojo) {
            etiTexto.setBackground(Color.RED);
        } else if (e.getSource() == btnFondoVerde) {
            etiTexto.setBackground(Color.GREEN);
        } else if (e.getSource() == btnTransparente) {
            etiTexto.setOpaque(false);
        } else if (e.getSource() == btnOpaca) {
            etiTexto.setOpaque(true);
        }
    }

    public static void main(String[] args) {
        new Ejercicio7();
    }
}