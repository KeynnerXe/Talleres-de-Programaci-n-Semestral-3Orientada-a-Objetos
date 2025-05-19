package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;
import Modelos.Usuario;
import Modelos.Transaccion;

/**
 * Pantalla para enviar dinero a otro usuario en la billetera virtual.
 */
public class EnviarDineroFrame extends JFrame {

    private JTextField txtCuentaDestino;
    private JTextField txtMonto;
    private JButton btnEnviar;
    private JButton btnCancelar;

    private LogicaBilletera logica;
    private Usuario usuarioActual;

    /**
     * Constructor que recibe la lógica y el usuario actual.
     * @param logica instancia de LogicaBilletera
     * @param usuario usuario actualmente logueado
     */
    public EnviarDineroFrame(LogicaBilletera logica, Usuario usuario) {
        this.logica = logica;
        this.usuarioActual = usuario;
        initComponents();
    }

    /**
     * Método que configura los componentes visuales.
     */
    private void initComponents() {
        setTitle("Enviar Dinero");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        JLabel lblTitulo = new JLabel("Ingrese los datos de envío");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtCuentaDestino = new JTextField();
        txtCuentaDestino.setBorder(BorderFactory.createTitledBorder("Número de Cuenta Destino"));
        panelPrincipal.add(txtCuentaDestino);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtMonto = new JTextField();
        txtMonto.setBorder(BorderFactory.createTitledBorder("Monto a Enviar"));
        panelPrincipal.add(txtMonto);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        btnEnviar = new JButton("Enviar Dinero");
        btnEnviar.setBackground(new Color(0, 153, 255));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 102, 102));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(btnEnviar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnCancelar);

        add(panelPrincipal, BorderLayout.CENTER);

        eventosBotones();
    }

    /**
     * Método que define los eventos de los botones.
     */
    private void eventosBotones() {
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDinero();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarEnvio();
            }
        });
    }

    /**
     * Método que procesa el envío de dinero.
     */
    private void enviarDinero() {
        String cuentaDestino = txtCuentaDestino.getText().trim();
        String montoTexto = txtMonto.getText().trim();

        if (cuentaDestino.isEmpty() || montoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos.", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!cuentaDestino.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El número de cuenta debe contener solo números.", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!montoTexto.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un número válido.", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cuentaDestino.equals(usuarioActual.getNumeroCuenta())) {
            JOptionPane.showMessageDialog(this, "No puedes enviarte dinero a ti mismo.", "Error de operación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double monto = Double.parseDouble(montoTexto);

        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "El monto debe ser mayor a cero.", "Monto inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario destinatario = logica.buscarUsuarioPorCuenta(cuentaDestino);

        if (destinatario == null) {
            JOptionPane.showMessageDialog(this, "El número de cuenta destino no existe.", "Cuenta no encontrada", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usuarioActual.getSaldo() < monto) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente para realizar la transferencia.", "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Realizar la transferencia y registrar transacciones
        usuarioActual.setSaldo(usuarioActual.getSaldo() - monto);
        destinatario.setSaldo(destinatario.getSaldo() + monto);

        Transaccion transaccionEnvio = new Transaccion("Envio a " + destinatario.getNumeroCuenta(), monto);
        usuarioActual.agregarTransaccion(transaccionEnvio);

        Transaccion transaccionRecibo = new Transaccion("Recibo de " + usuarioActual.getNumeroCuenta(), monto);
        destinatario.agregarTransaccion(transaccionRecibo);

        JOptionPane.showMessageDialog(this, "¡Transferencia exitosa! Nuevo saldo: $" + usuarioActual.getSaldo(), "Envío Completado", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new HomeFrame(logica, usuarioActual).setVisible(true);
    }

    /**
     * Método para cancelar y volver al HomeFrame.
     */
    private void cancelarEnvio() {
        dispose();
        new HomeFrame(logica, usuarioActual).setVisible(true);
    }
}
