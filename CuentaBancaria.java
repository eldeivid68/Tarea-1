public class CuentaBancaria {

    // Variables de la cuenta
    private String titular;
    private String numeroCuenta;
    private double saldo;

    // Constructor para guardar los datos de la cuenta
    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Sirve para agregar dinero a la cuenta
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    // Intenta retirar dinero y devuelve si se pudo o no
    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    // Muestra el saldo que tiene la cuenta
    public double consultarSaldo() {
        return saldo;
    }
}