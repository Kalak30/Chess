package gfx;

import java.awt.image.BufferedImage;

/**
 * Sole purpose of this class is the store an image of a sprite sheet and give an easy way
 * of cropping out certain sprites.
 */
public class SpriteSheet {
    /**
     * Buffered image that is the sprite sheet.
     */
    BufferedImage spriteSheet;

    /**
     * Constructor that takes an image that consists of the spriteSheet and initializes
     * the spriteSheet variable to the image
     * @param spriteSheet Buffered image that contains the sprite sheet
     */
    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    /**
     * Returns an image of the specified region of the sprite sheet
     * @param x X location to start the crop
     * @param y Y location to start the crop
     * @param width How far in the X direction to go for the crop
     * @param height how for in the Y direction to for for the crop
     * @return Returns the sub image of the sprite sheet in the region enclosed by the inputted
     *         parameters.
     */
    public BufferedImage crop(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x,y,width,height);
    }

}
