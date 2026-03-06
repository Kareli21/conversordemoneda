package modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConeccionAUrl {

    public String buscaConversion(String urlBase, String baseCode, String targetCode, double amount) {


        String url = urlBase + baseCode + "/" + targetCode + "/" + amount;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            ResponseExchange responseExchange = gson.fromJson(json, ResponseExchange.class);
            String resultado = ("\nEl valor de " + amount + " (" + baseCode +
                    ") corresponde al valor final de >>>>> " + responseExchange.getConversion_result() +
                    " (" + targetCode + ")\n\n");
            return resultado;

        } catch (
                RuntimeException e) {
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Error en la URI, verifique la dirección.");
        } catch (
                InterruptedException e) {
            System.out.println("Error en la URI, verifique la dirección.");

        }
        return url;
    }
}
