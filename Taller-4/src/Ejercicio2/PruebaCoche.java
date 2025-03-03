/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaCoche {
    public static void main(String[] args) {
        // Crear una instancia de Coche
        Coche coche1 = new Coche("Toyota", "Corolla", 180);

        // Acceder a las propiedades usando los métodos get
        System.out.println("Marca: " + coche1.getMarca());
        System.out.println("Modelo: " + coche1.getModelo());
        System.out.println("Velocidad Máxima: " + coche1.getVelocidadMaxima());

        // Intentar acceder directamente a las propiedades privadas (esto generará errores de compilación)
        // System.out.println(coche1.marca); // Error: marca has private access in Coche
        // System.out.println(coche1.modelo); // Error: modelo has private access in Coche
        // System.out.println(coche1.velocidadMaxima); // Error: velocidadMaxima has private access in Coche

        // Modificar las propiedades usando los métodos set
        coche1.setMarca("Honda");
        coche1.setModelo("Civic");

        // Incrementar la velocidad máxima usando el método acelerar
        coche1.acelerar(20); // Incremento válido
        System.out.println("Nueva Velocidad Máxima: " + coche1.getVelocidadMaxima());

        // Intentar incrementar la velocidad máxima con un valor no válido
        coche1.acelerar(-10); // Incremento no válido

        // Mostrar la información actualizada del coche
        System.out.println(coche1);
    }
}
