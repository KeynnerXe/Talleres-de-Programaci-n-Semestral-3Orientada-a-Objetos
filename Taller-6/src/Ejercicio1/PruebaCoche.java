/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaCoche {
    public static void main(String[] args) {
        // Crear instancias de Coche
        Coche coche1 = new Coche("Toyota", "Corolla");
        Coche coche2 = new Coche("Honda", "Civic");
        Coche coche3 = new Coche("Ford", "Mustang");

        // Mostrar la información de los coches
        System.out.println(coche1);
        System.out.println(coche2);
        System.out.println(coche3);

        // Mostrar el número total de coches creados
        Coche.mostrarContadorCoches();
    }
}
