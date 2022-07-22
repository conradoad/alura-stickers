import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LanguagesListContentExtractor implements ContentExtractor{
    public List<Content> contentExtract(String json) {

        // extract only the needed data (title, poster, classification)
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> attrList = jsonParser.parse(json);

        List<Content> contents = new ArrayList<Content>();

        // populate content list

        for (Map<String, String> attr : attrList) {
            String title = attr.get("title");
            String imageUrl = attr.get("image")
                .replaceAll("(@+)(.*).jpg$", "$1.jpg");;
            Content content = new Content(title, imageUrl);

            contents.add(content);
        }

        return contents;

    }
}
