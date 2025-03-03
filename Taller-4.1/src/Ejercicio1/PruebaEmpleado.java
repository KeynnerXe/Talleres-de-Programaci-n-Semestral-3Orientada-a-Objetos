/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaEmpleado {
    public static void main(String[] args) {
        // Crear una instancia de Empleado
        Empleado empleado1 = new Empleado("Juan Pérez", 2500.0);

        // Acceder a la propiedad pública nombre directamente
        System.out.println("Nombre: " + empleado1.nombre);

        // Acceder a la propiedad privada salario usando el método get
        System.out.println("Salario: " + empleado1.getSalario());

        // Modificar la propiedad pública nombre directamente
        empleado1.nombre = "Ana Gómez";
        System.out.println("Nombre actualizado: " + empleado1.nombre);

        // Modificar la propiedad privada salario usando el método set
        empleado1.setSalario(3000.0); // Salario válido
        System.out.println("Nuevo Salario: " + empleado1.getSalario());

        // Intentar asignar un salario negativo (inválido)
        empleado1.setSalario(-1000.0); // Salario inválido

        // Mostrar la información actualizada del empleado
        System.out.println(empleado1);
    }
}
