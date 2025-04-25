/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller29;

/**
 *
 * @author anton
 */
public class Pedido {
    
 private String cliente;
    private String estado;
    private String direccion;
    private double total;

    // Constructor
    public Pedido(String cliente, String direccion) {
        this.cliente = cliente;
        this.direccion = direccion;
        this.estado = "Pendiente";
        this.total = 0.0;
    }

    // Métodos set y get
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return this.total;
    }

    // Método para actualizar el estado del pedido
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Método para calcular el total (esto es solo un ejemplo)
    public void calcularTotal() {
        // Lógica para calcular el total según los productos del pedido
    }
}

