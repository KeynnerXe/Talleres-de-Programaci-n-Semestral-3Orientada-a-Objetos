package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Usuario representa a un usuario de la billetera virtual.
 * Contiene información personal y gestiona su historial de transacciones.
 */
public class Usuario {

    private String nombre;
    private String numeroCuenta;
    private String contraseña;
    private double saldo;
    private List<Transaccion> historial; // ✅ Solo Lista de transacciones

    /**
     * Constructor que crea un nuevo usuario con historial vacío.
     */
    public Usuario(String nombre, String numeroCuenta, String contraseña) {
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.contraseña = contraseña;
        this.saldo = 0.0;
        this.historial = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    /**
     * Devuelve la lista de transacciones realizadas por el usuario.
     * @return historial de transacciones
     */
    public List<Transaccion> getHistorial() {
        return historial;
    }

    /**
     * Agrega una nueva transacción al historial del usuario.
     * @param transaccion transacción a registrar
     */
    public void agregarTransaccion(Transaccion transaccion) {
        historial.add(transaccion);
    }
    
    /**
 * Método para consultar el saldo del usuario.
 * @return el saldo actual
 */
public double consultarSaldo() {
    return saldo;
}

}
