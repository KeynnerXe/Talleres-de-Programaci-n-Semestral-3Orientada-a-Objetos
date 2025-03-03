/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaVehiculoMoto {
    public static void main(String[] args) {
        // Crear una instancia de Moto
        Moto moto1 = new Moto("Motocicleta", "Yamaha", 250);
        System.out.println("Información de la Moto:");
        moto1.mostrarInformacion();

        System.out.println(); // Separador

        // Intentar acceder a los miembros protected desde una clase no relacionada (esto generará errores de compilación)
        // Vehiculo vehiculo1 = new Vehiculo("Automóvil", "Toyota");
        // System.out.println(vehiculo1.tipo); // Error: tipo has protected access in Vehiculo
        // System.out.println(vehiculo1.marca); // Error: marca has protected access in Vehiculo
    }
}
