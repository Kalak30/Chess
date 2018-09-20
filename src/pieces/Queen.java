package pieces;

import boards.BasicBoard;
import game.Handler;
import gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class to store information about the queen piece. Extends Piece class
 */
public class Queen extends Piece {
    /**
     * Constructor that sends all of its parameters to the super class
     * @param handler Handler to access information about the board and game state
     * @param color Color of the piece
     * @param column Column on the board that the piece will start on
     * @param row Row on the board that the piece will start on
     */
    public Queen(Handler handler, String color, int column, int row){
        super(handler, color, "Queen", column, row);
    }

    @Override
    public void render(Graphics g) {
        if(color.equals("white"))
            g.drawImage(Assets.white_Queen,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);
        else
            g.drawImage(Assets.black_Queen,handler.getBoard().getColumn(column),handler.getBoard().getRow(row),64,64,null);

    }

    @Override
    public ArrayList<Point> getMovement() {
        ArrayList<Point> possibleMovements = new ArrayList<>();

        //right loop
        for(int i = 0; i < BasicBoard.COLUMNS-column; i++){
            if(handler.getBoard().isPieceAt(column+i,row) && handler.pieceAt(column+i,row) != this){
                if(!handler.pieceAt(column+i,row).getColor().equals(color))
                    possibleMovements.add(new Point(column+i,row));
                break;
            }
            if(handler.pieceAt(column+i,row) != this)
                possibleMovements.add(new Point(column+i,row));

        }
        //left loop
        for(int i = 0; i < column+1; i++){
            if(handler.getBoard().isPieceAt(column-i,row) && handler.pieceAt(column-i,row) != this){
                if(!handler.pieceAt(column-i,row).getColor().equals(color))
                    possibleMovements.add(new Point(column-i,row));
                break;
            }
            if(handler.pieceAt(column-i,row) != this)
                possibleMovements.add(new Point(column-i,row));

        }
        //up loop
        for(int i = 0; i < row+1; i ++){
            if(handler.getBoard().isPieceAt(column,row-i) && handler.pieceAt(column,row-i) != this){
                if(!handler.pieceAt(column,row-i).getColor().equals(color))
                    possibleMovements.add(new Point(column,row-i));
                break;
            }
            if(handler.pieceAt(column,row-i) != this)
                possibleMovements.add(new Point(column,row-i));

        }
        //down loop
        for(int i = 0; i < BasicBoard.ROWS-row; i++){
            if(handler.getBoard().isPieceAt(column,row+i) && handler.pieceAt(column,row+i) != this){
                if(!handler.pieceAt(column,row+i).getColor().equals(color))
                    possibleMovements.add(new Point(column,row+i));
                break;
            }

            if(handler.pieceAt(column,row+i) != this)
                possibleMovements.add(new Point(column,row+i));

        }

        //Down Right
        for(int i = 1; i <= 7; i++) {
            if(handler.getBoard().isPieceAt(column + i, row + i)){
                if(!handler.pieceAt(column + i, row + i).getColor().equals(color))
                    possibleMovements.add(new Point(column + i, row + i));
                break;
            }
            possibleMovements.add(new Point(column + i, row + i));
        }

        //Down Left
        for(int i = 1; i <= 7; i++) {
            if(handler.getBoard().isPieceAt(column - i, row + i)){
                if(!handler.pieceAt(column - i, row + i).getColor().equals(color))
                    possibleMovements.add(new Point(column - i, row + i));
                break;
            }

            possibleMovements.add(new Point(column - i, row + i));

        }

        //Up Right
        for(int i = 1; i <= 7; i++) {
            if(handler.getBoard().isPieceAt(column + i, row - i)){
                if(!handler.pieceAt(column + i, row - i).getColor().equals(color))
                    possibleMovements.add(new Point(column + i, row - i));
                break;
            }

            possibleMovements.add(new Point(column + i, row - i));

        }

        //Up Left
        for(int i = 1; i <= 7; i++) {
            if(handler.getBoard().isPieceAt(column-i,row-i)){
                if(!handler.pieceAt(column - i, row - i).getColor().equals(color))
                    possibleMovements.add(new Point(column - i, row - i));
                break;
            }

            possibleMovements.add(new Point(column - i, row - i));

        }



        return possibleMovements;
    }
}
