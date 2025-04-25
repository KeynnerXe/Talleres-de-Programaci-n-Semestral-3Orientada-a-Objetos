/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller33;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author anton
 */

public class VentaForm extends JFrame {
    private JTextField txtProducto, txtUnidades, txtPrecio, txtFecha, txtFormaPago;
    private JComboBox<Cliente> comboClientes;
    private JComboBox<Comercial> comboComerciales;
    private JButton btnGuardar;

    public VentaForm() {
        setTitle("Formulario de Venta");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Componentes de la interfaz
        JLabel lblProducto = new JLabel("Producto:");
        txtProducto = new JTextField(20);
        JLabel lblUnidades = new JLabel("Unidades:");
        txtUnidades = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(20);
        JLabel lblFecha = new JLabel("Fecha:");
        txtFecha = new JTextField(20);
        JLabel lblFormaPago = new JLabel("Forma de pago:");
        txtFormaPago = new JTextField(20);

        // ComboBox para seleccionar Cliente y Comercial
        JLabel lblCliente = new JLabel("Cliente:");
        comboClientes = new JComboBox<>(obtenerClientes());
        JLabel lblComercial = new JLabel("Comercial:");
        comboComerciales = new JComboBox<>(obtenerComerciales());

        btnGuardar = new JButton("Guardar");

        // Layout
        setLayout(new FlowLayout());
        add(lblProducto);
        add(txtProducto);
        add(lblUnidades);
        add(txtUnidades);
        add(lblPrecio);
        add(txtPrecio);
        add(lblFecha);
        add(txtFecha);
        add(lblFormaPago);
        add(txtFormaPago);
        add(lblCliente);
        add(comboClientes);
        add(lblComercial);
        add(comboComerciales);
        add(btnGuardar);

        // Evento para guardar la venta
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = (Cliente) comboClientes.getSelectedItem();
                Comercial comercial = (Comercial) comboComerciales.getSelectedItem();

                Venta venta = new Venta(0, txtProducto.getText(), Integer.parseInt(txtUnidades.getText()), 
                                        Double.parseDouble(txtPrecio.getText()), txtFecha.getText(), 
                                        txtFormaPago.getText(), cliente, comercial);
                venta.guardarVenta();
                JOptionPane.showMessageDialog(null, "Venta guardada correctamente");
            }
        });
    }

    // Método para obtener los clientes desde la base de datos
    private Cliente[] obtenerClientes() {
        // Aquí obtendrás los datos de la base de datos
        return new Cliente[]{ new Cliente("CIF001", "Juan Perez", "Madrid", "123456789") };
    }

    // Método para obtener los comerciales desde la base de datos
    private Comercial[] obtenerComerciales() {
        // Aquí obtendrás los datos de la base de datos
        return new Comercial[]{ new Comercial(1, "Carlos", "Gómez", "987654321") };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentaForm().setVisible(true);
        });
    }
}

