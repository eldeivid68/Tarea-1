import java.util.Scanner;

// Programa principal
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SistemaTomorrowland sistema = new SistemaTomorrowland();

        int opcion = 0;

        do {

            System.out.println("\n===== TOMORROWLAND =====");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad de una localidad");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        sistema.nuevoComprador(sc);
                        break;

                    case 2:
                        sistema.nuevaSolicitud(sc);
                        break;

                    case 3:
                        sistema.consultarDisponibilidadTotal();
                        break;

                    case 4:
                        sistema.consultarDisponibilidadLocalidad(sc);
                        break;

                    case 5:
                        sistema.reporteCaja();
                        break;

                    case 6:
                        System.out.println("Gracias por usar el sistema.");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número.");
            }

        } while (opcion != 6);

        sc.close();
    }
}