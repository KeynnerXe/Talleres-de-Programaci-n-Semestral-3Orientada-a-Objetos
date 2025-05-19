package Logica;

import java.util.List;
import java.util.ArrayList;
import Modelos.Usuario;
import Modelos.Cuenta;
import Modelos.Transaccion;
import Modelos.Administrador;
import Modelos.Notificaciones;
import Modelos.TarjetaBancaria;
import Modelos.Configuracion;
import Logica.UsuarioNoEncontradoException;


/**
 * Clase que maneja toda la lógica del negocio principal de la billetera virtual.
 * Se encarga de registrar usuarios, gestionar transacciones, recargar saldo, 
 * realizar envíos de dinero, y gestionar el administrador.
 * 
 * @author Dimerson
 */
public class LogicaBilletera {

    private List<Usuario> usuarios; // Lista de usuarios registrados
    private Administrador administrador; // Administrador del sistema
    private Configuracion configuracion; // Configuración de la billetera

    // Constructor que inicializa la lista de usuarios y la configuración
    public LogicaBilletera() {
    usuarios = new ArrayList<>();
    configuracion = new Configuracion(1000.0, 30);  // Aquí pasamos los valores necesarios
    administrador = new Administrador("Admin"); // Inicializa un administrador predeterminado
}


    /**
     * Método para registrar un nuevo usuario en el sistema.
     * 
     * @param nombre Nombre del usuario
     * @param numeroCuenta Número de cuenta del usuario
     * @param contraseña Contraseña del usuario
     * @return boolean Retorna true si el registro fue exitoso
     */
    public boolean registrarUsuario(String nombre, String numeroCuenta, String contraseña) {
        // Se crea un nuevo usuario y se agrega a la lista de usuarios
        Usuario nuevoUsuario = new Usuario(nombre, numeroCuenta, contraseña);
        usuarios.add(nuevoUsuario);
        return true; // Registro exitoso
    }

    /**
     * Método para realizar el login de un usuario.
     * 
     * @param numeroCuenta Número de cuenta del usuario que quiere iniciar sesión
     * @param contraseña Contraseña proporcionada por el usuario
     * @return Usuario El usuario que ha iniciado sesión si es válido
     * @throws UsuarioNoEncontradoException Si no se encuentra un usuario con las credenciales proporcionadas
     */
    public Usuario login(String numeroCuenta, String contraseña) throws UsuarioNoEncontradoException {
        // Busca al usuario por el número de cuenta y la contraseña
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroCuenta().equals(numeroCuenta) && usuario.getContraseña().equals(contraseña)) {
                return usuario; // Usuario encontrado
            }
        }
        // Si no se encuentra el usuario, se lanza una excepción
        throw new UsuarioNoEncontradoException("Usuario no encontrado con esas credenciales");
    }

    /**
     * Método para recargar saldo a la cuenta de un usuario.
     * 
     * @param usuario Usuario al que se le recargará el saldo
     * @param monto Monto a recargar en la cuenta
     */
    public void recargarSaldo(Usuario usuario, double monto) {
        // Se crea una nueva transacción de tipo "recargar" y se agrega a la cuenta del usuario
        Transaccion transaccion = new Transaccion("recargar", monto);
        usuario.agregarTransaccion(transaccion);
    }

    /**
     * Método para enviar dinero de una cuenta a otra.
     * 
     * @param origen Usuario que envía el dinero
     * @param destinoNumeroCuenta Número de cuenta del usuario receptor
     * @param monto Monto a enviar
     * @return boolean Retorna true si la transacción fue exitosa
     */
    public boolean enviarDinero(Usuario origen, String destinoNumeroCuenta, double monto) {
        // Busca el usuario receptor
        Usuario receptor = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroCuenta().equals(destinoNumeroCuenta)) {
                receptor = usuario;
                break;
            }
        }
        // Si no se encuentra el usuario receptor, se retorna false
        if (receptor == null) {
            return false;
        }

        // Verifica si el usuario tiene suficiente saldo
        if (origen.consultarSaldo() >= monto) {
            // Realiza la transacción
            origen.agregarTransaccion(new Transaccion("enviar", monto));
            receptor.agregarTransaccion(new Transaccion("recibir", monto));
            return true; // Transacción exitosa
        }
        return false; // Saldo insuficiente
    }

    /**
     * Método para gestionar las configuraciones del sistema, como el límite de transacciones.
     * 
     * @return Configuracion La configuración actual del sistema
     */
    public Configuracion gestionConfiguracion() {
        return configuracion;
    }

    /**
     * Método para gestionar al administrador del sistema.
     * 
     * @return Administrador El administrador del sistema
     */
    public Administrador gestionAdmin() {
        return administrador;
    }
    
    
    // Método para verificar si un número de cuenta ya existe
public boolean existeNumeroCuenta(String numeroCuenta) {
    for (Usuario usuario : usuarios) {
        if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
            return true;
        }
    }
    return false;

}

/**
 * Método que busca un usuario por su número de cuenta.
 * @param numeroCuenta número de cuenta a buscar
 * @return Usuario encontrado o null si no existe
 */
public Usuario buscarUsuarioPorCuenta(String numeroCuenta) {
    for (Usuario usuario : usuarios) {
        if (usuario.getNumeroCuenta().equals(numeroCuenta)) {
            return usuario;
        }
    }
    return null;
}


}

