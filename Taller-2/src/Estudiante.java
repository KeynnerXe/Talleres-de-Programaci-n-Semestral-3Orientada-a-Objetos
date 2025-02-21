/**
 *
 * @author Keynner Ramos
 */
import javax.swing.*;

public class Estudiante {
    private String nombre;
    private int edad;
    
    public Estudiante(){
        this("Desconocido" , 0);
    }
    
    public Estudiante (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void MostrarEstudiante() {
        JOptionPane.showInternalMessageDialog(null, "Nombre: " + this.nombre);
        JOptionPane.showInternalMessageDialog(null, "Edad: " + this.edad);
    }
    
    
    public static void main(String[] args) {
        Estudiante student = new Estudiante();
        student.MostrarEstudiante();
    }
}
