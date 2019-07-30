package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public final class King extends Piece{

    public King(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public List<Cell> availableMoves(Board board) {
        int kingX = this.getCurrentCell().getX();
        int kingY = this.getCurrentCell().getY();

        List<Cell> available = new ArrayList<Cell>();
        List<Cell> valid = new ArrayList<Cell>();

        available.add(new Cell(kingX + 1, kingY));
        available.add(new Cell(kingX - 1, kingY));
        available.add(new Cell(kingX, kingY + 1));
        available.add(new Cell(kingX, kingY - 1));

        available.add(new Cell(kingX + 1, kingY + 1));
        available.add(new Cell(kingX - 1, kingY + 1));
        available.add(new Cell(kingX - 1, kingY - 1));
        available.add(new Cell(kingX + 1, kingY - 1));

        for (Cell cell : available) {
            int nextX = cell.getX();
            int nextY = cell.getY();
            while (!board.isNotWithinTheBorders(nextX, nextY) && board.getBoardPieces()[nextX][nextY] == null) {
                valid.add(cell);
                break;
            }
        }
        return valid;
    }

    public String toString() {
        if(this.getColor() == PlayerColor.WHITE){
            return "♔";
        } else {
            return "♚";
        }
        //return "K " + this.getColor();
    }
}
