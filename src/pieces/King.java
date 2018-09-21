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
        value = 10000;
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_King,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_King,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Move> getMovement() {


        ArrayList<Move> possibleMovements = new ArrayList<>();

        //Upper Left
        Point upLeft = new Point(column - 1, row -1);
        if(isMoveOnBoard(upLeft) && (handler.isPieceAt(upLeft) && !handler.pieceAt(upLeft).getColor().equals(color) || !handler.isPieceAt(upLeft))) {
            possibleMovements.add(new Move(handler, id, upLeft));
        }
        //Up
        Point up = new Point(column, row -1);
        if(isMoveOnBoard(up) && (handler.isPieceAt(up) && !handler.pieceAt(up).getColor().equals(color) || !handler.isPieceAt(up)))
            possibleMovements.add(new Move(handler,id,up));

        //Upper Right
        Point upRight = new Point(column + 1, row -1);
        if(isMoveOnBoard(upRight) && (handler.isPieceAt(upRight) && !handler.pieceAt(upRight).getColor().equals(color) || !handler.isPieceAt(upRight)))
            possibleMovements.add(new Move(handler,id,upRight));

        //Right
        Point right = new Point(column + 1, row);
        if(isMoveOnBoard(right) && (handler.isPieceAt(right) && !handler.pieceAt(right).getColor().equals(color) || !handler.isPieceAt(right)))
            possibleMovements.add(new Move(handler,id,right));

        //Lower Right
        Point downRight = new Point(column + 1, row +1);
        if(isMoveOnBoard(downRight) && (handler.isPieceAt(downRight) && !handler.pieceAt(downRight).getColor().equals(color) || !handler.isPieceAt(downRight)))
            possibleMovements.add(new Move(handler,id,downRight));

        //Down
        Point down = new Point(column, row +1);
        if(isMoveOnBoard(down) && (handler.isPieceAt(down) && !handler.pieceAt(down).getColor().equals(color) || !handler.isPieceAt(down)))
            possibleMovements.add(new Move(handler,id,down));

        //Lower Left
        Point downLeft = new Point(column - 1, row +1);
        if(isMoveOnBoard(downLeft) && (handler.isPieceAt(downLeft) && !handler.pieceAt(downLeft).getColor().equals(color) || !handler.isPieceAt(downLeft)))
            possibleMovements.add(new Move(handler,id,downLeft));

        //Left
        Point left = new Point(column - 1, row);
        if(isMoveOnBoard(left) && (handler.isPieceAt(left) && !handler.pieceAt(left).getColor().equals(color) || !handler.isPieceAt(left)))
            possibleMovements.add(new Move(handler,id,left));



        return possibleMovements;
    }
}
