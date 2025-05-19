package Modelos;

/**
 * La clase Cuenta representa una cuenta bancaria asociada a un usuario.
 * Contiene los métodos para consultar el saldo y realizar transacciones.
 */
public class Cuenta {
    
    private String numeroCuenta;   // Número único de cuenta
    private double saldo;          // Saldo disponible en la cuenta
    private String tipoCuenta;     // Tipo de cuenta (por ejemplo, corriente, ahorros)
    
    /**
     * Constructor para crear una nueva cuenta.
     * 
     * @param numeroCuenta el número único de cuenta
     * @param saldo el saldo inicial de la cuenta
     * @param tipoCuenta el tipo de cuenta (por ejemplo, corriente, ahorros)
     */
    public Cuenta(String numeroCuenta, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }
    
    // Getter y Setter para numeroCuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // Getter y Setter para saldo
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter y Setter para tipoCuenta
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * Método para consultar el saldo actual de la cuenta.
     * 
     * @return el saldo disponible en la cuenta
     */
    public double consultarSaldo() {
        return saldo;
    }

    /**
     * Método para realizar una transacción en la cuenta.
     * Este método puede ser utilizado tanto para realizar un depósito como un retiro.
     * 
     * @param monto el monto de la transacción
     * @param tipo el tipo de transacción (por ejemplo, "recarga" o "enviar")
     * @return true si la transacción fue exitosa, false si hubo un error
     */
    public boolean realizarTransaccion(double monto, String tipo) {
        if (tipo.equals("recargar")) {
            saldo += monto;  // Si es recarga, suma el monto al saldo
            return true;
        } else if (tipo.equals("enviar")) {
            if (saldo >= monto) {  // Si el saldo es suficiente para realizar el envío
                saldo -= monto;    // Si es suficiente, resta el monto del saldo
                return true;
            } else {
                // Si no hay suficiente saldo, la transacción no se realiza
                return false;
            }
        }
        // Si el tipo de transacción no es reconocido, retorna false
        return false;
    }
}
