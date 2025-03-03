/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaMatematicas {
    public static void main(String[] args) {
        // Definir dos números para las operaciones
        double num1 = 10.0;
        double num2 = 5.0;

        // Probar el método sumar
        System.out.println("Suma: " + Matematicas.sumar(num1, num2)); // 10.0 + 5.0 = 15.0

        // Probar el método restar
        System.out.println("Resta: " + Matematicas.restar(num1, num2)); // 10.0 - 5.0 = 5.0

        // Probar el método multiplicar
        System.out.println("Multiplicación: " + Matematicas.multiplicar(num1, num2)); // 10.0 * 5.0 = 50.0

        // Probar el método dividir
        System.out.println("División: " + Matematicas.dividir(num1, num2)); // 10.0 / 5.0 = 2.0

        // Probar división entre cero
        System.out.println("División entre cero: " + Matematicas.dividir(num1, 0)); // Error: No se puede dividir entre cero
    }
}
