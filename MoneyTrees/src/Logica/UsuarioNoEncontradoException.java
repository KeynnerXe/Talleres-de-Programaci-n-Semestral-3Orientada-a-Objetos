package Logica;

// Excepción personalizada para usuario no encontrado
public class UsuarioNoEncontradoException extends Excepcion {
    
    // Constructor que pasa el mensaje a la clase base (Excepcion)
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
