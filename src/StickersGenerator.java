import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {

    public void create(InputStream inputStream, String fileName) throws Exception {

        // image reading
        // InputStream inputStream = new FileInputStream("image_input/TopMovies_1.jpg");
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        // create new image in ram with transparency and new size
        int imgWidth = originalImage.getWidth();
        int imgHeigth = originalImage.getHeight();
        int newHeigth = imgHeigth + 200;
        BufferedImage newImage =  new BufferedImage(imgWidth, newHeigth, BufferedImage.TRANSLUCENT);

        // copy the original image to a new image in ram
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // configure font
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        // write a sentence in the new image
        graphics.drawString("GREAT!!!", 20, newHeigth - 100);

        // write new image in file

        ImageIO.write(newImage, "png", new File(fileName));
    }
}
