package PaqueteA;

/**
 *
 * @author Keynner Ramos
 */
import javax.swing.JOptionPane;

public class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = "Desconocido";
        this.precio = 0.0;
        this.stock = 0;
    }
    
    public void MostraInf() {
        JOptionPane.showMessageDialog(null, "Nombre: " + this.nombre);
        JOptionPane.showMessageDialog(null, "Precio: " + this.precio);
        JOptionPane.showMessageDialog(null, "Stock: " + this.stock);
    }
    
    public static void main(String[] args) {
        Producto p = new Producto("Desconocido", 0.0, 0);
        p.MostraInf();
    }
    
}   
