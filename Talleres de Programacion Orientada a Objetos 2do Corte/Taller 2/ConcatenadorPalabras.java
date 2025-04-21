import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConcatenadorPalabras extends JFrame implements ActionListener {
    private JTextField txtPalabra1, txtPalabra2;
    private JLabel etiTexto;
    private JButton btnConcatena;

    public ConcatenadorPalabras() {
        setLayout(new GridLayout(4, 2));
        
        add(new JLabel("Palabra 1:"));
        txtPalabra1 = new JTextField();
        add(txtPalabra1);
        
        add(new JLabel("Palabra 2:"));
        txtPalabra2 = new JTextField();
        add(txtPalabra2);
        
        add(new JLabel("Resultado:"));
        etiTexto = new JLabel("");
        add(etiTexto);
        
        btnConcatena = new JButton("Concatenar");
        btnConcatena.addActionListener(this);
        add(btnConcatena);
        
        setTitle("Concatenador de Palabras");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        etiTexto.setText(txtPalabra1.getText() + txtPalabra2.getText());
    }

    public static void main(String[] args) {
        new ConcatenadorPalabras();
    }
}