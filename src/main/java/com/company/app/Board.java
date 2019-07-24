package com.company.app;

import com.company.app.models.Piece;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public final int WIGHT = 8;
    public final int HEIGHT = 8;
    private static Board instance;
    private Piece[][] boardPieces;
    private ArrayList<Piece> deletedPeaces;
    private boolean win;

    public Board() {
        win = false;
        this.boardPieces = new Piece[WIGHT][HEIGHT];
        this.deletedPeaces = new ArrayList<Piece>();
    }

    public void initialize(Player player) {
        for(int i = 0; i < player.getPieces().size(); i++) {
            boardPieces[player.getPieces().get(i).getCurrentCell().getX()][player.getPieces().get(i).getCurrentCell().getY()] = player.getPieces().get(i);
        }
    }

    public boolean getWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public ArrayList<Piece> getDeletedPeaces() {
        return deletedPeaces;
    }

    public Piece getPieceAt(int x, int y) {
        return boardPieces[x][y];
    }

    public void executeMove(Piece piece, Cell nextCell) {
        /*

         */
        if(boardPieces[nextCell.getX()][nextCell.getY()] != null) {
            System.out.println("The cell is occuped by:" + boardPieces[nextCell.getX()][nextCell.getY()]);
            deletedPeaces.add(boardPieces[nextCell.getX()][nextCell.getY()]);
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
            releaseCell(piece);
            piece.setCurrentCell(nextCell);

        }else {
            System.out.println("The cell is free, we can move");
            releaseCell(piece);
            piece.setCurrentCell(nextCell);
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
        }
        print();
    }

    public void releaseCell(Piece piece) {
        boardPieces[piece.getCurrentCell().getX()][piece.getCurrentCell().getY()] = null;
    }

    public boolean checkCheckMate(PlayerColor color) {
        boolean checkmate = false;
        Piece king = null;
        for (int x = 0; x < WIGHT; x++){
            for (int y = 0; y < HEIGHT; y++){
                if(boardPieces[x][y] == null){
                    continue;
                }else {
                    if(boardPieces[x][y].getClass().getSimpleName() == "King" & boardPieces[x][y].color == color){
                        king = boardPieces[x][y];
                    }
                }
            }
        }
        List<Cell> getAround = new ArrayList<Cell>();
        getAround = getSquareAround(king);
        if(getAround.size() == 0){
            return checkmate;
        }
        for(int i = 0; i < getAround.size(); i++) {
            if (boardPieces[getAround.get(i).getX()][getAround.get(i).getY()] != null){
                checkmate = true;
                return checkmate;
            }else {
                Cell posible = getAround.get(i);

                if (king.getCurrentCell().getX() == posible.getX()) {
                    int diff = king.getCurrentCell().getY() - posible.getY();
                    int nextY = king.getCurrentCell().getY() - diff;
                    while (boardPieces[posible.getX()][nextY] == null){
                        nextY = king.getCurrentCell().getY() - diff;
                        if (nextY > WIGHT){
                            return false;
                        }
                    }
                    if (boardPieces[posible.getX()][nextY].color == color){
                        return false;
                    }else if(boardPieces[posible.getX()][nextY].getClass().getSimpleName() == "Rook" || boardPieces[posible.getX()][nextY].getClass().getSimpleName() == "Queen"){
                        return true;
                    }
                }else if(king.getCurrentCell().getY() == posible.getY()){
                    int diff = king.getCurrentCell().getX() - posible.getX();
                    int nextX = king.getCurrentCell().getX() - diff;
                    while(boardPieces[nextX][posible.getX()] == null){
                        nextX = king.getCurrentCell().getX() - diff;
                        if(nextX > HEIGHT){
                            return false;
                        }
                    }
                    if(boardPieces[nextX][posible.getY()].color == color){
                        return false;
                    }else if(boardPieces[nextX][posible.getY()].getClass().getSimpleName() == "Rook" || boardPieces[nextX][posible.getY()].getClass().getSimpleName() == "Queen"){
                        return true;
                    }
                    return false;
                }//else if()
            }
        }
        return false;
    }


    public List<Cell> getSquareAround(Piece piece) {

        List<Cell> listAvailableAround = new ArrayList<Cell>();
        if (piece.getClass().getSimpleName() == "Knight") {
            //TODO Knight

        }else {
            int[] xOffsets = {-1, 0, 1};
            int[] yOffsets = {-1, 0, 1};
            for (int i = 0; i < xOffsets.length; i++) {
                for (int j = 0; j < yOffsets.length; j++) {
                    int coordX = piece.getCurrentCell().getX() + xOffsets[i];
                    int coordY = piece.getCurrentCell().getY() + yOffsets[j];

                    boolean isBoarded = (coordX < WIGHT & coordX >= 0) & (coordY < HEIGHT & coordY >= 0);

                    System.out.println("Is boarded: " + isBoarded);
                    System.out.println(" x " + (coordX) + " y " + (coordY));
                    if (isBoarded && boardPieces[coordX][coordY] == null) {
                        listAvailableAround.add(new Cell(coordX, coordY));
                    } else if (isBoarded && piece.color != boardPieces[coordX][coordY].color) {
                        listAvailableAround.add(new Cell(coordX, coordY));
                    } else {
                        continue;
                    }
                }
            }
        }
        return listAvailableAround;
    }

    public void print() {
        for (int y = boardPieces.length -1; y >= 0 ; y--) {
            for (int x = 0; x < boardPieces.length*11; x++) {
                if(x%11 == 0) {
                    System.out.print("|");
                }else {
                    System.out.print("_");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < boardPieces.length*11; x++) {
                if(x%11 == 0 ) {
                    System.out.print("|");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println("| ");
            for (int x = 0; x < boardPieces.length; x++) {
                if( x == 0 ){
                    System.out.print(y);
                }

                if (boardPieces[x][y] == null){
                    System.out.print("  " + "       " + " |");
                }else {
                    System.out.print("  " + boardPieces[x][y] + " |");
                }
            }
            System.out.println();
            if( y == 0) {
                for (int x = 0; x < boardPieces.length*11; x++) {
                    if(x%11 == 0) {
                        System.out.print("|");
                    }else {
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
}
