import modelos.ConeccionAUrl;
import modelos.ResponseExchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

class converter {
    public static void main(
            String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        String baseCode = "";
        String targetCode = "";
        String urlBase ="https://v6.exchangerate-api.com/v6/4f4b21a2baca7a2fa64e0fc1/pair/";

            ConeccionAUrl coneccion = new ConeccionAUrl();

            System.out.println("\nSea bienvenido(a) al Conversor de Moneda\n");
        String menu = "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "1) Dólar ==> Peso Mexicano\n" +
                "2) Peso Mexicano ==>> Euro\n" +
                "3) Peso Mexicano ==>> Peso Argentino\n" +
                "4) Peso Mexicano ==>> Peso Colombiano\n" +
                "5) Peso Mexicano ==>> Peso Chileno\n" +
                "6) Peso Mexicano ==>> Dolar\n" +
                "\n" +
                "7) Salir\n" +
                "*******************************************\n";

        while (option!=7) {

            System.out.println(menu);
            option = input.nextInt();

            if (option == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }

              switch (option) {
                case 1:
                    baseCode = "USD";
                    targetCode = "MXN";
                    break;
                case 2:
                    baseCode = "MXN";
                    targetCode = "EUR";
                    break;
                case 3:
                    baseCode = "MXN";
                    targetCode = "ARS";
                    break;
                case 4:
                    baseCode = "MXN";
                    targetCode = "COP";
                    break;
                case 5:
                    baseCode = "MXN";
                    targetCode = "CLP";
                    break;
                case 6:
                    baseCode = "MXN";
                    targetCode = "USD";
                    break;
                default:
                    System.err.println("Opcion invalida");
                    continue;
            }
            System.out.println("Ingresa el valor que deseas convertir:");
            double amount = input.nextDouble();
            System.out.println(coneccion.buscaConversion(urlBase, baseCode, targetCode, amount));
        }
    }

}


