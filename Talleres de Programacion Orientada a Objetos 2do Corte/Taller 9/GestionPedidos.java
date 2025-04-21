import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class GestionPedidos extends JFrame {
    JList<String> lstProductos;
    JTextField txtUnidades;
    JComboBox<String> cboDestino, cboTipoEnvio;
    JButton btnCalcular;
    JLabel etiResultado;

    String[] productos = {
            "Sistema de Localización - 120",
            "Centro de Control - 60",
            "Modem GSM - 45"
    };

    public GestionPedidos() {
        setTitle("GESTIÓN DE PEDIDOS");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Lista de productos
        JLabel lblProductos = new JLabel("Productos:");
        lblProductos.setBounds(20, 20, 100, 20);
        add(lblProductos);

        lstProductos = new JList<>(productos);
        lstProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(lstProductos);
        scroll.setBounds(20, 45, 200, 70);
        add(scroll);

        // Campo de unidades
        JLabel lblUnidades = new JLabel("Unidades:");
        lblUnidades.setBounds(250, 20, 100, 20);
        add(lblUnidades);

        txtUnidades = new JTextField();
        txtUnidades.setBounds(250, 45, 100, 30);
        add(txtUnidades);

        // Combo destino
        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(20, 130, 100, 20);
        add(lblDestino);

        cboDestino = new JComboBox<>(new String[]{"Península", "Canarias", "Extranjero"});
        cboDestino.setBounds(100, 125, 120, 30);
        add(cboDestino);

        // Combo tipo envío
        JLabel lblTipoEnvio = new JLabel("Tipo Envío:");
        lblTipoEnvio.setBounds(250, 130, 100, 20);
        add(lblTipoEnvio);

        cboTipoEnvio = new JComboBox<>(new String[]{"Normal", "Urgente"});
        cboTipoEnvio.setBounds(330, 125, 100, 30);
        add(cboTipoEnvio);

        // Botón calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(160, 180, 120, 40);
        add(btnCalcular);

        // Etiqueta resultado
        etiResultado = new JLabel("Total: 0.00 €", SwingConstants.CENTER);
        etiResultado.setBorder(new LineBorder(Color.BLACK));
        etiResultado.setBounds(120, 240, 200, 50);
        add(etiResultado);

        // Acción botón
        btnCalcular.addActionListener(e -> calcularTotal());
    }

    private void calcularTotal() {
        int index = lstProductos.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precioProducto = switch (index) {
            case 0 -> 120;
            case 1 -> 60;
            case 2 -> 45;
            default -> 0;
        };

        int unidades;
        try {
            unidades = Integer.parseInt(txtUnidades.getText());
            if (unidades <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Unidades inválidas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double costeDestino = switch (cboDestino.getSelectedItem().toString()) {
            case "Península" -> 20;
            case "Canarias" -> 25;
            case "Extranjero" -> 30;
            default -> 0;
        };

        double costeTipo = cboTipoEnvio.getSelectedItem().toString().equals("Urgente") ? 10 : 3;

        double total = (unidades * precioProducto) + costeDestino + costeTipo;

        etiResultado.setText(String.format("Total: %.2f €", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GestionPedidos().setVisible(true);
        });
    }
}
