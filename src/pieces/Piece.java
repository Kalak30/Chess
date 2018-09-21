package pieces;

import game.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Abstract class to store the basics of each piece.
 * Cannot be instantiated.
 */
public abstract class Piece{
    /**
     * Static variables to store the default width and default height of a piece
     */
    public static final int DEFAULT_WIDTH = 64, DEFAULT_HEIGHT = 64;


    /**
     * integer to store the current column of the game board the piece is on
     */
    protected int column;
    /**
     * integer to store the current row of the game board the piece is on
     */
    protected int row;

    /**
     * Position in the piece list in the board class. Unique to each piece
     */
    protected Integer id;
    /**
     * static int to store the total amount of pieces have been created
     */
    public static int totalPieces = 0;

    /**
     * Boolean to store if the piece has moved. Once moved never is set to false again
     */
    protected boolean hasMoved;

    /**
     * An instance of the handler class
     */
    protected Handler handler;

    /**
     * String to store the color of the piece
     */
    public String color;

    /**
     * String to store the type(King,Queen,...) of the piece
     */
    public String type;

    protected int value;

    /**
     * Basic constructor for a piece. Initializes the above variables.
     * @param handler Handler for information about the board and the game class
     * @param color Color of the piece
     * @param type whether it is a queen or king or any other piece
     * @param column column the piece will start on
     * @param row row the piece will start on
     */
    public Piece(Handler handler, String color, String type, int column, int row){
        this.handler = handler;
        this.color = color;
        this.type = type;
        this.column = column;
        this.row = row;
        hasMoved = false;
        id = totalPieces;
        totalPieces++;

    }

    public void moveTo(Point p){
        handler.getBoard().setSelectedPiece(id);
        handler.getBoard().moveSelectedPiece(p);
    }

    public void setPos(Point p){
        column = p.x;
        row = p.y;
    }

    public Point getPos(){
        return new Point(column,row);
    }

    public boolean isMoveOnBoard(Point p){

        if(p.x >= 0 && p.x < 8 && p.y >= 0 && p.y < 8) {
            return true;
        }
        else
            return false;

    }

    /**
     * Returns if the piece has moved during this game or not
     * @return hasMoved
     */
    public boolean isHasMoved() {
        return hasMoved;
    }

    /**
     * Sets the hasMoved variable for the piece
     * @param hasMoved Boolean value - should only every be true;
     */
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /**
     * Gets the current column on the board the piece is at
     * @return column
     */
    public int getPieceColumn() {
        return column;
    }

    /**
     * Gets the current row on the board the piece is at
     * @return row
     */
    public int getPieceRow(){
        return row;
    }

    /**
     * Sets column to the column parameter that is given
     * @param column integer where 0 <= column < 8
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Sets row to the row parameter that is giveen
     * @param row integer where 0 <= row < 8
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns true if this piece's color is equal to the players color, false
     * if it isn't
     */
    public boolean isPlayers(){

        return color == handler.getBoard().getPlayerColor();
    }

    /**
     * Abstract method to be used in rendering the piece
     * @param g graphics Component that is used to draw the piece
     */
    public abstract void render(Graphics g);

    /**
     * Abstract method to return a list of possible points the piece could move to.
     * @return possibleMovements
     */
    public abstract ArrayList<Move> getMovement();

    public String getColor() {
        return color;
    }

    public Integer getId() {
        return id;
    }

    public String toString(){
        return "Column:   " + column + "  Row:    "+ row;
    }

    public int getValue() {
        return value;
    }
}
