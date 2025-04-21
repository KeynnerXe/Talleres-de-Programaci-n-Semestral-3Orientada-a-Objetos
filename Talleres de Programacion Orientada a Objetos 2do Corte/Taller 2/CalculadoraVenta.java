import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraVenta extends JFrame implements ActionListener {
    private JTextField txtUnidades, txtPrecio;
    private JLabel etiTotalSinIva, etiIva, etiTotalMasIva;
    private JButton btnCalcular;

    public CalculadoraVenta() {
        setLayout(new GridLayout(6, 2));
        
        add(new JLabel("Unidades:"));
        txtUnidades = new JTextField();
        add(txtUnidades);
        
        add(new JLabel("Precio unitario:"));
        txtPrecio = new JTextField();
        add(txtPrecio);
        
        add(new JLabel("Total sin IVA:"));
        etiTotalSinIva = new JLabel("0.00");
        add(etiTotalSinIva);
        
        add(new JLabel("IVA (21%):"));
        etiIva = new JLabel("0.00");
        add(etiIva);
        
        add(new JLabel("Total con IVA:"));
        etiTotalMasIva = new JLabel("0.00");
        add(etiTotalMasIva);
        
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        add(btnCalcular);
        
        setTitle("Calculadora de Venta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int unidades = Integer.parseInt(txtUnidades.getText());
            double precio = Double.parseDouble(txtPrecio.getText());
            
            double totalSinIva = unidades * precio;
            double iva = totalSinIva * 0.21;
            double totalConIva = totalSinIva + iva;
            
            etiTotalSinIva.setText(String.format("%.2f", totalSinIva));
            etiIva.setText(String.format("%.2f", iva));
            etiTotalMasIva.setText(String.format("%.2f", totalConIva));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos");
        }
    }

    public static void main(String[] args) {
        new CalculadoraVenta();
    }
}