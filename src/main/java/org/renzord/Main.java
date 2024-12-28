package org.renzord;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        ServicioDeConversion servicioDeConversion = new ServicioDeConversion();

        while (true){

            int opcion = menu.mostrarMenu();

            if (opcion == 9){
                System.out.println("Saliendo del programa... ");
                break;
            }

            double monto = menu.ingresarMonto();
            String[] monedas = menu.obtenerMonedas(opcion);
            if (monedas == null){
                System.out.println("Opcion inavalida. Intenete de nuevo");
                continue;
            }

            double resultado = servicioDeConversion.convertirMoneda(monedas[0], monedas[1], monto);
            System.out.printf("El valor convertido es: %.2f %s%n", resultado, monedas[1]);
        }
    }
}