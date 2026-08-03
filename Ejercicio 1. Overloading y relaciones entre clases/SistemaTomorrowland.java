import java.util.Scanner;

/**
 * Esta clase controla todo el funcionamiento del sistema.
 */
public class SistemaTomorrowland {

    // Comprador actual
    private Comprador comprador;

    // Las tres localidades disponibles
    private Localidad[] localidades;

    // Dinero recaudado
    private double caja;

    // Constructor
    public SistemaTomorrowland() {

        localidades = new Localidad[3];

        // Localidad, precio y capacidad
        localidades[0] = new Localidad(1, 100, 20);
        localidades[1] = new Localidad(5, 500, 20);
        localidades[2] = new Localidad(10, 1000, 20);

        comprador = null;
        caja = 0;
    }

    // Registra un nuevo comprador
    public void nuevoComprador(Scanner sc) {

        System.out.println("\n--- Nuevo comprador ---");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Presupuesto máximo: ");
        double presupuesto = Double.parseDouble(sc.nextLine());

        comprador = new Comprador(nombre, email, presupuesto);

        System.out.println("Comprador registrado correctamente.");
    }

    // Procesa una nueva solicitud de compra
    public void nuevaSolicitud(Scanner sc) {

        if (comprador == null) {
            System.out.println("Primero debes registrar un comprador.");
            return;
        }

        System.out.println("\n--- Solicitud de boletos ---");

        System.out.print("Cantidad de boletos: ");
        int cantidad = Integer.parseInt(sc.nextLine());

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        comprador.setCantidadBoletos(cantidad);

        // Se asigna una localidad al azar
        Localidad localidad = asignarLocalidadAleatoria();

        System.out.println("Localidad asignada: " + localidad.getNumero());
        System.out.println("Precio por boleto: Q" + localidad.getPrecio());

        // Si no hay suficientes boletos vende los que queden
        if (!localidad.hayEspacio(cantidad)) {

            cantidad = localidad.disponibles();

            if (cantidad == 0) {
                System.out.println("Esta localidad ya no tiene boletos disponibles.");
                return;
            }

            System.out.println("Solo hay disponibles " + cantidad + " boletos.");
        }

        double costo = cantidad * localidad.getPrecio();

        if (costo > comprador.getPresupuesto()) {
            System.out.println("El presupuesto no alcanza.");
            return;
        }

        int boletosVendidos = 0;

        for (int i = 1; i <= cantidad; i++) {

            Ticket ticket = new Ticket();

            ticket.generarNumero();

            if (ticket.esApto()) {

                boletosVendidos++;

                System.out.println("Ticket "
                        + ticket.getNumero()
                        + " APTO");
            } else {

                System.out.println("Ticket "
                        + ticket.getNumero()
                        + " NO APTO");
            }
        }

        if (boletosVendidos == 0) {
            System.out.println("Ningún ticket fue apto.");
            return;
        }

        localidad.venderBoletos(boletosVendidos);

        double total = boletosVendidos * localidad.getPrecio();

        caja += total;

        comprador.setPresupuesto(
                comprador.getPresupuesto() - total);

        System.out.println("\nCompra realizada.");
        System.out.println("Boletos vendidos: " + boletosVendidos);
        System.out.println("Total pagado: Q" + total);
        System.out.println("Presupuesto restante: Q"
                + comprador.getPresupuesto());
    }

        // Muestra la disponibilidad de todas las localidades
    public void consultarDisponibilidadTotal() {

        System.out.println("\n--- Disponibilidad total ---");

        for (Localidad localidad : localidades) {

            System.out.println("Localidad " + localidad.getNumero());

            System.out.println("Vendidos: " + localidad.getVendidos());

            System.out.println("Disponibles: " + localidad.disponibles());

            System.out.println("---------------------------");
        }
    }

    // Muestra la disponibilidad de una sola localidad
    public void consultarDisponibilidadLocalidad(Scanner sc) {

        System.out.print("Ingrese la localidad (1, 5 o 10): ");

        int numero = Integer.parseInt(sc.nextLine());

        Localidad localidad = buscarLocalidad(numero);

        if (localidad == null) {

            System.out.println("La localidad no existe.");
            return;
        }

        System.out.println("\nLocalidad " + localidad.getNumero());

        System.out.println("Precio: Q" + localidad.getPrecio());

        System.out.println("Vendidos: " + localidad.getVendidos());

        System.out.println("Disponibles: " + localidad.disponibles());
    }

    // Muestra el dinero recaudado
    public void reporteCaja() {

        System.out.println("\n===== REPORTE DE CAJA =====");

        for (Localidad localidad : localidades) {

            double total = localidad.getVendidos() * localidad.getPrecio();

            System.out.println("Localidad " + localidad.getNumero());

            System.out.println("Boletos vendidos: "
                    + localidad.getVendidos());

            System.out.println("Total recaudado: Q" + total);

            System.out.println("---------------------------");
        }

        System.out.println("Dinero total en caja: Q" + caja);
    }

    // Escoge una localidad al azar
    private Localidad asignarLocalidadAleatoria() {

        int posicion = (int) (Math.random() * localidades.length);

        return localidades[posicion];
    }

    // Busca una localidad por su número
    private Localidad buscarLocalidad(int numero) {

        for (Localidad localidad : localidades) {

            if (localidad.getNumero() == numero) {

                return localidad;
            }
        }

        return null;
    }

}