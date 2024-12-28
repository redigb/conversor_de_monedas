package org.renzord;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public  int mostrarMenu(){
        System.out.println("********** Conversor de Monedas **********");
        System.out.println("1) Dólar => Sol peruano");
        System.out.println("2) Sol peruano => Dólar");
        System.out.println("3) Dólar => Peso Argentino");
        System.out.println("4) Peso Argentino => Dólar");
        System.out.println("5) Dólar => Real Brasileño");
        System.out.println("6) Real Brasileño => Dólar");
        System.out.println("7) Dólar => Peso Colombiano");
        System.out.println("8) Peso Colombiano => Dólar");
        System.out.println("9) Salir");
        System.out.print("Elija una opción válida: ");
        return scanner.nextInt();
    }

    public double ingresarMonto() {
        System.out.print("Ingrese el valor que desea convertir: ");
        return scanner.nextDouble();
    }

    public String[] obtenerMonedas(int opcion) {
        return switch (opcion) {
            case 1 -> new String[]{"USD", "PEN"};
            case 2 -> new String[]{"PEN", "USD"};
            case 3 -> new String[]{"USD", "ARS"};
            case 4 -> new String[]{"ARS", "USD"};
            case 5 -> new String[]{"USD", "BRL"};
            case 6 -> new String[]{"BRL", "USD"};
            case 7 -> new String[]{"USD", "COP"};
            case 8 -> new String[]{"COP", "USD"};
            default -> null;
        };
    }
}
