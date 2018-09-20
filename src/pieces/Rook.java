package pieces;

import boards.BasicBoard;
import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to store information about the rook piece. Extends Piece class
 */
public class Rook extends Piece{
    /**
     * Constructor that sends all of its parameters to the super class
     * @param handler Handler to access information about the board and game state
     * @param color Color of the piece
     * @param column Column on the board that the piece will start on
     * @param row Row on the board that the piece will start on
     */
    public Rook(Handler handler, String color, int column, int row){
        super(handler, color, "Rook", column, row);
        value = 525;
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Rook,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Rook,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Move> getMovement() {
        ArrayList<Move> possibleMovements = new ArrayList<>();

        //right loop
        for (int i = 0; i < BasicBoard.COLUMNS - column; i++) {
            Point p = new Point(column + i, row);
            if (!isMoveOnBoard(p))
                continue;
            if (handler.getBoard().isPieceAt(p) && handler.pieceAt(p) != this) {
                if (!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler, id, p));
                break;
            }
            if (handler.pieceAt(p) != this)
                possibleMovements.add(new Move(handler, id, p));

        }
        //left loop
        for (int i = 0; i < column + 1; i++) {
            Point p = new Point(column - i, row);
            if (!isMoveOnBoard(p))
                continue;
            if (handler.getBoard().isPieceAt(p) && handler.pieceAt(p) != this) {
                if (!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler, id, p));
                break;
            }
            if (handler.pieceAt(p) != this)
                possibleMovements.add(new Move(handler, id, p));

        }
        //up loop
        for (int i = 0; i < row + 1; i++) {
            Point p = new Point(column, row - i);
            if (!isMoveOnBoard(p))
                continue;
            if (handler.getBoard().isPieceAt(p) && handler.pieceAt(p) != this) {
                if (!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler, id, p));
                break;
            }
            if (handler.pieceAt(p) != this)
                possibleMovements.add(new Move(handler, id, p));

        }
        //down loop
        for (int i = 0; i < BasicBoard.ROWS - row; i++) {
            Point p = new Point(column, row + i);
            if (!isMoveOnBoard(p))
                continue;
            if (handler.getBoard().isPieceAt(p) && handler.pieceAt(p) != this) {
                if (!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler, id, p));
                break;
            }

            if (handler.pieceAt(p) != this)
                possibleMovements.add(new Move(handler, id, p));



        }
        return possibleMovements;
    }
}
