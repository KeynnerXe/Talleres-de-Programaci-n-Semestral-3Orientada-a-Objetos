package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;
import Modelos.Usuario;

/**
 * Pantalla de inicio de sesión para la Billetera Virtual.
 * Contiene campos de número de cuenta, contraseña, y opciones para iniciar sesión o registrarse.
 */
public class LoginFrame extends JFrame {

    // Componentes de la pantalla
    private JTextField txtNumeroCuenta;
    private JPasswordField txtContraseña;
    private JButton btnLogin;
    private JButton btnRegistro;

    private LogicaBilletera logica; // Atributo para la lógica del sistema

    /**
     * Constructor que recibe la instancia de LogicaBilletera.
     * @param logica instancia de la lógica para manejar usuarios y transacciones
     */
    public LoginFrame(LogicaBilletera logica) {
        this.logica = logica;
        initComponents();
    }

    /**
     * Método que configura y agrega los componentes visuales.
     */
    private void initComponents() {
        setTitle("Money Tress - Login");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        txtNumeroCuenta = new JTextField();
        txtNumeroCuenta.setBorder(BorderFactory.createTitledBorder("Número de Cuenta"));
        panelPrincipal.add(txtNumeroCuenta);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtContraseña = new JPasswordField();
        txtContraseña.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        panelPrincipal.add(txtContraseña);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBackground(new Color(0, 153, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBackground(new Color(0, 204, 102));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setFocusPainted(false);
        btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(btnLogin);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnRegistro);

        add(panelPrincipal, BorderLayout.CENTER);

        // Eventos de botones
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irARegistro();
            }
        });
    }

    /**
 * Método que se ejecuta cuando se presiona "Iniciar Sesión".
 * Valida que los campos no estén vacíos, que el número de cuenta sea numérico
 * y realiza el proceso real de login usando LogicaBilletera.
 */
private void login() {
    String cuenta = txtNumeroCuenta.getText().trim();
    String contraseña = new String(txtContraseña.getPassword()).trim();

    // Validar que los campos no estén vacíos
    if (cuenta.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validar que el número de cuenta contenga solo números
    if (!cuenta.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "El número de cuenta solo debe contener números.", "Formato inválido", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Llamar a la lógica de negocio para autenticar al usuario
        Usuario usuario = logica.login(cuenta, contraseña);
        
        // Si login exitoso, mostrar mensaje y abrir HomeFrame
        JOptionPane.showMessageDialog(this, "¡Bienvenido " + usuario.getNombre() + "!", "Login exitoso", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Cerrar pantalla actual
        new HomeFrame(logica, usuario).setVisible(true); // Abrir pantalla principal
    } catch (Logica.UsuarioNoEncontradoException ex) {
        // Si el login falla, mostrar error
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Login", JOptionPane.ERROR_MESSAGE);
    }
}


    /**
     * Método que se ejecuta cuando se presiona "Registrarse".
     * Cierra el LoginFrame y abre la ventana de Registro.
     */
    private void irARegistro() {
        dispose();
        new RegistroFrame(logica).setVisible(true); // PASA la lógica
    }
}
