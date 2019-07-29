package com.company.app;

import com.company.app.factory.CreatePieces;
import com.company.app.factory.FactoryBlack;
import com.company.app.factory.FactoryPiece;
import com.company.app.factory.FactoryWhite;
import com.company.app.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private final PlayerColor color;
    private List<Piece> pieces = new ArrayList<Piece>();

    public Player(PlayerColor color) {
        this.color = color;
        initializePieces();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public PlayerColor getColor() {
        return this.color;
    }

    public void initializePieces() {
        FactoryPiece factory;
        CreatePieces createPieces;
        if (this.color == PlayerColor.WHITE) {
            factory = new FactoryWhite();
            createPieces = new CreatePieces(factory);
            pieces = createPieces.getListPieces();
            } else {
            factory = new FactoryBlack();
            createPieces = new CreatePieces(factory);
            pieces = createPieces.getListPieces();
        }
    }

    public Piece getRandomPiece() {
        Random random = new Random();
        return pieces.get(random.nextInt(pieces.size()));
    }

    public void checkAlivePieces(ArrayList<Piece> deleted) {
        for (int i = 0; i < pieces.size(); i++) {
            if (deleted.contains(pieces.get(i))) {
                pieces.remove(i);
            }
        }
    }

}
