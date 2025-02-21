/**
 *
 * @author Keynner Ramos
 */

import javax.swing.*;

public class Producto {
    private String nombre;
    private double precio;
    
    public Producto() {
        this.nombre = "Desconocido";
        this.precio = 0.0;
    }
    
    public void MostrarProducto() {
        JOptionPane.showInternalMessageDialog(null, "Nombre: " + this.nombre);
        JOptionPane.showInternalMessageDialog(null,"precio: " + this.precio);
    }
    
    public static void main(String[] args) {
       Producto pd = new Producto();
       pd.MostrarProducto();
    }
}
