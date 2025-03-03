/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaCuentaBancaria {
    public static void main(String[] args) {
        // Crear una instancia de CuentaBancaria
        CuentaBancaria cuenta1 = new CuentaBancaria("123456789", 1500.0, "Ahorros");

        // Acceder a la propiedad pública tipoCuenta directamente
        System.out.println("Tipo de Cuenta: " + cuenta1.tipoCuenta);

        // Acceder a la propiedad privada saldo usando el método get
        System.out.println("Saldo: " + cuenta1.getSalario());

        // Modificar la propiedad pública tipoCuenta directamente
        cuenta1.tipoCuenta = "Corriente";
        System.out.println("Tipo de Cuenta actualizado: " + cuenta1.tipoCuenta);

        // Modificar la propiedad privada saldo usando el método set
        cuenta1.setSaldo(2000.0); // Saldo válido
        System.out.println("Nuevo Saldo: " + cuenta1.getSalario());

        // Intentar asignar un saldo negativo (inválido)
        cuenta1.setSaldo(-500.0); // Saldo inválido

        // Mostrar los detalles de la cuenta
        cuenta1.mostrarDetalles();

        // Intentar acceder directamente a la propiedad privada numeroCuenta (esto generará errores de compilación)
        // System.out.println(cuenta1.numeroCuenta); // Error: numeroCuenta has private access in CuentaBancaria
    }
}
