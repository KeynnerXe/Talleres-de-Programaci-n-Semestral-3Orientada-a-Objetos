package Logica;

// Excepción personalizada para saldo insuficiente
public class SaldoInsuficienteException extends Excepcion {
    
    // Constructor que pasa el mensaje a la clase base (Excepcion)
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
