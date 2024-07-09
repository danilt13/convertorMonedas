package convertorClase;

import java.util.Scanner;

public class Menu {
    private final ConvertidorMonedas convertidor;

    public Menu(ConvertidorMonedas convertidor) {
        this.convertidor = convertidor;
    }

    public void mostrarMenu() {
        System.out.println("""
        ****************************************
        *      Bienvenido/a al Conversor de Moneda       *
        ****************************************
        1) Dolar => Peso argentino
        2) Peso argentino => Dolar
        3) Dolar => Real brasileño
        4) Real brasileño => Dolar
        5) Dolar => Peso colombiano
        6) Peso colombiano => Dolar
        7) Salir""" );
    }

    public void manejarOpcion(String opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case "1" -> convertir("USD", "ARS", scanner);
            case "2" -> convertir("ARS", "USD", scanner);
            case "3" -> convertir("USD", "BRL", scanner);
            case "4" -> convertir("BRL", "USD", scanner);
            case "5" -> convertir("USD", "COP", scanner);
            case "6" -> convertir("COP", "USD", scanner);
            case "7" -> {
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                System.exit(0);
            }
            default -> {
                System.out.println("Opción no válida, por favor elija de nuevo.");
                mostrarMenu();
                obtenerEntrada();
            }
        }
    }

    public void obtenerEntrada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elija una opción: ");
        String opcion = scanner.nextLine();
        manejarOpcion(opcion);
    }

    public void convertir(String monedaOrigen, String monedaDestino, Scanner scanner) {
        System.out.print("Ingrese el valor que deseas convertir: ");
        double cantidad = scanner.nextDouble();
        String resultado = convertidor.convertir(monedaOrigen, monedaDestino, cantidad);
        System.out.println(resultado);
        mostrarMenu();
        obtenerEntrada();
    }

    public void iniciar() {
        mostrarMenu();
        obtenerEntrada();
    }
}

