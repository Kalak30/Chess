package pieces;

import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class for the Pawn piece. Extends the Piece class
 */
public class Pawn extends Piece {

    /**
     * Constructor that sends all parameters to the super class
     * @param handler handler to get information about the board and game
     * @param color Color the piece
     * @param column column the piece will start on
     * @param row row the piece will start on
     */
    public Pawn(Handler handler, String color, int column, int row){
        super(handler, color, "Pawn", column,row);

    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Pawn,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Pawn,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }


    @Override
    public ArrayList<Point> getMovement() {
        if(color.equals("black")){
            return getBlackMovement();
        }
        else
            return getWhiteMovement();
    }
    public ArrayList<Point> getBlackMovement(){
        ArrayList<Point> possibleMovements = new ArrayList<>();

        //if there is not a piece directly below this piece, then add a possible movement in front
        if(!handler.isPieceAt(column,row+1)) {
            possibleMovements.add(new Point(column, row + 1));
            //if this piece hasn't moved yet and there isn't a piece two rows in below, add a possible movement two rows below
            if (!hasMoved && !handler.isPieceAt(column, row+2))
                possibleMovements.add(new Point(column, row + 2));
        }

        //if there is a piece front right of this piece and it is not the players, add a possible movement there
        if(handler.isPieceAt(column+1,row + 1) && !handler.pieceAt(column+1, row + 1).getColor().equals(color))
            possibleMovements.add(new Point(column+1, row + 1));

        //if there is a piece front left of this piece and it is not the players, add a possible movement there.
        if(handler.isPieceAt(column - 1, row + 1) && !handler.pieceAt(column-1, row + 1).getColor().equals(color))
            possibleMovements.add(new Point(column-1, row + 1));


        return  possibleMovements;
    }
    public ArrayList<Point> getWhiteMovement(){
        ArrayList<Point> possibleMovements = new ArrayList<>();

        //if there is not a piece directly above this piece, then add a possible movement in front
        if(!handler.isPieceAt(column,row-1)) {
            possibleMovements.add(new Point(column, row - 1));
            //if this piece hasn't moved yet and there isn't a piece two rows in front, add a possible movement two rows in front
            if (!hasMoved && !handler.isPieceAt(column, row-2)) {
                possibleMovements.add(new Point(column, row - 2));
            }
        }

        //if there is a piece front right of this piece and it is not the players, add a possible movement there
        if(handler.isPieceAt(column+1,row - 1) && !handler.pieceAt(column+1, row - 1).getColor().equals(color)) {
            possibleMovements.add(new Point(column+1, row - 1));
        }

        //if there is a piece front left of this piece and it is not the players, add a possible movement there.
        if(handler.isPieceAt(column - 1, row - 1)&& !handler.pieceAt(column-1, row - 1).getColor().equals(color)) {
            possibleMovements.add(new Point(column-1, row - 1));
        }

        return possibleMovements;
    }

}
