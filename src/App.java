import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // do an HTTP connection to get the top 250 movies from IMDb
        
        // String url = "https://api.mocki.io/v2/549a5d8b";
        // ContentExtractor extractor = new ImdbContentExtractor();

        String url = "https://api.nasa.gov/planetary/apod?api_key=ZJbySQVVBSr9jpWpQ92lgIIi5DB8rooP7bA1iTGj&start_date=2022-07-11&end_date=2022-07-13";
        ContentExtractor extractor = new NasaContentExtractor();
        
        HttpClientClass httpClient = new HttpClientClass();
        String json = httpClient.searchData(url);

        
        // show the obtained data
        List<Content> contents = extractor.contentExtract(json);
        StickersGenerator generator = new StickersGenerator();

        for (int i=0; i<contents.size(); i++) {
            Content content = contents.get(i);
        
            InputStream inputStream = new URL(content.getImageUrl()).openStream();

            String fileName = "image_output/" + content.getTitle() + ".png";

            generator.create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }

    }
}
