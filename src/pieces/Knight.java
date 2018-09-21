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
        value = 350;
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Knight,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Knight,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Move> getMovement() {
        ArrayList<Move> possibleMovements = new ArrayList<>();
        //Upper Left
        Point upLeft = new Point(column - 1, row - 2);
        if(isMoveOnBoard(upLeft) && (!handler.isPieceAt(upLeft) ||handler.isPieceAt(upLeft) && !handler.pieceAt(upLeft).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,upLeft));

        //Upper Right
        Point upRight = new Point(column + 1, row - 2);
        if(isMoveOnBoard(upRight) && (!handler.isPieceAt(upRight) ||handler.isPieceAt(upRight) && !handler.pieceAt(upRight).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,upRight));
        //Right Up
        Point rightUp = new Point(column + 2, row - 1);
        if(isMoveOnBoard(rightUp) && (!handler.isPieceAt(rightUp) ||handler.isPieceAt(rightUp) && !handler.pieceAt(rightUp).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,rightUp));

        //Right Down
        Point rightDown = new Point(column + 2, row + 1);
        if(isMoveOnBoard(rightDown) && (!handler.isPieceAt(rightDown) ||handler.isPieceAt(rightDown) && !handler.pieceAt(rightDown).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,rightDown));

        //Lower Right
        Point downRight = new Point(column + 1, row + 2);
        if(isMoveOnBoard(downRight) && (!handler.isPieceAt(downRight) ||handler.isPieceAt(downRight) && !handler.pieceAt(downRight).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,downRight));

        //Lower Left
        Point downLeft = new Point(column - 1, row + 2);
        if(isMoveOnBoard(downLeft) && (!handler.isPieceAt(downLeft) ||handler.isPieceAt(downLeft) && !handler.pieceAt(downLeft).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,downLeft));

        //Left down
        Point leftDown = new Point(column - 2, row + 1);
        if(isMoveOnBoard(leftDown) && (!handler.isPieceAt(leftDown) ||handler.isPieceAt(leftDown) && !handler.pieceAt(leftDown).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,leftDown));

        //Left Up
        Point leftUp = new Point(column - 2, row - 1);
        if(isMoveOnBoard(leftUp) && (!handler.isPieceAt(leftUp) ||handler.isPieceAt(leftUp) && !handler.pieceAt(leftUp).getColor().equals(color)))
            possibleMovements.add(new Move(handler,id,leftUp));



        return possibleMovements;
    }
}
