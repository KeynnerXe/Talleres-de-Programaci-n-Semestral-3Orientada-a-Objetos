import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoCombinacion extends JFrame {

    private JSpinner spiCentenas;
    private JSpinner spiDecenas;
    private JSpinner spiUnidades;
    private JButton btnAbrir;
    private JLabel etiResultado;

    private final int CLAVE = 246; // La clave secreta

    public JuegoCombinacion() {
        initComponents();
        configurarVentana();
    }

    private void initComponents() {
        spiCentenas = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
        spiDecenas = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
        spiUnidades = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
        btnAbrir = new JButton("Abrir");
        etiResultado = new JLabel(" ");
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Agrega borde a la etiqueta

        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCombinacion();
            }
        });

        // Diseño del layout
        setLayout(new FlowLayout());
        add(new JLabel("Centenas:"));
        add(spiCentenas);
        add(new JLabel("Decenas:"));
        add(spiDecenas);
        add(new JLabel("Unidades:"));
        add(spiUnidades);
        add(btnAbrir);
        add(etiResultado);
    }

    private void configurarVentana() {
        setTitle("Adivina la Combinación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    private void verificarCombinacion() {
        int centenas = Integer.parseInt(spiCentenas.getValue().toString());
        int decenas = Integer.parseInt(spiDecenas.getValue().toString());
        int unidades = Integer.parseInt(spiUnidades.getValue().toString());

        int numeroIngresado = centenas * 100 + decenas * 10 + unidades; // [cite: 10, 11]

        if (numeroIngresado == CLAVE) { // [cite: 5]
            etiResultado.setText("Caja Abierta");
        } else if (numeroIngresado < CLAVE) { // [cite: 6]
            etiResultado.setText("El número secreto es mayor");
        } else { // [cite: 7]
            etiResultado.setText("El número secreto es menor");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JuegoCombinacion();
            }
        });
    }
}