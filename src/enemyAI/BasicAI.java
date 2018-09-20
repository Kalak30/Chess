package enemyAI;

import game.Handler;
import pieces.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicAI {

    private String color;
    private Piece pieceToMove;
    private ArrayList<Integer> ownedPieces;
    private Map<Integer, ArrayList<Point>> possibleMoves;

    private int pieceMoved;

    private Handler handler;

    public BasicAI(Handler handler, String color){
        this.handler = handler;
        this.color = color;
        init();
    }
    public void init(){
        possibleMoves = new HashMap<>();
    }

    public void tick() {
        if (ownedPieces == null){
            ownedPieces = new ArrayList<>();
            for (int i = 0; i < handler.getBoard().getPieces().size(); i++) {
                if (handler.getBoard().getPieces().get(i).color.equals(color))
                    ownedPieces.add(handler.getPiece(i).getId());
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
        for (int i = 0; i < handler.getBoard().getPieces().size(); i++) {
            if (handler.getBoard().getPieces().get(i).color.equals(color))
                ownedPieces.add(handler.getPiece(i).getId());
        }
    }

    public void getPossibleMoves(){
        for(int i = 0; i < ownedPieces.size(); i++) {
            possibleMoves.put(ownedPieces.get(i), handler.getPiece(ownedPieces.get(i)).getMovement());
        }
    }
    public void generateBestMove() {
        Point rdmMovement;

        rdmMovement = getRandomMovement();

        System.out.println(rdmMovement);
        handler.setSelectedPiece(pieceMoved);
        handler.moveSelectedPiece(rdmMovement.x,rdmMovement.y);
    }

    public Point getRandomMovement() {
        Piece rdmPiece = handler.getPiece(ownedPieces.get(handler.randomInt(0, ownedPieces.size()-1)));
        pieceMoved = rdmPiece.getId();
        while (handler.getPiece(pieceMoved).getMovement().size()-1 <= 0){
            rdmPiece = handler.getPiece(ownedPieces.get(handler.randomInt(0, ownedPieces.size()-1)));
            pieceMoved = rdmPiece.getId();
        }

        System.out.println(handler.getPiece(pieceMoved).getMovement().size()-1 );

        Point rdmMovement = possibleMoves.get(pieceMoved).get(handler.randomInt(0, handler.getPiece(pieceMoved).getMovement().size() - 1));
        return rdmMovement;


    }


}
