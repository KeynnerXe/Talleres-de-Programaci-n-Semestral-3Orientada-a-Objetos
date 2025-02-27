/**
 *
 * @author Keynner Ramos
 */
// PruebaVehiculos.java


import Motos.Moto;
import Vehiculos.Vehiculo;

public class PruebaVehiculos {
    public static void main(String[] args) {
        // Crear una instancia de Vehiculo
        Vehiculo miVehiculo = new Vehiculo("Automóvil");

        // Intentar acceder a la propiedad tipo (privada) -> Error de compilación
        // System.out.println(miVehiculo.tipo); // Error: tipo tiene acceso privado en Vehiculo

        // Acceder al método público getTipo()
        System.out.println("Tipo de vehículo: " + miVehiculo.getTipo());

        // Crear una instancia de Moto
        Moto miMoto = new Moto("Motocicleta", 250);

        // Intentar acceder a la propiedad cilindrada (privada) -> Error de compilación
        // System.out.println(miMoto.cilindrada); // Error: cilindrada tiene acceso privado en Moto

        // Acceder al método público getCilindrada()
        System.out.println("Cilindrada de la moto: " + miMoto.getCilindrada());

        // Mostrar la información de la moto usando el método público mostrarInfo()
        miMoto.mostrarInfo();
    }
}
