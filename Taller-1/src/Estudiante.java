/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keinenr Ramos
 */
public class Estudiante {
    private String nombre;
    private int edad;
    private String curso;
    
    
    public Estudiante() {
        this.nombre = "Sin nombre";
        this.edad = 0;
        this.curso = "Sin curso";
    }
    
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = "Sin curso";
    }
    
    public Estudiante(String nombre, int edad, String curso) {
        this(nombre, edad);
        this.curso = curso;
    }
    
    
    // Método toString()
    @Override
    public String toString() {
        return "Estudiante: [Nombre: " + nombre + ", Edad: " + edad + ", Curso: " + curso + "]";
    }
   
}
