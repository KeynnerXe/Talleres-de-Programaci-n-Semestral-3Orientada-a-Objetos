/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaUtilidades {
    public static void main(String[] args) {
        // Definir dos números para las operaciones
        double num1 = 10.0;
        double num2 = 5.0;

        // Probar el método sumar
        System.out.println("Suma: " + Utilidades.sumar(num1, num2)); // 10.0 + 5.0 = 15.0

        // Probar el método restar
        System.out.println("Resta: " + Utilidades.restar(num1, num2)); // 10.0 - 5.0 = 5.0

        // Probar el método multiplicar
        System.out.println("Multiplicacion: " + Utilidades.multiplicar(num1, num2)); // 10.0 * 5.0 = 50.0

        // Probar el método dividir
        System.out.println("Division: " + Utilidades.dividir(num1, num2)); // 10.0 / 5.0 = 2.0

        // Probar división entre cero
        System.out.println("Division entre cero: " + Utilidades.dividir(num1, 0)); // Error: No se puede dividir entre cero
    }
}
