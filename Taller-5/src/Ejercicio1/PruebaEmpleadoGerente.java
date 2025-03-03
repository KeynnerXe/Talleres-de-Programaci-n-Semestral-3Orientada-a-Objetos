/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaEmpleadoGerente {
    public static void main(String[] args) {
        // Crear una instancia de Empleado
        Empleado empleado1 = new Empleado("Juan Pérez", 2500.0);
        System.out.println("Información del Empleado:");
        empleado1.mostrarInformacion();

        System.out.println(); // Separador

        // Crear una instancia de Gerente
        Gerente gerente1 = new Gerente("Ana Gómez", 5000.0, "Ventas");
        System.out.println("Información del Gerente:");
        gerente1.mostrarInformacion();
    }
}
