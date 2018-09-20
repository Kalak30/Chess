package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Only job of this class is to have and easy way to load images from a certain path.
 */
public class ImageLoader {

    /**
     * Loads the image through the ImageIO stream. If the image is not found the the given
     * path, the game will exit.
     * @param path String path of the location of the image file that is to be loaded
     * @return Returns the buffered image if it exist at the path given
     */
    public static BufferedImage loadImage(String path){
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
