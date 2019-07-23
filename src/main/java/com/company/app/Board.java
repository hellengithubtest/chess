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

    public void initialize(Player player){
        for(int i = 0; i < player.getPieces().size(); i++) {
            boardPieces[player.getPieces().get(i).getCurrentCell().getX()][player.getPieces().get(i).getCurrentCell().getY()] = player.getPieces().get(i);
        }
    }

    public boolean getWin() {
        return this.win;
    }

    public List<Cell> getListOfOther(PlayerColor color) {
        List<Cell> listOfOther = new ArrayList<Cell>();
        for (int y = 0; y < WIGHT; y++){
            for (int x = 0; x < HEIGHT; x++){
                if(boardPieces[x][y] == null || boardPieces[x][y].color != color){
                    listOfOther.add(new Cell( x, y));
                }
            }
        }
        return listOfOther;
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
        if(boardPieces[nextCell.getX()][nextCell.getY()] != null){
            System.out.println("The cell is occuped by:" + boardPieces[nextCell.getX()][nextCell.getY()]);
            deletedPeaces.add(boardPieces[nextCell.getX()][nextCell.getY()]);
            releaseCell(boardPieces[nextCell.getX()][nextCell.getY()]);
            releaseCell(piece);
            piece.setCurrentCell(nextCell);

        }else {
            System.out.println("The cell is free, we can move");
            releaseCell(piece);
            piece.setCurrentCell(nextCell);
            boardPieces[nextCell.getX()][nextCell.getY()] = piece;
        }
    }

    public void releaseCell(Piece piece) {
        boardPieces[piece.getCurrentCell().getX()][piece.getCurrentCell().getY()] = null;
    }

    public List<Cell> getSquareAround(Piece piece) {
        int[] xOffsets = {-1, 1};
        int[] yOffsets = {-1, 1};
        List<Cell> listSquare = new ArrayList<Cell>();
        for (int i = 0; i < xOffsets.length; i++){

        }
        return listSquare;
    }

    public void print() {
        for (int y = boardPieces.length -1; y >= 0 ; y--){
            for (int x = 0; x < boardPieces.length; x++) {
                System.out.print("  " + boardPieces[x][y]);
                if(x == 7){
                    System.out.println(" ");
                }
            }
        }
    }
}
