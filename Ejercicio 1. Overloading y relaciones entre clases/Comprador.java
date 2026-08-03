/**
 * Esta clase guarda la información del comprador.
 */
public class Comprador {

    // Datos del comprador
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;

    // Constructor
    public Comprador(String nombre, String email, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
        this.cantidadBoletos = 0;
    }

    // Devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    // Cambia el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el correo
    public String getEmail() {
        return email;
    }

    // Cambia el correo
    public void setEmail(String email) {
        this.email = email;
    }

    // Devuelve la cantidad de boletos solicitados
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    // Cambia la cantidad de boletos
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    // Devuelve el presupuesto disponible
    public double getPresupuesto() {
        return presupuesto;
    }

    // Cambia el presupuesto
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    // Muestra la información del comprador
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEmail: " + email +
                "\nPresupuesto: Q" + presupuesto;
    }
}