import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio3 extends JFrame {
    private JTextField txtTexto;
    private JLabel etiTexto;
    private JButton btnVaciar;

    public Ejercicio3() {
        setLayout(new FlowLayout());
        
        txtTexto = new JTextField(20);
        txtTexto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                etiTexto.setText(txtTexto.getText());
            }
        });
        add(txtTexto);
        
        etiTexto = new JLabel("");
        add(etiTexto);
        
        btnVaciar = new JButton("Vaciar");
        btnVaciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtTexto.setText("");
                etiTexto.setText("");
            }
        });
        add(btnVaciar);
        
        setTitle("Ejercicio 3");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio3();
    }
}