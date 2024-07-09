package convertorClase;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import service.consumoAPI;

public class ConvertidorMonedas {
    private final String URL = "https://v6.exchangerate-api.com/v6/5b7fc43c403bc9a432c19ecc/latest/";

    public String convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        consumoAPI api = new consumoAPI();
        String respuesta = api.obtenerDatos(URL + monedaOrigen);

        JsonObject jsonObject = JsonParser.parseString(respuesta).getAsJsonObject();
        if (jsonObject == null) {
            return "Error: No se pudo parsear el JSON de la respuesta.";
        }

        JsonObject tasasConversion = jsonObject.getAsJsonObject("conversion_rates");
        if (tasasConversion == null) {
            return "Error: No se encontraron tasas de conversión en la respuesta.";
        }

        if (!tasasConversion.has(monedaDestino)) {
            return "Error: No se encontró la tasa de conversión para la moneda destino: " + monedaDestino;
        }

        double tasa = tasasConversion.get(monedaDestino).getAsDouble();
        double cantidadConvertida = cantidad * tasa;

        return String.format("%.2f %s es igual a %.2f %s.", cantidad, monedaOrigen, cantidadConvertida, monedaDestino);
    }
}
