/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class Vehiculo {
    // Propiedades protegidas
    protected String tipo;
    protected String marca;

    // Constructor
    public Vehiculo(String tipo, String marca) {
        this.tipo = tipo;
        this.marca = marca;
    }

    // Método para mostrar la información del vehículo
    public void mostrarInformacion() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
    }
}