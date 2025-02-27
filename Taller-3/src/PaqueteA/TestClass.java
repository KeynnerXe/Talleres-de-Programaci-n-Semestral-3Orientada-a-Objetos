package PaqueteA;

/**
 *
 * @author Keynner Ramos
 */
import javax.swing.JOptionPane;

public class TestClass {
    public static void main(String[] args) {
        
        Producto p = new Producto("Teclado", 25.990, 50);
        
        JOptionPane.showMessageDialog(null, "Nombre: " + p.nombre);
        JOptionPane.showMessageDialog(null, "Precio: " + p.precio);
        JOptionPane.showMessageDialog(null, "Stock: " + p.stock); 
        
        
    }
}


