package gfx;

import java.awt.image.BufferedImage;

/**
 * Class that stores all of the assets of the Game to be displayed like
 * images and sounds.
 */
public class Assets {
    /**
     * Default width and height of each section of the Sprite sheet
     */
    public static int SPRITESHEET_WIDTH = 512, SPRITESHEET_HEIGHT = 512;

    /**
     * Static variables to store images so they can be accessed from anywhere
     */
    public static BufferedImage board, white_Pawn, white_Rook, white_Knight, white_Bishop, white_Queen, white_King, black_Pawn, black_Rook, black_Knight, black_Bishop, black_Queen, black_King, selected_Tile;

    /**
     * Static method to initialize the images for the board and the pieces of the game.
     * <p>
     * Also adds in sound for movement and taking a piece ----- NOT YET IMPLEMENTED
     *
     */
    public static void init(){
        //Importing the sprite sheets, board, and selected tile images
        SpriteSheet whiteSheet = new SpriteSheet(ImageLoader.loadImage("/textures/WhiteSpriteSheet.png"));
        SpriteSheet blackSheet = new SpriteSheet(ImageLoader.loadImage("/textures/BlackSpriteSheet.png"));
        board = ImageLoader.loadImage("/textures/board.png");
        selected_Tile = ImageLoader.loadImage("/textures/SelectedTile.png");

        //initializing the white pieces
        white_Pawn = whiteSheet.crop(0,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        white_Rook = whiteSheet.crop(SPRITESHEET_WIDTH,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        white_Knight = whiteSheet.crop(SPRITESHEET_WIDTH *2,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        white_Bishop = whiteSheet.crop(SPRITESHEET_WIDTH *2, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        white_Queen = whiteSheet.crop(SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        white_King = whiteSheet.crop(0, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);

        //initializing the black pieces
        black_Pawn = blackSheet.crop(0,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        black_Rook = blackSheet.crop(SPRITESHEET_WIDTH,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        black_Knight = blackSheet.crop(SPRITESHEET_WIDTH *2,0, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        black_Bishop = blackSheet.crop(SPRITESHEET_WIDTH *2, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        black_Queen = blackSheet.crop(SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);
        black_King = blackSheet.crop(0, SPRITESHEET_HEIGHT, SPRITESHEET_WIDTH, SPRITESHEET_HEIGHT);



    }

}
