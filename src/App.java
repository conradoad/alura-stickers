import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // do an HTTP connection to get the top 250 movies from IMDb
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI address = new URI(url);
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extract only the needed data (title, poster, classification)
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> moviesList = jsonParser.parse(body);

        // show the obtained data
        StickersGenerator generator = new StickersGenerator();

        for (Map<String,String> movie : moviesList) {
            String urlImagem = movie.get("image");
            String title = movie.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();

            String fileName = "image_output/" + title + ".png";

            generator.create(inputStream, fileName);

            System.out.println(title);
            System.out.println();
        }



    }
}
