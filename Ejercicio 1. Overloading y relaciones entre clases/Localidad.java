/**
 * Esta clase guarda la información de cada localidad.
 * También controla los boletos vendidos y los disponibles.
 */
public class Localidad {

    // Número de la localidad (1, 5 o 10)
    private int numero;

    // Precio de cada boleto
    private double precio;

    // Cantidad máxima de boletos
    private int capacidad;

    // Boletos que ya fueron vendidos
    private int vendidos;

    // Constructor de la localidad
    public Localidad(int numero, double precio, int capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    // Revisa si hay espacio para vender la cantidad solicitada
    public boolean hayEspacio(int cantidad) {
        return disponibles() >= cantidad;
    }

    // Aumenta la cantidad de boletos vendidos
    public void venderBoletos(int cantidad) {
        vendidos += cantidad;
    }

    // Devuelve los boletos que todavía están disponibles
    public int disponibles() {
        return capacidad - vendidos;
    }

    // Devuelve el número de la localidad
    public int getNumero() {
        return numero;
    }

    // Devuelve el precio del boleto
    public double getPrecio() {
        return precio;
    }

    // Devuelve la capacidad total
    public int getCapacidad() {
        return capacidad;
    }

    // Devuelve los boletos vendidos
    public int getVendidos() {
        return vendidos;
    }

    @Override
    public String toString() {
        return "Localidad " + numero +
                "\nPrecio: Q" + precio +
                "\nVendidos: " + vendidos +
                "\nDisponibles: " + disponibles();
    }
}