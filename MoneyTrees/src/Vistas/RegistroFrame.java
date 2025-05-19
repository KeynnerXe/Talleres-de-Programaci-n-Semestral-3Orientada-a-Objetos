package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;

/**
 * Pantalla de registro para crear una nueva cuenta en la Billetera Virtual.
 */
public class RegistroFrame extends JFrame {

    // Componentes de la pantalla de registro
    private JTextField txtNombre;
    private JTextField txtNumeroCuenta;
    private JPasswordField txtContraseña;
    private JButton btnRegistrar;
    private JButton btnVolver;
    
    // Instancia de la lógica del sistema
    private LogicaBilletera logica;

    /**
     * Constructor que recibe la instancia de LogicaBilletera.
     * @param logica instancia de la lógica para manejar usuarios y transacciones
     */
    public RegistroFrame(LogicaBilletera logica) {
        this.logica = logica;
        initComponents();
    }

    /**
     * Método que configura y agrega los componentes visuales.
     */
    private void initComponents() {
        setTitle("Money Trees - Registro");
        setSize(400, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        JLabel lblTitulo = new JLabel("Crear Nueva Cuenta");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        txtNombre = new JTextField();
        txtNombre.setBorder(BorderFactory.createTitledBorder("Nombre completo"));
        panelPrincipal.add(txtNombre);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtNumeroCuenta = new JTextField();
        txtNumeroCuenta.setBorder(BorderFactory.createTitledBorder("Número de Cuenta"));
        panelPrincipal.add(txtNumeroCuenta);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtContraseña = new JPasswordField();
        txtContraseña.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        panelPrincipal.add(txtContraseña);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        btnRegistrar = new JButton("Registrar Cuenta");
        btnRegistrar.setBackground(new Color(0, 153, 255));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnVolver = new JButton("Volver al Login");
        btnVolver.setBackground(new Color(255, 102, 102));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(btnRegistrar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnVolver);

        add(panelPrincipal, BorderLayout.CENTER);

        // Eventos de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCuenta();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverALogin();
            }
        });
    }

 /**
 * Método que se ejecuta al presionar "Registrar Cuenta".
 * Valida que los campos estén completos, el número de cuenta solo contenga números,
 * y que no exista una cuenta duplicada antes de registrar al usuario.
 */
private void registrarCuenta() {
    String nombre = txtNombre.getText().trim();
    String numeroCuenta = txtNumeroCuenta.getText().trim();
    String contraseña = new String(txtContraseña.getPassword()).trim();

    // Validar que no haya campos vacíos
    if (nombre.isEmpty() || numeroCuenta.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que el número de cuenta contenga solo números
    if (!numeroCuenta.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "El número de cuenta solo debe contener números.", "Formato inválido", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar que la contraseña tenga mínimo 4 caracteres
    if (contraseña.length() < 4) {
        JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 4 caracteres.", "Contraseña débil", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validar que no exista una cuenta con el mismo número
    if (logica.existeNumeroCuenta(numeroCuenta)) {
        JOptionPane.showMessageDialog(this, "El número de cuenta ya existe. Usa otro.", "Cuenta existente", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Registrar al nuevo usuario usando la lógica
    logica.registrarUsuario(nombre, numeroCuenta, contraseña);

    // Mostrar mensaje de éxito
    JOptionPane.showMessageDialog(this, "¡Cuenta registrada exitosamente!");

    // Volver a la pantalla de login
    dispose();
    new LoginFrame(logica).setVisible(true);
}


    /**
     * Método que se ejecuta al presionar "Volver al Login".
     * Cierra esta ventana y abre la pantalla de login.
     */
    private void volverALogin() {
        dispose();
        new LoginFrame(logica).setVisible(true);
    }
}
