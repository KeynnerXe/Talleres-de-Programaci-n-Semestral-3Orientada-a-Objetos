import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio5 extends JFrame {
    private JLabel etiPal1, etiPal2, etiPal3, etiPal4, etiOcultar;

    public Ejercicio5() {
        setLayout(new FlowLayout());
        
        etiPal1 = new JLabel("Palabra 1");
        add(etiPal1);
        
        etiPal2 = new JLabel("Palabra 2");
        add(etiPal2);
        
        etiPal3 = new JLabel("Palabra 3");
        add(etiPal3);
        
        etiPal4 = new JLabel("Palabra 4");
        add(etiPal4);
        
        etiOcultar = new JLabel("Ocultar");
        etiOcultar.setOpaque(true);
        etiOcultar.setBackground(Color.YELLOW);
        etiOcultar.setPreferredSize(new Dimension(100, 50));
        etiOcultar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                etiPal1.setVisible(false);
                etiPal2.setVisible(false);
                etiPal3.setVisible(false);
                etiPal4.setVisible(false);
            }
            
            public void mouseExited(MouseEvent e) {
                etiPal1.setVisible(true);
                etiPal2.setVisible(true);
                etiPal3.setVisible(true);
                etiPal4.setVisible(true);
            }
        });
        add(etiOcultar);
        
        setTitle("Ejercicio 5");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejercicio5();
    }
}