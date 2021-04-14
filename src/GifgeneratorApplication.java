

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GifgeneratorApplication {
    public static void main(String[] args) throws IOException {

        BufferedImage first = ImageIO.read(new File("/home/carlos/1.jpeg"));
        ImageOutputStream output = new FileImageOutputStream(new File("/home/carlos/3.gif"));


        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
        writer.writeToSequence(first);


        File[] images = new File[]{
                new File("/home/carlos/1.png"),
                new File("/home/carlos/2.png"),

        };

        for (File image : images) {
            BufferedImage next = ImageIO.read(image);
            writer.writeToSequence(next);
        }

        writer.close();
        output.close();
    }

}
