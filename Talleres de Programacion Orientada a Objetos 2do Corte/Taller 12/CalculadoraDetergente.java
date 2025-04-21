import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class CalculadoraDetergente extends JFrame {

    private JSlider deslizadorLitros;
    private JSlider deslizadorCalidad;
    private JSlider deslizadorDensidad;
    private JLabel etiLitros;
    private JLabel etiCalidad;
    private JLabel etiDensidad;
    private JLabel etiLitrosAgua;
    private JLabel etiSales;

    public CalculadoraDetergente() {
        // Configuración básica de la ventana
        setTitle("Calculadora de Detergente");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        
        // Panel principal con márgenes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        // Crear componentes
        crearComponentes();
        
        // Añadir componentes al panel
        panel.add(new JLabel("Litros a fabricar:"));
        panel.add(deslizadorLitros);
        panel.add(new JLabel("Valor seleccionado:"));
        panel.add(etiLitros);
        
        panel.add(new JLabel("Calidad del detergente:"));
        panel.add(deslizadorCalidad);
        panel.add(new JLabel("Valor seleccionado:"));
        panel.add(etiCalidad);
        
        panel.add(new JLabel("Densidad deseada:"));
        panel.add(deslizadorDensidad);
        panel.add(new JLabel("Valor seleccionado:"));
        panel.add(etiDensidad);
        
        panel.add(new JLabel("Litros de agua necesarios:"));
        panel.add(etiLitrosAgua);
        
        panel.add(new JLabel("Sales necesarias:"));
        panel.add(etiSales);
        
        // Actualizar cálculos iniciales
        actualizarCalculos();
    }

    private void crearComponentes() {
        // Configurar deslizador de litros (1-100)
        deslizadorLitros = new JSlider(1, 100, 50);
        configurarSlider(deslizadorLitros);
        
        // Configurar deslizador de calidad (0-10)
        deslizadorCalidad = new JSlider(0, 10, 5);
        configurarSlider(deslizadorCalidad);
        
        // Configurar deslizador de densidad (50-200)
        deslizadorDensidad = new JSlider(50, 200, 100);
        configurarSlider(deslizadorDensidad);
        
        // Configurar etiquetas con borde
        etiLitros = crearEtiquetaConBorde("50");
        etiCalidad = crearEtiquetaConBorde("5");
        etiDensidad = crearEtiquetaConBorde("100");
        etiLitrosAgua = crearEtiquetaConBorde("0");
        etiSales = crearEtiquetaConBorde("0");
        
        // Añadir listeners a los sliders
        ChangeListener sliderListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarValoresSliders();
                actualizarCalculos();
            }
        };
        
        deslizadorLitros.addChangeListener(sliderListener);
        deslizadorCalidad.addChangeListener(sliderListener);
        deslizadorDensidad.addChangeListener(sliderListener);
    }

    private void configurarSlider(JSlider slider) {
        slider.setMajorTickSpacing(slider.getMaximum() / 5);
        slider.setMinorTickSpacing(slider.getMaximum() / 10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }

    private JLabel crearEtiquetaConBorde(String texto) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        etiqueta.setBorder(new LineBorder(Color.BLACK));
        return etiqueta;
    }

    private void actualizarValoresSliders() {
        etiLitros.setText(String.valueOf(deslizadorLitros.getValue()));
        etiCalidad.setText(String.valueOf(deslizadorCalidad.getValue()));
        etiDensidad.setText(String.valueOf(deslizadorDensidad.getValue()));
    }

    private void actualizarCalculos() {
        double litros = deslizadorLitros.getValue();
        double calidad = deslizadorCalidad.getValue();
        double densidad = deslizadorDensidad.getValue();
        
        // Calcular litros de agua
        double litrosAgua = 2 * litros + calidad / densidad;
        etiLitrosAgua.setText(String.format("%.2f", litrosAgua));
        
        // Calcular sales
        double sales = (calidad * litros) / (100 * densidad);
        etiSales.setText(String.format("%.4f", sales));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraDetergente().setVisible(true);
            }
        });
    }
}