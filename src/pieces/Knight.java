package pieces;

import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to store information about the knight piece. Extends Piece class
 */
public class Knight extends Piece {
    /**
     * Constructor that sends all of its parameters to the super class
     * @param handler Handler to access information about the board and game state
     * @param color Color of the piece
     * @param column Column on the board that the piece will start on
     * @param row Row on the board that the piece will start on
     */
    public Knight(Handler handler, String color, int column, int row){
        super(handler, color, "Knight", column, row);
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Knight,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Knight,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Point> getMovement() {
        ArrayList<Point> possibleMovements = new ArrayList<>();
        //Upper Left
        if(!handler.isPieceAt(column-1,row-2) ||handler.isPieceAt(column-1, row-2) && !handler.pieceAt(column-1,row-2).getColor().equals(color))
            possibleMovements.add(new Point(column-1,row-2));

        //Upper Right
        if(!handler.isPieceAt(column+1,row-2) ||handler.isPieceAt(column+1,row-2) && !handler.pieceAt(column+1,row-2).getColor().equals(color))
            possibleMovements.add(new Point(column+1,row-2));

        //Right Up
        if(!handler.isPieceAt(column+2,row-1) ||handler.isPieceAt(column+2,row-1) && !handler.pieceAt(column+2,row-1).getColor().equals(color))
            possibleMovements.add(new Point(column+2,row-1));

        //Right Down
        if(!handler.isPieceAt(column+2,row+1) ||handler.isPieceAt(column+2,row+1) && !handler.pieceAt(column+2,row+1).getColor().equals(color))
            possibleMovements.add(new Point(column+2,row+1));

        //Lower Right
        if(!handler.isPieceAt(column+1,row+2) ||handler.isPieceAt(column+1, row+2) && !handler.pieceAt(column+1,row+2).getColor().equals(color))
            possibleMovements.add(new Point(column+1,row+2));

        //Lower Left
        if(!handler.isPieceAt(column-1,row+2) ||handler.isPieceAt(column-1, row+2) && !handler.pieceAt(column-1,row+2).getColor().equals(color))
            possibleMovements.add(new Point(column-1,row+2));

        //Left down
        if(!handler.isPieceAt(column-2,row+1) ||handler.isPieceAt(column-2, row-1) && !handler.pieceAt(column-2,row-1).getColor().equals(color))
            possibleMovements.add(new Point(column-2,row+1));

        //Left Up
        if(!handler.isPieceAt(column-2,row-1) ||handler.isPieceAt(column-2, row-1) && !handler.pieceAt(column-2,row-1).getColor().equals(color))
            possibleMovements.add(new Point(column-2,row-1));



        return possibleMovements;
    }
}
