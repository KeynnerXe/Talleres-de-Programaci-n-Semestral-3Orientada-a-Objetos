package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class Estudiante {
    // Propiedades privadas
    private String nombre;
    private int edad;
    private double notaPromedio;

    // Constructor
    public Estudiante(String nombre, int edad, double notaPromedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaPromedio = notaPromedio;
    }

    // Métodos get y set para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede estar vacío o ser nulo.");
        }
    }

    // Métodos get y set para edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe estar entre 0 y 120 años.");
        }
    }

    // Métodos get y set para notaPromedio
    public double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(double notaPromedio) {
        if (notaPromedio >= 0.0 && notaPromedio <= 10.0) {
            this.notaPromedio = notaPromedio;
        } else {
            System.out.println("La nota promedio debe estar entre 0.0 y 10.0.");
        }
    }

    // Método para mostrar la información del estudiante
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", notaPromedio=" + notaPromedio +
                '}';
    }
}
