import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectorNumeros extends JFrame {
    private JLabel[] etiquetas;
    private JTextField txtNumero;
    private JButton btnBorrar;

    public SelectorNumeros() {
        setLayout(new GridLayout(12, 1));
        
        etiquetas = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            etiquetas[i] = new JLabel(String.valueOf(i));
            etiquetas[i].addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    JLabel etiqueta = (JLabel)e.getSource();
                    txtNumero.setText(txtNumero.getText() + etiqueta.getText());
                }
            });
            add(etiquetas[i]);
        }
        
        txtNumero = new JTextField();
        add(txtNumero);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
            }
        });
        add(btnBorrar);
        
        setTitle("Selector de Números");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SelectorNumeros();
    }
}