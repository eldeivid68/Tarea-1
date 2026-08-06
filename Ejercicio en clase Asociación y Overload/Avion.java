import java.util.Objects;

public class Avion {

    // Datos principales del avión
    private String modelo;
    private int capacidad;
    private Piloto piloto;

    // Sirve para saber si el avión está configurado para carga
    private boolean vueloCarga;

    // Constructor vacío
    public Avion() {
        this.modelo = "Sin modelo";
        this.capacidad = 0;
        this.piloto = null;
        this.vueloCarga = false;
    }

    // Constructor sin piloto asignado
    public Avion(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.piloto = null;
        this.vueloCarga = false;
    }

    // Constructor con todos los datos
    public Avion(String modelo, int capacidad, Piloto piloto) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.piloto = piloto;
        this.vueloCarga = false;
    }

    // Getters

    public String getModelo() {
        return modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    // Setters

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    // Cambia la capacidad normalmente
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
        this.vueloCarga = false;
    }

    // Si es un vuelo de carga reduce la capacidad un 15%
    public void setCapacidad(int capacidad, boolean vueloCarga) {

        this.vueloCarga = vueloCarga;

        if (vueloCarga) {
            this.capacidad = (int) Math.round(capacidad * 0.85);
        } else {
            this.capacidad = capacidad;
        }

    }

    // Muestra la información del avión y del piloto asociado
    @Override
    public String toString() {

        String capacidadTexto = vueloCarga
                ? capacidad + " (carga)"
                : String.valueOf(capacidad);

        String pilotoTexto = (piloto != null)
                ? piloto.toString()
                : "Sin piloto asignado";

        return "Avion: " + modelo +
                " | Capacidad: " + capacidadTexto +
                " | Operado por -> " + pilotoTexto;
    }

    // Compara dos aviones
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Avion otro = (Avion) obj;

        return capacidad == otro.capacidad &&
                Objects.equals(modelo, otro.modelo) &&
                Objects.equals(piloto, otro.piloto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, capacidad, piloto);
    }
}