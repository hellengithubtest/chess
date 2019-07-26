package com.company.app;

import com.company.app.models.Piece;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int WIGHT = 8;
    private final int HEIGHT = 8;
    private Piece[][] boardPieces;
    private ArrayList<Piece> deletedPieces;
    private boolean win;
    private static Board instance;

    public Board() {
        win = false;
        this.boardPieces = new Piece[WIGHT][HEIGHT];
        this.deletedPieces = new ArrayList<Piece>();
    }

    public boolean getWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    public Piece[][] getBoardPieces() {
        return boardPieces;
    }

    public void putAllPiecesFromPlayer(Player player) {
        for (Piece piece : player.getPieces()) {
            boardPieces[piece.getCurrentCell().getX()][piece.getCurrentCell().getY()] = piece;
        }
    }

    public boolean isNotWithinTheBorders(int x, int y) {
        boolean cond1 = (x >= HEIGHT | x < 0);
        boolean cond2 = (y >= HEIGHT | y < 0);
        return cond1 | cond2;
    }

    public ArrayList<Piece> getDeletedPieces() {
        return deletedPieces;
    }

    public void executeMove(Piece piece, Cell nextCell) {
        if (boardPieces[nextCell.getX()][nextCell.getY()] != null) {
            deletedPieces.add(boardPieces[nextCell.getX()][nextCell.getY()]);
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
            releaseCell(piece);
            piece.setCurrentCell(nextCell);

        } else {
            //System.out.println("The cell is free, we can move");
            releaseCell(piece);
            piece.setCurrentCell(nextCell);
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
        }
        printBoard();
    }

    public void releaseCell(Piece piece) {
        boardPieces[piece.getCurrentCell().getX()][piece.getCurrentCell().getY()] = null;
    }

    public boolean isAliveKing(PlayerColor color) {
        for (int x = 0; x < WIGHT; x++){
            for (int y = 0; y < HEIGHT; y++){
                if(boardPieces[x][y] == null){
                    continue;
                }else {
                    if(boardPieces[x][y].getClass().getSimpleName().equals("King") & boardPieces[x][y].getColor() == color){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int y = boardPieces.length - 1; y >= 0; y--) {
            for (int x = 0; x < boardPieces.length * 11; x++) {
                if (x % 11 == 0) {
                    System.out.print("|");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < boardPieces.length * 11; x++) {
                if (x % 11 == 0) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < boardPieces.length; x++) {
                if (x == 0) {
                    System.out.print(y);
                }

                if (boardPieces[x][y] == null) {
                    System.out.print("  " + "       " + " |");
                } else {
                    System.out.print("  " + boardPieces[x][y] + " |");
                }
            }
            System.out.println();
            if (y == 0) {
                for (int x = 0; x < boardPieces.length * 11; x++) {
                    if (x % 11 == 0) {
                        System.out.print("|");
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.println("|");
                for (int x = 0; x < boardPieces.length; x++) {
                    System.out.print("      ");
                    System.out.print(x);
                    System.out.print("    ");

                }
                System.out.println();
                System.out.println(" The pieces is out of game: " + deletedPieces);
            }

        }
    }
}
