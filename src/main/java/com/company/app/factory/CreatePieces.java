package com.company.app.factory;

import com.company.app.models.Piece;

import java.util.ArrayList;
import java.util.List;

public class CreatePieces {
    private final int COUNT_OF_PAWNS = 8;
    private final int COUNT_IN_PAIR = 2;

    List<Piece> listPieces = new ArrayList<Piece>();

    public CreatePieces (FactoryPiece factoryPiece) {
        for (int i = 0; i < COUNT_OF_PAWNS; i++) {
            listPieces.add(factoryPiece.createPawn());
        }
        for (int i = 0; i < COUNT_IN_PAIR; i++) {
            listPieces.add(factoryPiece.createBishop());
            listPieces.add(factoryPiece.createKnight());
            listPieces.add(factoryPiece.createRook());
        }
        listPieces.add(factoryPiece.createKing());
        listPieces.add(factoryPiece.createQueen());
    }
    public List<Piece> getListPieces() {
        return this.listPieces;
    }
}
