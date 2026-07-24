public class Main {

    public static void main(String[] args) {

        // Creo dos cuentas con datos diferentes
        CuentaBancaria cuenta1 = new CuentaBancaria("Carlos", "001", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Sebas", "002", 500);

        // Hago unos depósitos
        cuenta1.depositar(300);
        cuenta2.depositar(200);

        // Pruebo si los retiros funcionan
        if (cuenta1.retirar(400)) {
            System.out.println("Retiro exitoso en cuenta1.");
        } else {
            System.out.println("No se pudo retirar de cuenta1.");
        }

        if (cuenta2.retirar(1000)) {
            System.out.println("Retiro exitoso en cuenta2.");
        } else {
            System.out.println("No se pudo retirar de cuenta2.");
        }

        // Hago varios depósitos usando un ciclo
        for (int i = 0; i < 3; i++) {
            cuenta1.depositar(100);
        }

        // Muestro cuánto dinero quedó en cada cuenta
        System.out.println("Saldo cuenta1: Q" + cuenta1.consultarSaldo());
        System.out.println("Saldo cuenta2: Q" + cuenta2.consultarSaldo());
    }
}