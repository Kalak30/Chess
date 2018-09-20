package pieces;

import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to store the information of a bishop. Extends the Piece class
 */
public class Bishop extends Piece{
    /**
     * Constructor that sends all parameters to super class
     * @param handler handler to get information of the board and game
     * @param color Color of the piece
     * @param column column that the piece will start on
     * @param row row that the piece will start on
     */
    public Bishop(Handler handler, String color, int column, int row){

        super(handler, color, "Bishop", column, row);
        value = 350;
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Bishop,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Bishop,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Move> getMovement() {
        ArrayList<Move> possibleMovements = new ArrayList<>();

        //Down Right
        for(int i = 1; i <= 7; i++) {
            Point p = new Point(column+i,row+i);
            if(!isMoveOnBoard(p))
                continue;
            if(handler.getBoard().isPieceAt(p)){
                if(!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler,id,p));
                break;
            }
            possibleMovements.add(new Move(handler,id,p));
        }

        //Down Left
        for(int i = 1; i <= 7; i++) {
            Point p = new Point(column-i,row+i);
            if(!isMoveOnBoard(p))
                continue;
            if(handler.getBoard().isPieceAt(p)){
                if(!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler,id,p));
                break;
            }

            possibleMovements.add(new Move(handler,id,p));

        }

        //Up Right
        for(int i = 1; i <= 7; i++) {
            Point p = new Point(column+i,row-i);
            if(!isMoveOnBoard(p))
                continue;
            if(handler.getBoard().isPieceAt(p)){
                if(!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler,id,p));
                break;
            }

            possibleMovements.add(new Move(handler,id,p));

        }

        //Up Left
        for(int i = 1; i <= 7; i++) {
            Point p = new Point(column-i,row-i);
            if(!isMoveOnBoard(p))
                continue;
            if(handler.getBoard().isPieceAt(p)){
                if(!handler.pieceAt(p).getColor().equals(color))
                    possibleMovements.add(new Move(handler,id,p));
                break;
            }

            possibleMovements.add(new Move(handler,id,p));

        }


        return possibleMovements;
    }

//    public ArrayList<Point> getBlackMovement(){
//
//    }
//
//    public ArrayList<Point> getWhiteMovement(){
//
//    }
}
