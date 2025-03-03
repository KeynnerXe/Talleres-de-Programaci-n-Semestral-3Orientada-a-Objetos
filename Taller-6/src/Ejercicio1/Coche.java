/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class Coche {
    // Atributos de instancia
    private String marca;
    private String modelo;

    // Atributo estático para contar el número de coches creados
    private static int contadorCoches = 0;

    // Constructor
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        contadorCoches++; // Incrementar el contador cada vez que se crea un coche
    }

    // Métodos get y set para marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Métodos get y set para modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Método estático para mostrar el número de coches creados
    public static void mostrarContadorCoches() {
        System.out.println("Número total de coches creados: " + contadorCoches);
    }

    // Método para mostrar la información del coche
    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
