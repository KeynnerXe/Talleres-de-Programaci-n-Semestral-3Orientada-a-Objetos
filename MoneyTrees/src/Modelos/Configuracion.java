package Modelos;

/**
 * La clase Configuracion maneja las configuraciones del sistema.
 * Esta clase se utiliza para administrar parámetros de configuración,
 * como los límites de las transacciones y el tiempo de expiración de las sesiones.
 */
public class Configuracion {

    private double limiteTransaccion;  // Límite máximo de las transacciones en el sistema
    private int tiempoExpiracionSesion;  // Tiempo de expiración de la sesión del usuario en minutos

    /**
     * Constructor para inicializar la configuración del sistema.
     * 
     * @param limiteTransaccion límite máximo para las transacciones
     * @param tiempoExpiracionSesion tiempo en minutos que dura la sesión antes de expirar
     */
    public Configuracion(double limiteTransaccion, int tiempoExpiracionSesion) {
        this.limiteTransaccion = limiteTransaccion;
        this.tiempoExpiracionSesion = tiempoExpiracionSesion;
    }

    // Getter y Setter para limiteTransaccion
    public double getLimiteTransaccion() {
        return limiteTransaccion;
    }

    public void setLimiteTransaccion(double limiteTransaccion) {
        this.limiteTransaccion = limiteTransaccion;
    }

    // Getter y Setter para tiempoExpiracionSesion
    public int getTiempoExpiracionSesion() {
        return tiempoExpiracionSesion;
    }

    public void setTiempoExpiracionSesion(int tiempoExpiracionSesion) {
        this.tiempoExpiracionSesion = tiempoExpiracionSesion;
    }

    /**
     * Método para cambiar la configuración del sistema.
     * Este método podría ser usado por el administrador o un usuario autorizado
     * para modificar los parámetros de configuración del sistema.
     * 
     * @param limiteTransaccion nuevo límite para las transacciones
     * @param tiempoExpiracionSesion nuevo tiempo de expiración de las sesiones
     */
    public void cambiarConfiguracion(double limiteTransaccion, int tiempoExpiracionSesion) {
        this.limiteTransaccion = limiteTransaccion;
        this.tiempoExpiracionSesion = tiempoExpiracionSesion;
    }
}
