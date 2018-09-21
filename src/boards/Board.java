package boards;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import enemyAI.BasicAI;
import game.*;
import pieces.Move;
import pieces.Piece;

/**
 * Abstract class to define what every board shall contain, whether it be
 * a regular board or 4 player board
 */
public abstract class Board {
    /**
     * Two ints to determine what the default board width and board height are
     */
    public static final int BOARD_WIDTH = 640, BOARD_HEIGHT = 640;

    /**
     * A list of all of the pieces
     */
    protected Map<Integer,Piece> pieces;

    /**
     * Array storing the x pixel values for the upper left of each position on the board
     */
    protected int[] columns;

    /**
     * Array storing the y pixel values for the upper left of each position on the board
     */
    protected int[] rows;


    /**
     * A point object which stores x and y in reference to the column and row position
     */
    protected Point selectedBoardPos;

    /**
     * A list of points that describe the possible moves the selected piece has
     */
    protected ArrayList<Move> selectedPieceMove;

    /**
     * String to store the color of the player
     */
    protected String playerColor;

    /**
     * An object to store the selected piece
     */
    protected Piece selectedPiece;

    /**
     * Handler to get information about the game
     */
    protected Handler handler;

    /**
     * Boolean to determine if it is the players turn
     */
    protected boolean isPlayersTurn;

    /**
     * The basic AI that controls the computer player
     */
    protected BasicAI computer;


    /**
     * Initializes selectedPiece to null and selectedPieceMove to a blank ArrayList
     * <p>Initializes the handler to the input handler parameter. Also calls the init() method</p>
     * @param handler Handler to get access to the game and board state
     */
    public Board(Handler handler){
        selectedPiece = null;
        selectedPieceMove = new ArrayList<>();
        this.handler = handler;
        init();
    }

    /**
     * Abstract method to initialize the amount of pieces, columns, rows, and color of the player
     */
    protected abstract void init();

    /**
     * Only called when leftPressed == true.
     * <p>
     *     First resets the selected position and then updates the selected position to
     *     where the mouse was clicked at
     */
    protected abstract void updateSelectedBoardPos();

    /**
     * Sets up where the board positions are and in what column and row they are in.
     */
    protected abstract void setUpBoardPositions();

    /**
     * Sets up the pieces for the current board layout. If it is two player, there will be
     * two colors and one player on each end of the board.
     * <p>If it is four player there would be 4 different colors and one player on each side of the board</p>
     */
    protected abstract void setUpPieces();

    /**
     * Method to update positions of pieces and selections
     */
    public abstract void tick();

    /**
     * Method to draw the board, each piece, and the possible moves of the selected piece
     * @param g
     */
    public abstract void render(Graphics g);

    /**
     * Updates whether or not a piece is selected and which piece is selected
     */
    public void updateSelectedPiece(){
        if(isPieceAt(selectedBoardPos) && pieceAt(selectedBoardPos).isPlayers()) {
            System.out.println("click");
            selectedPiece = pieceAt(selectedBoardPos);
            System.out.println(selectedPiece.type);
        }
    }

    public void setSelectedPiece(int id){
        selectedPiece = pieces.get(id);
    }

    /**
     * Moves the selected piece to a certain column and row. Then resets selectedPieceMove list
     * @param p The move that the selectedPiece should make
     */
    public void moveSelectedPiece(Point p){
        if(isPieceAt(p) && pieceAt(p)!= selectedPiece){
            pieces.remove(pieceAt(p).getId());
        }

        selectedPiece.setPos(p);

        if(!selectedPiece.isHasMoved()){
            selectedPiece.setHasMoved(true);
        }
        selectedPiece = null;
        resetSelectedPieceMove();
        isPlayersTurn = false;
    }

    /**
     * Checks if one of the possible moves of the last selected piece were clicked on.
     * <p> If a possible move was clicked on, it calls the moveSelectedPiece(int,int) method, then returns to quit the loop</p>
     */
    protected void checkPieceMove(){
        for(Move move: selectedPieceMove){
            if(selectedBoardPos.equals(move.getMove())){
                moveSelectedPiece(move.getMove());
                return;
            }
        }
    }

    /**
     * Returns a boolean value determining if there is a piece at the specified column and row
     * @param p Point to check for piece
     * @return True if there is a piece at specified spot -- False is there is no piece at specified spot
     */
    public boolean isPieceAt(Point p){
        if(pieceAt(p) != null)
            return true;
        else
            return false;
    }

    /**
     * Returns a Piece object of the piece at the specified column and row.
     * <p>isPieceAt(column,row) should return true</p>
     * @param p Point to get the piece at
     * @return Returns the piece at the column and row specified
     *         Returns null if there is no piece there
     */
    public Piece pieceAt(Point p){
        for(Map.Entry<Integer,Piece> entry: pieces.entrySet()){
            if(entry.getValue().getPos().equals(p))
                return  entry.getValue();

        }
        return null;
    }

    /**
     * Returns a boolean value determining if there is a piece at the selectedBoardPosition and if it is the players
     * @return True if there is a piece at the selected board position and it is the players -- False otherwise
     */
    public boolean isPieceSelected(){
        if(isPieceAt(selectedBoardPos) && pieceAt(selectedBoardPos).isPlayers())
            return true;

        return false;
    }


    /**
     * Gets the movement of the selected piece if there is one, and sets it the selectedPieceMove
     */
    public void getSelectedPieceMove(){
        if(isPieceSelected())
            selectedPieceMove = pieceAt(selectedBoardPos).getMovement();
    }

    /*
        GETTERS ----- SETTERS
     */

    /**
     * Gets the x pixel value of the upper left of the specified column
     * @param column Column to get the x pixel value of
     * @return Returns x pixel value of the upper left of the specified column
     */
    public int getColumn(int column){return columns[column];}

    /**
     * Gets the y pixel value of the upper left of the specified row
     * @param row Row to get the y pixel value of
     * @return Returns  y pixel value of the upper left of the specified row
     */
    public int getRow(int row){return rows[row];}

    /**
     * clears the selectedPieceMove list so it is clear for the next set of possible moves
     */
    public void resetSelectedPieceMove(){
        selectedPieceMove.clear();
    }

    /**
     * Resets the selected position back to its default of 1 + maxColumns, and 1 + maxRows
     */
    public void resetSelectedBoardPos(){
        selectedBoardPos.move(8,8);
    }

    /**
     * Returns String value of the players color
     * @return String value of the players color
     */
    public String getPlayerColor() {
        return playerColor;
    }

    /**
     * Returns the array list of pieces
     * @return pieces ArrayList
     */
    public Map<Integer,Piece> getPieces() {
        return pieces;
    }

    /**
     * Returns if it is the players turn
     * @return isPlayerTurn
     */
    public boolean isPlayersTurn() {
        return isPlayersTurn;
    }

    /**
     * Sets isPlayersTurn to true or false
     * @param playersTurn Value to set isPlayersTurn to
     */
    public void setPlayersTurn(boolean playersTurn) {
        isPlayersTurn = playersTurn;
    }
}
