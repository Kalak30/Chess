package enemyAI;

import game.Handler;
import pieces.Move;
import pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BasicAI {

    private String color;
    private ArrayList<Integer> ownedPieces;
    private ArrayList<Move> possibleMoves;

    private int pieceMoved;

    private Handler handler;


    public BasicAI(Handler handler, String color){
        this.handler = handler;
        this.color = color;
        init();
    }
    public void init(){
        possibleMoves = new ArrayList<>();
    }

    public void tick() {
        if (ownedPieces == null){
            ownedPieces = new ArrayList<>();
            for (Map.Entry<Integer,Piece> entry: handler.getBoard().getPieces().entrySet()) {
                if (entry.getValue().getColor().equals(color))
                    ownedPieces.add(entry.getValue().getId());
            }
    }
        updateOwnedPieced();


        if(handler.getBoard().isPlayersTurn())
            return;

        getPossibleMoves();
        generateBestMove();


        handler.getBoard().setPlayersTurn(true);
    }

    public void updateOwnedPieced(){
        ownedPieces.clear();
        for (Map.Entry<Integer,Piece> entry: handler.getBoard().getPieces().entrySet()) {
            if (entry.getValue().getColor().equals(color))
                ownedPieces.add(entry.getValue().getId());
        }
    }

    public void getPossibleMoves(){
        possibleMoves.clear();
        for(int i = 0; i < ownedPieces.size(); i++) {
            possibleMoves.addAll(handler.getPiece(ownedPieces.get(i)).getMovement());
        }
    }
    public void generateBestMove() {
        Move bestMoveSoFar = null;
        int bestMoveValue = Integer.MIN_VALUE;

        ArrayList<Move> moves = possibleMoves;
        Collections.shuffle(moves);
        for (Move m : possibleMoves) {

            Piece removedPiece = null;

            if(handler.isPieceAt(m.getMove())) {
                removedPiece = handler.pieceAt(m.getMove());
                removedPiece.setId(handler.pieceAt(m.getMove()).getId());
            }
            m.makeMove();


            int boardValue = updateBoardValue();
            if (boardValue > bestMoveValue) {
                bestMoveSoFar = m;
                bestMoveValue = boardValue;
                System.out.println(bestMoveSoFar.getMove());
            }

            if(removedPiece != null)
                handler.getBoard().getPieces().put(removedPiece.getId(), removedPiece);

            m.undoMove();
        }

        bestMoveSoFar.makeMove();
    }

    public int updateBoardValue(){
        int boardValue = 0;
        for(Map.Entry<Integer,Piece> entry: handler.getBoard().getPieces().entrySet()){
            boardValue += entry.getValue().getValue() * (entry.getValue().getColor().equals(color) ? 1 : -1);
        }
        System.out.println(boardValue+"\n");
        return boardValue;
    }


}
