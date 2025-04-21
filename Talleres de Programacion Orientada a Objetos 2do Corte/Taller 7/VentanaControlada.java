import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaControlada extends JFrame {
    JTextField txtTitulo = new JTextField();
    JTextField txtPosicionX = new JTextField();
    JTextField txtPosicionY = new JTextField();

    public VentanaControlada() {
        setLayout(null);
        setSize(500, 400);
        setTitle("Ventana Controlada");

        // Componentes
        txtTitulo.setBounds(20, 20, 300, 30);
        JButton btnCambiarTitulo = new JButton("Cambiar Título");
        btnCambiarTitulo.setBounds(330, 20, 130, 30);

        JButton btnMaximizar = new JButton("Maximizar");
        btnMaximizar.setBounds(20, 60, 130, 30);
        JButton btnMinimizar = new JButton("Minimizar");
        btnMinimizar.setBounds(160, 60, 130, 30);
        JButton btnRestaurar = new JButton("Restaurar");
        btnRestaurar.setBounds(300, 60, 130, 30);

        txtPosicionX.setBounds(20, 100, 100, 30);
        txtPosicionY.setBounds(130, 100, 100, 30);
        JButton btnMover = new JButton("Mover");
        btnMover.setBounds(240, 100, 100, 30);
        JButton btnCentrar = new JButton("Centrar");
        btnCentrar.setBounds(350, 100, 100, 30);

        JButton btnEstiloJava = new JButton("Estilo Java");
        btnEstiloJava.setBounds(20, 140, 130, 30);
        JButton btnEstiloWindows = new JButton("Estilo Windows");
        btnEstiloWindows.setBounds(160, 140, 150, 30);

        JButton btnRojo = new JButton("Rojo");
        btnRojo.setBounds(20, 180, 100, 30);
        JButton btnVerde = new JButton("Verde");
        btnVerde.setBounds(130, 180, 100, 30);
        JButton btnAzul = new JButton("Azul");
        btnAzul.setBounds(240, 180, 100, 30);

        // Agregar componentes
        add(txtTitulo); add(btnCambiarTitulo);
        add(btnMaximizar); add(btnMinimizar); add(btnRestaurar);
        add(txtPosicionX); add(txtPosicionY);
        add(btnMover); add(btnCentrar);
        add(btnEstiloJava); add(btnEstiloWindows);
        add(btnRojo); add(btnVerde); add(btnAzul);

        // Eventos
        btnCambiarTitulo.addActionListener(e -> setTitle(txtTitulo.getText()));

        btnMaximizar.addActionListener(e -> setExtendedState(JFrame.MAXIMIZED_BOTH));
        btnMinimizar.addActionListener(e -> setState(JFrame.ICONIFIED));
        btnRestaurar.addActionListener(e -> setExtendedState(JFrame.NORMAL));

        btnMover.addActionListener(e -> {
            try {
                int x = Integer.parseInt(txtPosicionX.getText());
                int y = Integer.parseInt(txtPosicionY.getText());
                setLocation(x, y);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Posiciones inválidas");
            }
        });

        btnCentrar.addActionListener(e -> setLocationRelativeTo(null));

        btnEstiloJava.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnEstiloWindows.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnRojo.addActionListener(e -> getContentPane().setBackground(Color.RED));
        btnVerde.addActionListener(e -> getContentPane().setBackground(Color.GREEN));
        btnAzul.addActionListener(e -> getContentPane().setBackground(Color.BLUE));

        // Confirmación al cerrar
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Solicitar contraseña
        String claveCorrecta = "admin123";
        String ingreso = JOptionPane.showInputDialog(null, "Ingrese la contraseña:");

        if (claveCorrecta.equals(ingreso)) {
            SwingUtilities.invokeLater(() -> {
                new VentanaControlada().setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Cerrando programa.");
            System.exit(0);
        }
    }
}
