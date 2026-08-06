public class Main {

    public static void main(String[] args) {

        // Creo dos pilotos usando diferentes constructores
        Piloto piloto1 = new Piloto("Ana Gomez", "ATP-2291", 5400.0);
        Piloto piloto2 = new Piloto("Luis Rivas", "PPL-1187");

        // A este le agrego las horas después
        piloto2.setHorasVuelo(320.0);

        System.out.println(piloto1);
        System.out.println(piloto2);

        // Creo los aviones y les asigno un piloto
        Avion avion1 = new Avion("Boeing 737", 160, piloto1);
        Avion avion2 = new Avion("Cessna 172", 3, piloto2);

        // Pruebo el método sobrecargado para sumar horas
        piloto1.setHorasVuelo(300.0, true);

        // Pruebo el método sobrecargado del avión
        avion2.setCapacidad(3, true);

        System.out.println();

        // Si imprime bien es porque toString() está funcionando
        System.out.println(avion1);
        System.out.println(avion2);

        System.out.println();

        // Creo dos aviones iguales para probar equals()
        Avion avionA = new Avion(
                "ATR 72",
                70,
                new Piloto("Carlos Diaz", "CPL-4432", 1200.0)
        );

        Avion avionB = new Avion(
                "ATR 72",
                70,
                new Piloto("Carlos Diaz", "CPL-4432", 1200.0)
        );

        System.out.println(avionA);
        System.out.println(avionB);

        System.out.println("¿avionA.equals(avionB)? -> " + avionA.equals(avionB));
    }
}