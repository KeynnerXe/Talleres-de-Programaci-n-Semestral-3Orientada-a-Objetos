/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Keynner Ramos
 */
public class EjemploIncorrecto {
    // Atributo no estático
    private int valor;

    // Constructor
    public EjemploIncorrecto(int valor) {
        this.valor = valor;
    }

    // Método estático que intenta acceder y modificar un atributo no estático
    public /* static */ void modificarValor(int nuevoValor) {
        valor = nuevoValor; // Error: No se puede acceder a un atributo no estático desde un contexto estático
    }

    // Método no estático para mostrar el valor
    public void mostrarValor() {
        System.out.println("Valor: " + valor);
    }
}
