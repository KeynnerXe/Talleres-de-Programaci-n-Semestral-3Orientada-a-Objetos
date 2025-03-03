package Ejercicio1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keynner Ramos
 */
public class Main {
    public static void main(String[] args) {
        // Crear instancias de Persona, Estudiante y Profesor
        Persona persona = new Persona();
        Persona estudiante = new Estudiante();
        Persona profesor = new Profesor();

        // Usar polimorfismo para invocar el método presentarse
        persona.presentarse();    // Salida: Hola, soy una persona.
        estudiante.presentarse(); // Salida: Hola, soy un estudiante.
        profesor.presentarse();   // Salida: Hola, soy un profesor.
    }
}
