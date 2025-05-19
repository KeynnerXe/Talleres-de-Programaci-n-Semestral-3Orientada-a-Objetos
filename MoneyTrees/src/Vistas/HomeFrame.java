package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;
import Modelos.Usuario;


/**
 * Pantalla principal (Home) que se muestra tras iniciar sesión.
 * Permite acceder a operaciones: consultar saldo, recargar, enviar dinero, ver historial y cerrar sesión.
 */
public class HomeFrame extends JFrame {

    private JButton btnConsultarSaldo;
    private JButton btnRecargarSaldo;
    private JButton btnEnviarDinero;
    private JButton btnVerHistorial;
    private JButton btnCerrarSesion;
    
    private LogicaBilletera logica;      // Lógica del sistema
    private Usuario usuarioActual;       // Usuario que ha iniciado sesión

    /**
     * Constructor que inicializa los componentes de la pantalla principal.
     * @param logica instancia de la lógica de negocio
     * @param usuario el usuario que ha iniciado sesión
     */
    public HomeFrame(LogicaBilletera logica, Usuario usuario) {
        this.logica = logica;
        this.usuarioActual = usuario;
        initComponents();
    }

    /**
     * Método para configurar y agregar todos los elementos visuales.
     */
    private void initComponents() {
        setTitle("Money Trees - Menú Principal");
        setSize(400, 600);
        setLocationRelativeTo(null); // Centrar en pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        JLabel lblTitulo = new JLabel("Bienvenido " + usuarioActual.getNombre());
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        // Crear botones principales
        btnConsultarSaldo = crearBoton("Consultar Saldo", new Color(0, 153, 255));
        btnRecargarSaldo = crearBoton("Recargar Saldo", new Color(0, 204, 102));
        btnEnviarDinero = crearBoton("Enviar Dinero", new Color(255, 153, 0));
        btnVerHistorial = crearBoton("Ver Historial", new Color(153, 51, 255));
        btnCerrarSesion = crearBoton("Cerrar Sesión", new Color(255, 51, 51));

        // Agregar botones al panel
        panelPrincipal.add(btnConsultarSaldo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnRecargarSaldo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnEnviarDinero);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnVerHistorial);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));
        panelPrincipal.add(btnCerrarSesion);

        add(panelPrincipal, BorderLayout.CENTER);

        // Eventos de botones
        eventosBotones();
    }

    /**
     * Método para crear un botón estilizado.
     *
     * @param texto Texto del botón
     * @param color Color de fondo
     * @return JButton estilizado
     */
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return boton;
    }

    /**
     * Método para asociar los eventos de los botones.
     */
    private void eventosBotones() {

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarSaldo();
            }
        });

        btnRecargarSaldo.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose(); // Cierra el HomeFrame actual
        new RecargarSaldoFrame(logica, usuarioActual).setVisible(true); // Abre RecargarSaldoFrame
    }
});


       btnEnviarDinero.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose(); // Cierra el HomeFrame actual
        new EnviarDineroFrame(logica, usuarioActual).setVisible(true); // Abre EnviarDineroFrame pasando lógica y usuario
    }
});


   btnVerHistorial.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose(); // Cierra HomeFrame actual
        new HistorialFrame(logica, usuarioActual).setVisible(true); // Abre HistorialFrame
    }
});


        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
    }

    /**
     * Método para mostrar el saldo actual del usuario.
     */
    private void consultarSaldo() {
        double saldo = usuarioActual.consultarSaldo();
        JOptionPane.showMessageDialog(this, "Tu saldo actual es: $" + saldo, "Saldo Disponible", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para cerrar sesión y volver al Login.
     */
    private void cerrarSesion() {
        dispose(); // Cierra esta ventana
        new LoginFrame(logica).setVisible(true); // Volver al login usando la misma lógica
    }
}
