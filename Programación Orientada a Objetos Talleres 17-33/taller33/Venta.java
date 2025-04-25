/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller33;
import java.sql.*;
/**
 *
 * @author anton
 */
public class Venta {
    
 private int id;
    private String producto;
    private int unidades;
    private double precio;
    private String fecha;
    private String formaPago;
    private Cliente cliente;
    private Comercial comercial;

    // Constructor
    public Venta(int id, String producto, int unidades, double precio, String fecha, String formaPago, Cliente cliente, Comercial comercial) {
        this.id = id;
        this.producto = producto;
        this.unidades = unidades;
        this.precio = precio;
        this.fecha = fecha;
        this.formaPago = formaPago;
        this.cliente = cliente;
        this.comercial = comercial;
    }

    // Métodos getter y setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getFormaPago() { return formaPago; }
    public void setFormaPago(String formaPago) { this.formaPago = formaPago; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Comercial getComercial() { return comercial; }
    public void setComercial(Comercial comercial) { this.comercial = comercial; }

    public void guardarVenta() {
        Connection conn = ConexionDB.getConexion();
        if (conn != null) {
            try {
                String sql = "INSERT INTO ventas (producto, unidades, precio, fecha, formaPago, cliente, comercial) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, this.producto);
                stmt.setInt(2, this.unidades);
                stmt.setDouble(3, this.precio);
                stmt.setString(4, this.fecha);
                stmt.setString(5, this.formaPago);
                stmt.setString(6, this.cliente.getCif());
                stmt.setInt(7, this.comercial.getNumero());
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al guardar la venta: " + e.getMessage());
            }
        }
    }
}
