package Ejercicio2;

/**
 *
 * @author Keynner Ramos
 */
// Clase de prueba
public class PruebaVehiculos {
    public static void main(String[] args) {
        // Instanciar un objeto de la clase Vehiculo
        Vehiculo miVehiculo = new Vehiculo();
        // Llamar al método moverse de Vehiculo
        miVehiculo.moverse();

        // Instanciar un objeto de la clase Bicicleta
        Bicicleta miBicicleta = new Bicicleta();
        // Llamar al método moverse de Bicicleta (sobrescrito)
        miBicicleta.moverse();
    }
}
