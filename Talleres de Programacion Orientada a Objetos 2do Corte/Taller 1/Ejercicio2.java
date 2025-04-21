import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio2 extends JFrame implements ActionListener {
    private JTextField txtTexto;
    private JLabel etiTexto1, etiTexto2;
    private JButton btnTraspasa1, btnTraspasa2;

    public Ejercicio2() {
        setLayout(new FlowLayout());
        
        txtTexto = new JTextField(20);
        add(txtTexto);
        
        etiTexto1 = new JLabel("");
        add(etiTexto1);
        
        etiTexto2 = new JLabel("");
        add(etiTexto2);
        
        btnTraspasa1 = new JButton("Traspasa 1");
        btnTraspasa1.addActionListener(this);
        add(btnTraspasa1);
        
        btnTraspasa2 = new JButton("Traspasa 2");
        btnTraspasa2.addActionListener(this);
        add(btnTraspasa2);
        
        setTitle("Ejercicio 2");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTraspasa1) {
            etiTexto1.setText(txtTexto.getText());
        } else if (e.getSource() == btnTraspasa2) {
            etiTexto2.setText(txtTexto.getText());
        }
    }

    public static void main(String[] args) {
        new Ejercicio2();
    }
}