package com.company.app;

import com.company.app.factory.FactoryBlack;
import com.company.app.factory.FactoryPiece;
import com.company.app.factory.FactoryWhite;
import com.company.app.models.*;

public class Player implements PlayerI{
    private final PlayerColor color;

    public Player(PlayerColor color) {
        this.color = color;
    }

    public PlayerColor getColor() {
        return this.color;
    }

    public void createPieces (Board board) {
        int COUNT_OF_PAWNS = 8;
        int COUNT_IN_PAIR = 2;

        FactoryPiece factoryPiece = this.color == PlayerColor.WHITE ? new FactoryWhite() : new FactoryBlack();

        for (int i = 0; i < COUNT_OF_PAWNS; i++) {
            Piece pawn = factoryPiece.createPawn();
            board.getBoardPieces()[pawn.getCurrentCell().getX()][pawn.getCurrentCell().getY()] = pawn;
        }
        for (int i = 0; i < COUNT_IN_PAIR; i++) {
            Piece bishop = factoryPiece.createBishop();
            board.getBoardPieces()[bishop.getCurrentCell().getX()][bishop.getCurrentCell().getY()] = bishop;
            Piece knight = factoryPiece.createKnight();
            board.getBoardPieces()[knight.getCurrentCell().getX()][knight.getCurrentCell().getY()] = knight;
            Piece rook = factoryPiece.createRook();
            board.getBoardPieces()[rook.getCurrentCell().getX()][rook.getCurrentCell().getY()] = rook;
        }
        Piece king = factoryPiece.createKing();
        board.getBoardPieces()[king.getCurrentCell().getX()][king.getCurrentCell().getY()] = king;
        Piece queen = factoryPiece.createQueen();
        board.getBoardPieces()[queen.getCurrentCell().getX()][queen.getCurrentCell().getY()] = queen;
    }

    public PlayerColor getOpponentColor() {
        return this.color == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
    }
}
