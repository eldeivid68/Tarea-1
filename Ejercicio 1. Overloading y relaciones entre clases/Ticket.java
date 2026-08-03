/**
 * Esta clase se encarga de crear el ticket y verificar
 * si puede participar en la compra de boletos.
 */
public class Ticket {

    // Número del ticket
    private int numero;

    // Constructor
    public Ticket() {
        numero = 0;
    }

    // Genera un número de ticket entre 1 y 15000
    public int generarNumero() {
        numero = (int) (Math.random() * 15000) + 1;
        return numero;
    }

    // Verifica si el ticket quedó dentro del rango generado
    public boolean esApto() {

        int a = (int) (Math.random() * 15000) + 1;
        int b = (int) (Math.random() * 15000) + 1;

        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        System.out.println("Rango generado: " + menor + " - " + mayor);

        return numero >= menor && numero <= mayor;
    }

    // Devuelve el número del ticket
    public int getNumero() {
        return numero;
    }

    // Muestra la información del ticket
    @Override
    public String toString() {
        return "Ticket #" + numero;
    }
}