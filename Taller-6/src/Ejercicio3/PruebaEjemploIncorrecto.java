/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Victor ramos
 */
public class PruebaEjemploIncorrecto {
    public static void main(String[] args) {
        // Crear una instancia de la clase
        EjemploIncorrecto ejemplo = new EjemploIncorrecto(10);

        // Intentar llamar al método estático para modificar el valor
        // EjemploIncorrecto.modificarValor(20); // Esto generará un error de compilación

        // Mostrar el valor actual
        ejemplo.mostrarValor();
    }
}
