package pieces;

import game.Handler;

import java.awt.*;

public class Move {
    private int pieceID;
    private Point move;
    private Handler handler;
    private Point startPos;


    public Move(Handler handler, int pieceID, Point move){
        this.pieceID = pieceID;
        this.move = move;
        this.handler = handler;
        startPos = handler.getPiece(pieceID).getPos();
    }

    public int getPieceID() {
        return pieceID;
    }

    public Point getMove() {
        return move;
    }

    public void makeMove(){
        handler.getPiece(pieceID).moveTo(move);
    }

    public void testMove(){
        handler.getPiece(pieceID).setPos(move);
    }

    public void undoMove(){
        Point temp = move;
        move = startPos;
        handler.getPiece(pieceID).moveTo(move);
        move = temp;
    }
}
