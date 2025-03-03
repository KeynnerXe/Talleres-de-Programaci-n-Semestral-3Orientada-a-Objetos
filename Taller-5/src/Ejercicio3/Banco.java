/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Keynner Ramos
 */
public class Banco {
    // Propiedad privada
    private double saldo;

    // Constructor
    public Banco(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método get para saldo
    public double getSaldo() {
        return saldo;
    }

    // Método set para saldo con validación
    public void setSaldo(double nuevoSaldo) {
        if (nuevoSaldo >= 0) { // Validación para evitar saldos negativos
            this.saldo = nuevoSaldo;
        } else {
            System.out.println("Error: El saldo no puede ser negativo.");
        }
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser positiva.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: Fondos insuficientes o cantidad inválida.");
        }
    }

    // Método para mostrar la información de la cuenta
    public void mostrarInformacion() {
        System.out.println("Saldo actual: " + saldo);
    }
}
