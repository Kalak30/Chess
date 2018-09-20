package pieces;

import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to store information about the King Piece. Extends the Piece class
 */
public class King extends Piece {
    /**
     * Constructor that sends all parameters to the super class
     * @param handler Handler to get access to information about the board and game state
     * @param color Color of the piece
     * @param column Column on the board that the piece will start on
     * @param row Row on the board that the piece will start on
     */
    public King(Handler handler, String color, int column, int row){
        super(handler, color, "King", column, row);
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_King,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_King,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Point> getMovement() {


        ArrayList<Point> possibleMovements = new ArrayList<>();

        //Upper Left
        if(handler.isPieceAt(column-1,row-1) && !handler.pieceAt(column-1,row-1).getColor().equals(color) || !handler.isPieceAt(column-1,row-1))
            possibleMovements.add(new Point(column-1,row-1));

        //Up
        if(handler.isPieceAt(column,row-1) && !handler.pieceAt(column,row-1).getColor().equals(color) || !handler.isPieceAt(column,row-1))
            possibleMovements.add(new Point(column,row-1));

        //Upper Right
        if(handler.isPieceAt(column+1,row-1) && !handler.pieceAt(column+1,row-1).getColor().equals(color) || !handler.isPieceAt(column+1,row-1))
            possibleMovements.add(new Point(column+1,row-1));

        //Right
        if(handler.isPieceAt(column+1,row) && !handler.pieceAt(column+1,row).getColor().equals(color) || !handler.isPieceAt(column+1,row))
            possibleMovements.add(new Point(column+1,row));

        //Lower Right
        if(handler.isPieceAt(column+1,row+1) && !handler.pieceAt(column+1,row+1).getColor().equals(color) || !handler.isPieceAt(column+1,row+1))
            possibleMovements.add(new Point(column+1,row+1));

        //Down
        if(handler.isPieceAt(column,row+1) && !handler.pieceAt(column,row+1).getColor().equals(color) || !handler.isPieceAt(column,row+1))
            possibleMovements.add(new Point(column,row+1));

        //Lower Left
        if(handler.isPieceAt(column-1,row+1) && !handler.pieceAt(column-1,row+1).getColor().equals(color) || !handler.isPieceAt(column-1,row+1))
            possibleMovements.add(new Point(column-1,row+1));

        //Left
        if(handler.isPieceAt(column-1,row) && !handler.pieceAt(column-1,row).getColor().equals(color) || !handler.isPieceAt(column-1,row))
            possibleMovements.add(new Point(column-1,row));



        return possibleMovements;
    }
}
