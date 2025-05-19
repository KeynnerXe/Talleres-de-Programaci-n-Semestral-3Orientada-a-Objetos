package Modelos;

import java.time.LocalDateTime;

/**
 * La clase Transaccion representa una transacción realizada por un usuario,
 * como una recarga de saldo o el envío de dinero.
 */
public class Transaccion {

    private String tipo; // El tipo de transacción (ej. "recarga", "envío")
    private double monto; // El monto de la transacción
    private LocalDateTime fecha; // Fecha y hora en la que se realizó la transacción

    /**
     * Constructor de la clase Transaccion.
     * 
     * @param tipo El tipo de transacción (ej. "recarga", "envío")
     * @param monto El monto de la transacción
     */
    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now(); // Establece la fecha y hora actual
    }

    // Getter y Setter para el tipo de transacción
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter y Setter para el monto
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Getter para la fecha de la transacción
    public LocalDateTime getFecha() {
        return fecha;
    }

    // Método para mostrar la información de la transacción en formato legible
    public String mostrarInfo() {
        return "Tipo de transacción: " + tipo + "\n" +
               "Monto: " + monto + "\n" +
               "Fecha: " + fecha.toString();
    }
}
