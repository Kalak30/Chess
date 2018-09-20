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
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Bishop,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Bishop,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Point> getMovement() {
        ArrayList<Point> possibleMovements = new ArrayList<>();

        //Down Right
        for(int i = 1; i <= 7; i++) {
            if(handler.isPieceAt(column + i, row + i)){
                if(!handler.pieceAt(column + i, row + i).getColor().equals(color))
                    possibleMovements.add(new Point(column + i, row + i));
                break;
            }
                possibleMovements.add(new Point(column + i, row + i));
        }

        //Down Left
        for(int i = 1; i <= 7; i++) {
            if(handler.isPieceAt(column - i, row + i)){
                if(!handler.pieceAt(column - i, row + i).getColor().equals(color))
                    possibleMovements.add(new Point(column - i, row + i));
                break;
            }

            possibleMovements.add(new Point(column - i, row + i));

        }

        //Up Right
        for(int i = 1; i <= 7; i++) {
            if(handler.isPieceAt(column + i, row - i)){
                if(!handler.pieceAt(column + i, row - i).getColor().equals(color))
                    possibleMovements.add(new Point(column + i, row - i));
                break;
            }

            possibleMovements.add(new Point(column + i, row - i));

        }

        //Up Left
        for(int i = 1; i <= 7; i++) {
            if(handler.isPieceAt(column-i,row-i)){
                if(!handler.pieceAt(column - i, row - i).getColor().equals(color))
                    possibleMovements.add(new Point(column - i, row - i));
                break;
            }

            possibleMovements.add(new Point(column - i, row - i));

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
