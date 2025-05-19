package Logica;

import java.util.List;
import java.util.ArrayList;
import Modelos.Transaccion;

/**
 * Clase que gestiona el historial de transacciones de los usuarios.
 * Guarda las transacciones realizadas y permite visualizar el historial completo.
 * 
 * @author Dimerson
 */
public class HistorialTransacciones {

    private List<Transaccion> historial; // Lista de transacciones realizadas

    // Constructor que inicializa el historial vacío
    public HistorialTransacciones() {
        historial = new ArrayList<>();
    }

    /**
     * Método para agregar una nueva transacción al historial.
     * 
     * @param t La transacción que se quiere agregar al historial
     */
    public void agregarTransaccion(Transaccion t) {
        historial.add(t); // Agrega la transacción al historial
    }

    /**
     * Método para obtener todo el historial de transacciones.
     * 
     * @return List<Transaccion> Lista con todas las transacciones realizadas
     */
    public List<Transaccion> verHistorial() {
        return historial; 
    }

    /**
     * Método para mostrar el historial de transacciones en formato legible.
     * 
     * @return String Representación en cadena de todo el historial de transacciones
     */
    public String mostrarHistorial() {
        StringBuilder sb = new StringBuilder();
        for (Transaccion t : historial) {
            sb.append(t.mostrarInfo()).append("\n"); // Agrega cada transacción al StringBuilder
        }
        return sb.toString();
    }
}
