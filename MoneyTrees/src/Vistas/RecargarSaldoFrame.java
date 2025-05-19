package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.LogicaBilletera;
import Modelos.Usuario;
import Modelos.Transaccion;

/**
 * Pantalla para recargar saldo en la billetera virtual.
 * Permite ingresar un monto y actualizar el saldo del usuario.
 */
public class RecargarSaldoFrame extends JFrame {

    private JTextField txtMonto;
    private JButton btnRecargar;
    private JButton btnCancelar;

    private LogicaBilletera logica; // Lógica del sistema
    private Usuario usuarioActual; // Usuario logueado

    /**
     * Constructor que recibe la lógica y el usuario.
     * @param logica instancia de LogicaBilletera
     * @param usuario usuario actualmente logueado
     */
    public RecargarSaldoFrame(LogicaBilletera logica, Usuario usuario) {
        this.logica = logica;
        this.usuarioActual = usuario;
        initComponents();
    }

    /**
     * Método que configura los componentes visuales.
     */
    private void initComponents() {
        setTitle("Recargar Saldo");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelPrincipal.setBackground(new Color(245, 245, 245));

        JLabel lblTitulo = new JLabel("Ingrese el monto a recargar");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        txtMonto = new JTextField();
        txtMonto.setBorder(BorderFactory.createTitledBorder("Monto"));
        panelPrincipal.add(txtMonto);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 30)));

        btnRecargar = new JButton("Recargar");
        btnRecargar.setBackground(new Color(0, 204, 102));
        btnRecargar.setForeground(Color.WHITE);
        btnRecargar.setFocusPainted(false);
        btnRecargar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 102, 102));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelPrincipal.add(btnRecargar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));
        panelPrincipal.add(btnCancelar);

        add(panelPrincipal, BorderLayout.CENTER);

        eventosBotones();
    }

    /**
     * Método que define los eventos de los botones.
     */
    private void eventosBotones() {
        btnRecargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recargarSaldo();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarRecarga();
            }
        });
    }

    /**
     * Método que procesa la recarga del saldo.
     * Valida que el monto ingresado sea válido.
     */
    private void recargarSaldo() {
        String montoTexto = txtMonto.getText().trim();

        if (montoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un monto.", "Campo vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!montoTexto.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un número válido (ej: 100 o 100.50).", "Formato inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double monto = Double.parseDouble(montoTexto);

        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "El monto debe ser mayor a cero.", "Monto inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Realizar la recarga
        usuarioActual.setSaldo(usuarioActual.getSaldo() + monto);

        // Crear una transacción de recarga y agregar al historial
        Transaccion transaccion = new Transaccion("Recarga", monto);
        usuarioActual.agregarTransaccion(transaccion);

        JOptionPane.showMessageDialog(this, "¡Recarga exitosa! Nuevo saldo: $" + usuarioActual.getSaldo(), "Recarga Completada", JOptionPane.INFORMATION_MESSAGE);

        dispose();
        new HomeFrame(logica, usuarioActual).setVisible(true);
    }

    /**
     * Método para cancelar y volver a HomeFrame.
     */
    private void cancelarRecarga() {
        dispose();
        new HomeFrame(logica, usuarioActual).setVisible(true);
    }
}
