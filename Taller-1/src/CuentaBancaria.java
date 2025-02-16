/**
 *
 * @author Keinner Ramos
 */

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private String tipoCuenta;

    public CuentaBancaria() {
        this.numeroCuenta = "Desconocido";
        this.saldo = 0.0;
        this.tipoCuenta = "Sin tipo";
    }

    public CuentaBancaria(String numeroCuenta, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0.0;
    }
    
    public CuentaBancaria(String numeroCuenta, double saldo, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Cuenta Bancaria: [Número de Cuenta: " + numeroCuenta + ", Saldo: " + saldo + ", Tipo: " + tipoCuenta + "]";
    }
}
