package com.company.app;

import com.company.app.models.*;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
                Cell cell = new Cell(i, 2);
                pieces.add(new Pawn(true, cell, PlayerColor.WHITE));
            }
            pieces.add(new Rook(true, new Cell(0, 0), PlayerColor.WHITE));
            pieces.add(new Rook(true, new Cell(7, 0), PlayerColor.WHITE));
            pieces.add(new Knight(true, new Cell(1, 0), PlayerColor.WHITE));
            pieces.add(new Knight(true, new Cell(6, 0), PlayerColor.WHITE));
            pieces.add(new Bishop(true, new Cell(2, 0), PlayerColor.WHITE));
            pieces.add(new Bishop(true, new Cell(5, 0), PlayerColor.WHITE));
            pieces.add(new Queen(true, new Cell(3, 0), PlayerColor.WHITE));
            pieces.add(new King(true, new Cell(4, 0), PlayerColor.WHITE));

        } else {
            for (int i = 0; i < 8; i++) {
                Cell cell = new Cell(i, 6);
                pieces.add(new Pawn(true, cell, PlayerColor.BLACK));
            }
            pieces.add(new Rook(true, new Cell(0, 7), PlayerColor.BLACK));
            pieces.add(new Rook(true, new Cell(7, 7), PlayerColor.BLACK));
            pieces.add(new Knight(true, new Cell(1, 7), PlayerColor.BLACK));
            pieces.add(new Knight(true, new Cell(6, 7), PlayerColor.BLACK));
            pieces.add(new Bishop(true, new Cell(2, 7), PlayerColor.BLACK));
            pieces.add(new Bishop(true, new Cell(5, 7), PlayerColor.BLACK));
            pieces.add(new Queen(true, new Cell(3, 7), PlayerColor.BLACK));
            pieces.add(new Bishop(true, new Cell(4, 7), PlayerColor.BLACK));
        }
    }

/*    public List<Command> getCurrentCmd() {
        return this.cmds;
    }*/

    public Piece getRandomPiece() {
        Random random = new Random();
        return pieces.get(random.nextInt(pieces.size()));
    }


}
