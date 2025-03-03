/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Victor ramos
 */
public class Moto extends Vehiculo {
    // Propiedad adicional
    private int cilindrada;

    // Constructor
    public Moto(String tipo, String marca, int cilindrada) {
        super(tipo, marca); // Llama al constructor de la clase base (Vehículo)
        this.cilindrada = cilindrada;
    }

    // Sobrescribir el método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base (Vehículo)
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }
}
