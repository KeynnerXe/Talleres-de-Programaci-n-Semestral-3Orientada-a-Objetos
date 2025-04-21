import java.awt.*;
import javax.swing.*;

public class ToggleBotones extends JFrame {
    JToggleButton botonUno, botonDos, botonTres, botonCuatro, botonCinco, botonSeis;
    JButton btnDesactivarTodos, btnActivarTodos, btnTotal;
    JLabel etiResultado;

    public ToggleBotones() {
        setTitle("JToggleButtons");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear botones toggle
        botonUno = new JToggleButton("1");
        botonDos = new JToggleButton("2");
        botonTres = new JToggleButton("3");
        botonCuatro = new JToggleButton("4");
        botonCinco = new JToggleButton("5");
        botonSeis = new JToggleButton("6");

        botonUno.setBounds(30, 30, 60, 40);
        botonDos.setBounds(100, 30, 60, 40);
        botonTres.setBounds(170, 30, 60, 40);
        botonCuatro.setBounds(30, 80, 60, 40);
        botonCinco.setBounds(100, 80, 60, 40);
        botonSeis.setBounds(170, 80, 60, 40);

        add(botonUno);
        add(botonDos);
        add(botonTres);
        add(botonCuatro);
        add(botonCinco);
        add(botonSeis);

        // Botones normales
        btnDesactivarTodos = new JButton("Desactivar Todos");
        btnDesactivarTodos.setBounds(250, 30, 120, 30);
        add(btnDesactivarTodos);

        btnActivarTodos = new JButton("Activar Todos");
        btnActivarTodos.setBounds(250, 70, 120, 30);
        add(btnActivarTodos);

        btnTotal = new JButton("Total");
        btnTotal.setBounds(150, 140, 100, 30);
        add(btnTotal);

        // Etiqueta resultado
        etiResultado = new JLabel("0", SwingConstants.CENTER);
        etiResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        etiResultado.setFont(new Font("Arial", Font.BOLD, 16));
        etiResultado.setBounds(140, 190, 120, 40);
        add(etiResultado);

        // Acción de Total
        btnTotal.addActionListener(e -> calcularTotal());

        // Acción de Desactivar Todos
        btnDesactivarTodos.addActionListener(e -> setToggleButtons(false));

        // Acción de Activar Todos
        btnActivarTodos.addActionListener(e -> setToggleButtons(true));
    }

    private void setToggleButtons(boolean estado) {
        botonUno.setSelected(estado);
        botonDos.setSelected(estado);
        botonTres.setSelected(estado);
        botonCuatro.setSelected(estado);
        botonCinco.setSelected(estado);
        botonSeis.setSelected(estado);
    }

    private void calcularTotal() {
        int suma = 0;
        if (botonUno.isSelected()) suma += 1;
        if (botonDos.isSelected()) suma += 2;
        if (botonTres.isSelected()) suma += 3;
        if (botonCuatro.isSelected()) suma += 4;
        if (botonCinco.isSelected()) suma += 5;
        if (botonSeis.isSelected()) suma += 6;

        etiResultado.setText(String.valueOf(suma));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToggleBotones().setVisible(true));
    }
}
