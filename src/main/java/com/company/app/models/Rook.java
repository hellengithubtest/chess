package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(boolean available, Cell cell, PlayerColor color) {
        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        boolean condition1 = (fromX == toX);
        boolean condition2 = (fromY == toY);
        return condition1 || condition2;
    }

    //ArrayList<Cell> availableMoves =  new ArrayList<Cell>();
    public void calculateMoves(Board board) {
        Cell[] cells = new Cell[] {
                new Cell(-1, 2),
                new Cell(1, 2),
                new Cell(-2, 1),
                new Cell(2, 1),
                new Cell(-2, -1),
                new Cell(2, 1),
                new Cell(-1, -2),
                new Cell(1, -2),
        };
        for (Cell p: cells) {
            int x = p.getX() + getCurrentCell().getX();
            int y = p.getY() + getCurrentCell().getY();
            if(board.isValidBorders(x, y)){
                if(board.getPieceAt(x, y).getColor() != this.color) {
                    availableMoves.add(new Cell(x, y));
                }
            }
        }
        this.availableMoves = availableMoves;
    }

}
