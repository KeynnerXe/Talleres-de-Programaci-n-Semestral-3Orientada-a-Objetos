/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class Coche {
    // Propiedades privadas
    private String marca;
    private String modelo;
    private int velocidadMaxima;

    // Constructor
    public Coche(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    // Métodos get y set para marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca != null && !marca.isEmpty()) {
            this.marca = marca;
        } else {
            System.out.println("La marca no puede estar vacía o ser nula.");
        }
    }

    // Métodos get y set para modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.isEmpty()) {
            this.modelo = modelo;
        } else {
            System.out.println("El modelo no puede estar vacío o ser nulo.");
        }
    }

    // Método get para velocidadMaxima
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    // Método acelerar para incrementar la velocidad máxima
    public void acelerar(int incremento) {
        if (incremento > 0) {
            this.velocidadMaxima += incremento;
        } else {
            System.out.println("El incremento debe ser un valor positivo.");
        }
    }

    // Método para mostrar la información del coche
    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadMaxima=" + velocidadMaxima +
                '}';
    }
}
