/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
// Clase Vehiculo
class Vehiculo {
    // Método moverse de la clase Vehiculo
    public void moverse() {
        System.out.println("El vehículo se está moviendo de manera general.");
    }
}

// Clase Bicicleta que hereda de Vehiculo
class Bicicleta extends Vehiculo {
    // Sobrescritura del método moverse
    @Override
    public void moverse() {
        System.out.println("La bicicleta se está moviendo pedaleando.");
    }
}


