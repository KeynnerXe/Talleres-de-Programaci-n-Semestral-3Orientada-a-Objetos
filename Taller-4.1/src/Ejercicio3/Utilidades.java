/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Keynner Ramos
 */
public class Utilidades {

    // Método para sumar dos números
    public static double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar dos números
    public static double restar(double a, double b) {
        return a - b;
    }

    // Método para multiplicar dos números
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para dividir dos números
    public static double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: No se puede dividir entre cero.");
            return Double.NaN; // Retorna "Not a Number" en caso de división por cero
        }
    }
}