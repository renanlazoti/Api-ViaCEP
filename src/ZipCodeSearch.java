import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ZipCodeSearch {

    public Address zipSearch(String postalCode) {
        URI address = URI.create("https://viacep.com.br/ws/" + postalCode + "/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Address.class);

        } catch (Exception e) {
            throw new RuntimeException("Your address could not be found: " + e.getMessage());
        }


    }
}
