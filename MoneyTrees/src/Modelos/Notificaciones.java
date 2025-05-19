package Modelos;

/**
 * La clase Notificaciones maneja el envío de notificaciones a los usuarios.
 * El sistema puede enviar mensajes de alerta o información sobre eventos importantes.
 */
public class Notificaciones {

    private String mensaje;  // Mensaje que será enviado al usuario
    private String tipoNotificacion;  // Tipo de la notificación (ej. "información", "alerta", "error")

    /**
     * Constructor de la clase Notificaciones.
     * 
     * @param mensaje el contenido del mensaje de la notificación
     * @param tipoNotificacion el tipo de la notificación
     */
    public Notificaciones(String mensaje, String tipoNotificacion) {
        this.mensaje = mensaje;
        this.tipoNotificacion = tipoNotificacion;
    }

    // Getter y Setter para el mensaje
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    // Getter y Setter para el tipo de notificación
    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    /**
     * Método para enviar la notificación al usuario.
     * Este método simula el envío de una notificación, ya que en un sistema real podría integrar
     * algún servicio de mensajería o correo electrónico.
     * 
     * @param usuario el usuario al que se enviará la notificación
     */
    public void enviarNotificacion(Usuario usuario) {
        // Simulación de envío de notificación
        System.out.println("Enviando notificación a " + usuario.getNombre() + ":");
        System.out.println("Tipo: " + tipoNotificacion);
        System.out.println("Mensaje: " + mensaje);
    }
}
