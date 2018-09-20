package boards;

import enemyAI.BasicAI;
import game.Handler;
import gfx.Assets;
import pieces.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that represents the normal 2 player chess board
 */
public class BasicBoard extends Board {
    /**
     * Int for the amount of columns and rows there are going to be in this row.
     */
    public static final int COLUMNS = 8, ROWS = 8;

    /**
     * Takes in a handler object and passes it to the super class
     * @param handler Handler to get information about the game state
     */
    public BasicBoard(Handler handler){
        super(handler);

    }

    public void init(){
        columns = new int[COLUMNS];
        rows = new int[ROWS];
        selectedBoardPos = new Point(8,8);
        pieces = new HashMap<>();
        playerColor = "white";

        setUpBoardPositions();
        setUpPieces();

        if(playerColor.equals("white")) {
            computer = new BasicAI(handler, "black");
            isPlayersTurn = true;
        }
        else {
            computer = new BasicAI(handler,"white");
            isPlayersTurn = false;
        }

    }

    public void tick(){
        if(isPlayersTurn) {
            if (handler.getMouseManager().isLeftClicked()) {
                updateSelectedBoardPos();

                if (!selectedBoardPos.equals(new Point(8, 8))) {
                    updateSelectedPiece();
                    getSelectedPieceMove();
                    checkPieceMove();
                }

            }
        }
        else{
            computer.tick();
        }
    }
    public void render(Graphics g){
        g.drawImage(Assets.board,(handler.getWidth()/2)-BOARD_WIDTH/2,(handler.getHeight()/2)-BOARD_HEIGHT/2, BOARD_WIDTH, BOARD_HEIGHT,null);

        if(!selectedBoardPos.equals(new Point(8,8))) {
            for (Move m : selectedPieceMove) {
                try {
                    g.drawImage(Assets.selected_Tile, columns[m.getMove().x], rows[m.getMove().y], 64, 64, null);
                }catch (Exception e){
                    System.out.println(m.getMove());
                }
            }
        }

        for(Map.Entry<Integer,Piece> entry: pieces.entrySet()){
            entry.getValue().render(g);
        }

    }




    public void updateSelectedBoardPos(){

        resetSelectedBoardPos();
        for(int i = 0; i < columns.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                if (handler.getMouseManager().getMouseX() >= columns[i] && handler.getMouseManager().getMouseX() < columns[i] + Piece.DEFAULT_WIDTH && handler.getMouseManager().getMouseY() >= rows[j] && handler.getMouseManager().getMouseY() < rows[j] + Piece.DEFAULT_HEIGHT){
                    if (selectedBoardPos.x != i && selectedBoardPos.y != j)
                            selectedBoardPos.move(i, j);
                            return;
                    }

                }
            }
        }




    public void setUpBoardPositions(){

        for(int i = 0; i < columns.length; i++){

            columns[i] = ((handler.getWidth()/2)-BOARD_WIDTH/2)+(Piece.DEFAULT_WIDTH*(i)+64);
            rows[i] = ((handler.getHeight()/2)-BOARD_HEIGHT/2) + (Piece.DEFAULT_HEIGHT*(i)+64);

        }
    }



    public void setUpPieces(){
        for(int i = 0; i < 8; i ++){
            pieces.put(Piece.totalPieces, new Pawn(handler,"black",i,1));
            pieces.put(Piece.totalPieces, new Pawn(handler,"white",i,6));
        }


        pieces.put(Piece.totalPieces, new Rook(handler,"black",0,0));
        pieces.put(Piece.totalPieces, new Knight(handler,"black",1,0));
        pieces.put(Piece.totalPieces, new Bishop(handler,"black",2,0));
        pieces.put(Piece.totalPieces, new Queen(handler,"black",3,0));
        pieces.put(Piece.totalPieces, new King(handler,"black",4,0));
        pieces.put(Piece.totalPieces, new Bishop(handler,"black",5,0));
        pieces.put(Piece.totalPieces, new Knight(handler,"black",6,0));
        pieces.put(Piece.totalPieces, new Rook(handler,"black",7,0));

        pieces.put(Piece.totalPieces, new Rook(handler,"white",0,7));
        pieces.put(Piece.totalPieces, new Knight(handler,"white",1,7));
        pieces.put(Piece.totalPieces, new Bishop(handler,"white",2,7));
        pieces.put(Piece.totalPieces, new Queen(handler,"white",3,7));
        pieces.put(Piece.totalPieces, new King(handler,"white",4,7));
        pieces.put(Piece.totalPieces, new Bishop(handler,"white",5,7));
        pieces.put(Piece.totalPieces, new Knight(handler,"white",6,7));
        pieces.put(Piece.totalPieces, new Rook(handler,"white",7,7));

    }
}
