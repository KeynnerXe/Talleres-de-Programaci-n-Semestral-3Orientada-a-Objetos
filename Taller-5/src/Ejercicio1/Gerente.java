/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class Gerente extends Empleado {
    // Propiedad adicional
    private String departamento;

    // Constructor
    public Gerente(String nombre, double salario, String departamento) {
        super(nombre, salario); // Llama al constructor de la clase base (Empleado)
        this.departamento = departamento;
    }

    // Sobrescribir el método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base (Empleado)
        System.out.println("Departamento: " + departamento);
    }
}
