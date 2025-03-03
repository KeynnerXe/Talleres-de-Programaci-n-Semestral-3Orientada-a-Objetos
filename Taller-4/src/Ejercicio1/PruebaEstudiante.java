package Ejercicio1;

/**
 *
 * @author Keynner Ramos
 */
public class PruebaEstudiante {
    public static void main(String[] args) {
        // Crear una instancia de Estudiante
        Estudiante estudiante1 = new Estudiante("Juan Pérez", 20, 8.5);

        // Acceder a las propiedades usando los métodos get
        System.out.println("Nombre: " + estudiante1.getNombre());
        System.out.println("Edad: " + estudiante1.getEdad());
        System.out.println("Nota Promedio: " + estudiante1.getNotaPromedio());

        // Modificar las propiedades usando los métodos set
        estudiante1.setNombre("Ana Gómez");
        estudiante1.setEdad(22);
        estudiante1.setNotaPromedio(9.0);

        // Mostrar la información actualizada del estudiante
        System.out.println(estudiante1);

        // Intentar asignar valores inválidos
        estudiante1.setNombre(""); // Nombre vacío
        estudiante1.setEdad(-5); // Edad inválida
        estudiante1.setNotaPromedio(11.0); // Nota inválida

        // Mostrar la información del estudiante después de intentar asignar valores inválidos
        System.out.println(estudiante1);
    }
}
