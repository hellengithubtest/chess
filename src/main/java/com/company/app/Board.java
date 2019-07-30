package com.company.app;

import com.company.app.models.King;
import com.company.app.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int WIGHT = 8;
    private final int HEIGHT = 8;
    private Piece[][] boardPieces;

    public Board() {
        this.boardPieces = new Piece[WIGHT][HEIGHT];
    }

    public Piece[][] getBoardPieces() {
        return boardPieces;
    }

    public List<Piece> getAvailablePieces(PlayerColor color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (int x = 0; x < WIGHT; x++){
            for (int y = 0; y < HEIGHT; y++){
                if(boardPieces[x][y] == null){
                    continue;
                }else {
                    if(boardPieces[x][y].getColor() == color){
                        pieces.add(boardPieces[x][y]);
                    }
                }
            }
        }
        return pieces;
    }

    public Piece getRandomPiece(PlayerColor color) {
        Random random = new Random();
        List<Piece> pieces = getAvailablePieces(color);
        return pieces.get(random.nextInt(pieces.size()));
    }

    public boolean isNotWithinTheBorders(int x, int y) {
        boolean cond1 = (x >= HEIGHT | x < 0);
        boolean cond2 = (y >= HEIGHT | y < 0);
        return cond1 | cond2;
    }

    public void executeMove(Piece piece, Cell nextCell) {
        if (boardPieces[nextCell.getX()][nextCell.getY()] != null) {
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
        }
        releaseCell(piece);
        piece.setCurrentCell(nextCell);
        boardPieces[nextCell.getX()][nextCell.getY()] = piece;

        printBoard();
    }

    public void releaseCell(Piece piece) {
        boardPieces[piece.getCurrentCell().getX()][piece.getCurrentCell().getY()] = null;
    }

    public boolean isKingAlive(PlayerColor color) {
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
            }

        }
    }
    /*public void printBoard() {
        for (int y = boardPieces.length - 1; y >= 0; y--) {

            for (int x = 0; x < boardPieces.length * 6; x++) {
                if (x % 6 == 0) {
                    System.out.print("|");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < boardPieces.length * 6; x++) {
                if (x % 6 == 0) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < HEIGHT; x++) {

                if (boardPieces[x][y] == null) {
                    System.out.print("|     ");
                } else {
                    System.out.print("|  " + boardPieces[x][y] + "  ");
                }
                if (x == 7) {
                    System.out.println( y );
                    if (y == 0) {
                        System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|");
                        System.out.println("|  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |");
                    }
                }
            }
        }
    }*/
}
