import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientClass {

    public String searchData(String url) {

        try {
            URI address = new URI(url);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
            
        } catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
        
    }


}