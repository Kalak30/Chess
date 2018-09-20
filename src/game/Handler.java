package game;

import boards.Board;
import input.MouseManager;
import pieces.Piece;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to centralize the information needed in other classes
 * such as the pieces and board class
 */
public class Handler {
    /**
     * Instance of the game class
     */
    private Game game;

    /**
     * Handler Class constructor
     * @param game Instance of the game class
     */
    public Handler(Game game){
        this.game = game;

    }

    /**
     * Gets the game classes mouseManager object
     * @return Game's mouseManager Object
     */
    public MouseManager getMouseManager(){return game.getMouseManager();}

    /**
     * Gets the game board
     * @return Game's board object
     */
    public Board getBoard(){return game.getBoard();}

    /**
     * Gets a specific piece from the boards piece list
     * @param piece ID of the piece to get
     * @return piece
     */
    public Piece getPiece(int piece){return game.getBoard().getPieces().get(piece);}

    public Piece pieceAt(int column, int row){return game.getBoard().pieceAt(column,row);}

    public boolean isPieceAt(int column, int row){return game.getBoard().isPieceAt(column,row);}

    public void setSelectedPiece(int id){game.getBoard().setSelectePiece(id);}

    public void moveSelectedPiece(int column, int row){game.getBoard().moveSelectedPiece(column,row);}
    /**
     * Gets the game object
     * @return Game object
     */
    public Game getGame(){
        return game;
    }

    /**
     * Gets the display window's width
     * @return Display window's int width
     */
    public int getWidth(){
        return game.getWidth();
    }

    /**
     * Gets the display window's height
     * @return Display window's int height
     */
    public int getHeight(){
        return game.getHeight();
    }

    public int randomInt(int minimum, int maximum){

        int r = ThreadLocalRandom.current().nextInt(minimum,maximum+1);
        return r;
    }
}
