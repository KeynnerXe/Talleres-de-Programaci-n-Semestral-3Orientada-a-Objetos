package Modelos;

/**
 * La clase TarjetaBancaria representa una tarjeta bancaria asociada a un usuario.
 * Permite asociar y desasociar tarjetas, así como gestionar su información.
 */
public class TarjetaBancaria {
    
    private String numeroTarjeta;  // Número único de la tarjeta
    private String fechaExpiracion;  // Fecha de expiración de la tarjeta
    private String cvv;  // Código de verificación de la tarjeta
    
    /**
     * Constructor para crear una nueva tarjeta bancaria.
     * 
     * @param numeroTarjeta el número único de la tarjeta
     * @param fechaExpiracion la fecha de expiración de la tarjeta
     * @param cvv el código de seguridad de la tarjeta (CVV)
     */
    public TarjetaBancaria(String numeroTarjeta, String fechaExpiracion, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }

    // Getter y Setter para numeroTarjeta
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    // Getter y Setter para fechaExpiracion
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    // Getter y Setter para cvv
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Método para asociar una tarjeta bancaria a un usuario.
     * Este método puede ser utilizado por el usuario para asociar una tarjeta a su cuenta.
     */
    public void asociarTarjeta() {
        // Lógica para asociar la tarjeta a un usuario (esto podría implicar almacenar la tarjeta en una lista asociada al usuario)
        System.out.println("Tarjeta asociada exitosamente.");
    }

    /**
     * Método para desasociar una tarjeta bancaria de un usuario.
     * Este método puede ser utilizado por el usuario para eliminar la tarjeta asociada.
     */
    public void desasociarTarjeta() {
        // Lógica para desasociar la tarjeta (esto podría implicar eliminar la tarjeta de la lista asociada al usuario)
        System.out.println("Tarjeta desasociada exitosamente.");
    }
}
