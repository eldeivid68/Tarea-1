import java.util.Objects;

public class Piloto {

    // Datos principales del piloto
    private String nombre;
    private String licencia;
    private double horasVuelo;

    // Constructor vacío por si necesito crear el objeto después
    public Piloto() {
        this.nombre = "Sin nombre";
        this.licencia = "Sin licencia";
        this.horasVuelo = 0.0;
    }

    // Constructor cuando solo conozco el nombre y la licencia
    public Piloto(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.horasVuelo = 0.0;
    }

    // Constructor con toda la información
    public Piloto(String nombre, String licencia, double horasVuelo) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.horasVuelo = horasVuelo;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    // Cambia las horas por el valor que reciba
    public void setHorasVuelo(double horas) {
        this.horasVuelo = horas;
    }

    // Si acumular es true suma horas, si no reemplaza el valor
    public void setHorasVuelo(double horas, boolean acumular) {

        if (acumular) {
            this.horasVuelo += horas;
        } else {
            this.horasVuelo = horas;
        }

    }

    // Muestra la información del piloto
    @Override
    public String toString() {
        return "Piloto: " + nombre +
                " | Licencia: " + licencia +
                " | Horas: " + horasVuelo;
    }

    // Compara si dos pilotos tienen la misma información
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Piloto otro = (Piloto) obj;

        return Double.compare(horasVuelo, otro.horasVuelo) == 0 &&
                Objects.equals(nombre, otro.nombre) &&
                Objects.equals(licencia, otro.licencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, licencia, horasVuelo);
    }
}