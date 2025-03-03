/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaBanco {
    public static void main(String[] args) {
        // Crear una instancia de Banco
        Banco cuenta = new Banco(1000.0);

        // Mostrar saldo inicial
        cuenta.mostrarInformacion();

        // Depositar dinero
        cuenta.depositar(500.0);

        // Retirar dinero
        cuenta.retirar(200.0);

        // Intentar retirar más de lo disponible
        cuenta.retirar(2000.0);

        // Intentar establecer un saldo negativo
        cuenta.setSaldo(-100.0);

        // Mostrar saldo final
        cuenta.mostrarInformacion();
    }
}
