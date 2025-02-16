/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keinner Ramos
 */
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Libro
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        int paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas del libro:"));

        Libro libro = new Libro(titulo, autor, paginas);

        // Crear un objeto de la clase CuentaBancaria
        String numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        String tipoCuenta = JOptionPane.showInputDialog("Ingrese el tipo de cuenta:");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));

        // Usar el constructor con tres parámetros
        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, saldo, tipoCuenta);

        // Crear un objeto de la clase Estudiante
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante:"));
        String curso = JOptionPane.showInputDialog("Ingrese el curso del estudiante:");

        Estudiante estudiante = new Estudiante(nombre, edad, curso);

        // Mostrar los detalles de los objetos usando JOptionPane
        JOptionPane.showMessageDialog(null, "Detalles del libro:\n" + libro.toString());
        JOptionPane.showMessageDialog(null, "Detalles de la cuenta bancaria:\n" + cuenta.toString());
        JOptionPane.showMessageDialog(null, "Detalles del estudiante:\n" + estudiante.toString());
    }
}
