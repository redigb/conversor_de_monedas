package org.renzord;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioDeConversion {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/cee887c78cd7aabcca8bfc50/latest/";
    private final HttpClient client;

    public ServicioDeConversion() {
        this.client = HttpClient.newHttpClient();
    }

    public double convertirMoneda(String base, String destino, double monto) {
        try {
            // Construir la URL con la moneda base
            String url = API_URL + base;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Obtener la tasa de cambio para la moneda de destino
            double tasaCambio = obtenerTasaCambio(json, destino);
            return monto * tasaCambio;

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
            return 0.0;
        }
    }

    private double obtenerTasaCambio(String json, String monedaDestino) {
        try {
            // Buscar la tasa de cambio dentro del JSON
            String key = "\"" + monedaDestino + "\":";
            int startIndex = json.indexOf(key) + key.length();
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) endIndex = json.indexOf("}", startIndex);

            String rate = json.substring(startIndex, endIndex).trim();
            return Double.parseDouble(rate);

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0.0;
        }
    }
}
