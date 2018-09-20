package enemyAI;

import game.Handler;
import pieces.Move;
import pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
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
        for(int i = 0; i < ownedPieces.size(); i++) {
            possibleMoves.addAll(handler.getPiece(ownedPieces.get(i)).getMovement());
        }
    }
    public void generateBestMove() {
        Move bestMoveSoFar = null;
        int bestMoveValue = Integer.MIN_VALUE;

        for(Move m: possibleMoves){

           m.makeMove();

            int boardValue = updateBoardValue();
            if(boardValue > bestMoveValue){
                bestMoveSoFar = m;
                bestMoveValue = boardValue;
            }

            m.undoMove();
        }

        bestMoveSoFar.makeMove();
//        Point rdmMovement;
//
//        rdmMovement = getRandomMovement();
//
//        System.out.println(rdmMovement);
//        handler.setSelectedPiece(pieceMoved);
//        handler.moveSelectedPiece(rdmMovement.x,rdmMovement.y);
    }

//    public Point getRandomMovement() {
//        Piece rdmPiece = handler.getPiece(ownedPieces.get(handler.randomInt(0, ownedPieces.size()-1)));
//        pieceMoved = rdmPiece.getId();
//        while (handler.getPiece(pieceMoved).getMovement().size()-1 <= 0){
//            rdmPiece = handler.getPiece(ownedPieces.get(handler.randomInt(0, ownedPieces.size()-1)));
//            pieceMoved = rdmPiece.getId();
//        }
//
//        System.out.println(handler.getPiece(pieceMoved).getMovement().size()-1 );
//
//        Point rdmMovement = possibleMoves.get(pieceMoved).get(handler.randomInt(0, handler.getPiece(pieceMoved).getMovement().size() - 1));
//        return rdmMovement;
//
//
//    }

    public int updateBoardValue(){
        int boardValue = 0;
        for(Map.Entry<Integer,Piece> entry: handler.getBoard().getPieces().entrySet()){
            boardValue += entry.getValue().getValue() * (entry.getValue().getColor().equals(color) ? 1 : -1);
        }
        return boardValue;
    }


}
