import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio6 extends JFrame {
    private JLabel etiNombre;
    private JButton btnEsquina, btnCentro, btnAgrandar, btnAchicar;
    private Dimension originalButtonSize;

    public Ejercicio6() {
        setLayout(null);
        
        etiNombre = new JLabel("Mi Nombre");
        etiNombre.setOpaque(true);
        etiNombre.setBackground(Color.CYAN);
        etiNombre.setBounds(100, 100, 100, 30);
        add(etiNombre);
        
        btnEsquina = new JButton("Esquina");
        btnEsquina.setBounds(20, 20, 100, 30);
        btnEsquina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etiNombre.setLocation(0, 0);
            }
        });
        addMouseEffects(btnEsquina);
        add(btnEsquina);
        
        btnCentro = new JButton("Centro");
        btnCentro.setBounds(140, 20, 100, 30);
        btnCentro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = (getWidth() - etiNombre.getWidth()) / 2;
                int y = (getHeight() - etiNombre.getHeight()) / 2;
                etiNombre.setLocation(x, y);
            }
        });
        addMouseEffects(btnCentro);
        add(btnCentro);
        
        btnAgrandar = new JButton("Agrandar");
        btnAgrandar.setBounds(20, 60, 100, 30);
        btnAgrandar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etiNombre.setSize(etiNombre.getWidth() + 10, etiNombre.getHeight() + 5);
            }
        });
        addMouseEffects(btnAgrandar);
        add(btnAgrandar);
        
        btnAchicar = new JButton("Achicar");
        btnAchicar.setBounds(140, 60, 100, 30);
        btnAchicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (etiNombre.getWidth() > 20 && etiNombre.getHeight() > 10) {
                    etiNombre.setSize(etiNombre.getWidth() - 10, etiNombre.getHeight() - 5);
                }
            }
        });
        addMouseEffects(btnAchicar);
        add(btnAchicar);
        
        originalButtonSize = btnEsquina.getSize();
        
        setTitle("Ejercicio 6");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addMouseEffects(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setSize((int)(button.getWidth() * 1.2), (int)(button.getHeight() * 1.2));
            }
            
            public void mouseExited(MouseEvent e) {
                button.setSize(originalButtonSize);
            }
        });
    }

    public static void main(String[] args) {
        new Ejercicio6();
    }
}