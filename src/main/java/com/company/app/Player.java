package com.company.app;

import com.company.app.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public PlayerColor color;
    private List<Piece> pieces = new ArrayList<Piece>();

    public Player(PlayerColor color){
        super();
        this.color = color;
        initializePieces();
    }

    public List<Piece> getPieces(){
        return pieces;
    }

    public void initializePieces() {
        if (this.color == PlayerColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                Cell cell = new Cell(i, 1);
                pieces.add(new Pawn(cell, PlayerColor.WHITE));
            }
            pieces.add(new Rook(new Cell(0, 0), PlayerColor.WHITE));
            pieces.add(new Rook(new Cell(7, 0), PlayerColor.WHITE));
            pieces.add(new Knight(new Cell(1, 0), PlayerColor.WHITE));
            pieces.add(new Knight(new Cell(6, 0), PlayerColor.WHITE));
            pieces.add(new Bishop(new Cell(2, 0), PlayerColor.WHITE));
            pieces.add(new Bishop(new Cell(5, 0), PlayerColor.WHITE));
            pieces.add(new Queen(new Cell(3, 0), PlayerColor.WHITE));
            pieces.add(new King(new Cell(4, 0), PlayerColor.WHITE));

        } else {
            for (int i = 0; i < 8; i++) {
                Cell cell = new Cell(i, 6);
                pieces.add(new Pawn(cell, PlayerColor.BLACK));
            }
            pieces.add(new Rook(new Cell(0, 7), PlayerColor.BLACK));
            pieces.add(new Rook(new Cell(7, 7), PlayerColor.BLACK));
            pieces.add(new Knight(new Cell(1, 7), PlayerColor.BLACK));
            pieces.add(new Knight(new Cell(6, 7), PlayerColor.BLACK));
            pieces.add(new Bishop(new Cell(2, 7), PlayerColor.BLACK));
            pieces.add(new Bishop(new Cell(5, 7), PlayerColor.BLACK));
            pieces.add(new Queen(new Cell(3, 7), PlayerColor.BLACK));
            pieces.add(new King(new Cell(4, 7), PlayerColor.BLACK));
        }
    }

    public Piece getRandomPiece() {
        Random random = new Random();
        return pieces.get(random.nextInt(pieces.size()));
    }

    public void checkPieces(ArrayList<Piece> deleted) {
        for(int i = 0; i < pieces.size(); i++) {
            if(deleted.contains(pieces.get(i))){
                pieces.remove(i);
            }
        }
    }
}
