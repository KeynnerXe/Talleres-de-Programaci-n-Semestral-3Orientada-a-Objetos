package Ejercicio1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keynner Ramos
 */
// Clase base Persona
class Persona {
    public void presentarse() {
        System.out.println("Hola, soy una persona llamada keynner.");
    }
}

// Clase derivada Estudiante
class Estudiante extends Persona {
    @Override
    public void presentarse() {
        System.out.println("Hola, soy un estudiante llamado Keynner Ramos.");
    }
}

// Clase derivada Profesor
class Profesor extends Persona {
    @Override
    public void presentarse() {
        System.out.println("Hola, soy un profesor llamado Carlos lozano te parto el ano.");
    }
}
