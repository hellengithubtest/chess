package com.company.app;

import com.company.app.models.Piece;

public class Board {
    public final int WIGHT = 8;
    public final int HEGHT = 8;
    private static Board instance;
    private Piece[][] boardPieces;
    private boolean win;

    public Board(Piece[][] boardPieces) {
        win = false;
        this.boardPieces = boardPieces;
    }

    public boolean getWin() {
        return this.win;
    }

    public boolean isValidBorders(int x, int y) {
        return (x >= 0 && x < this.WIGHT && y >= 0 && y <  this.WIGHT);
    }

    public Piece getPieceAt(int x, int y) {
        return boardPieces[x][y];
    }
}
