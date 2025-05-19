package Modelos;

import java.util.List;

/**
 * La clase Administrador representa al administrador del sistema.
 * El administrador tiene la capacidad de gestionar usuarios y visualizar los reportes de las transacciones.
 */
public class Administrador {

    private String nombreAdmin;  // Nombre del administrador
    
    /**
     * Constructor para crear un administrador.
     * 
     * @param nombreAdmin el nombre del administrador
     */
    public Administrador(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    // Getter y Setter para nombreAdmin
    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    /**
     * Método para ver los reportes de todas las transacciones realizadas en el sistema.
     * Este método podría devolver una lista con todas las transacciones, ya sea filtradas por tipo,
     * usuario o fecha, dependiendo de las necesidades.
     * 
     * @return una lista de transacciones que contienen el historial de todas las transacciones realizadas
     */
    public List<Transaccion> verReporteDeTransacciones() {
        // Aquí se implementaría la lógica para acceder al historial de transacciones y devolverlo
        // En una implementación real, el administrador vería un historial filtrado por tipo de transacción, usuario, etc.
        return null;  // En esta implementación se devuelve null, ya que depende de cómo se gestione el historial
    }

    /**
     * Método para gestionar los usuarios del sistema.
     * El administrador puede gestionar a los usuarios (crear, eliminar, modificar, etc.).
     * 
     * @return una lista de usuarios registrados en el sistema
     */
    public List<Usuario> gestionarUsuarios() {
        // Aquí se podría retornar una lista de usuarios para que el administrador gestione sus cuentas.
        return null;  // En una implementación real, se devolvería una lista de usuarios gestionados
    }
}
