import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
public class CurrencyConverter {
    public static double getExchangeRate(String base, String target) throws IOException, InterruptedException {
        String url = "https://api.exchangerate-api.com/v4/latest/" + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                  .uri(URI.create(url))
                                  .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        double rate = json.getJSONObject("rates").getDouble(target);
        return rate;
    }

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

        System.out.println("=== Currency Converter ===");

        System.out.print("Enter base currency (e.g., USD): ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String target = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        try {
            double rate = getExchangeRate(base, target);
            double converted = amount * rate;
            System.out.printf("Exchange rate: 1 %s = %.2f %s\n", base, rate, target);
            System.out.printf("Converted amount: %.2f %s\n", converted, target);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching exchange rate.");
        }

        scanner.close();

	}

}
