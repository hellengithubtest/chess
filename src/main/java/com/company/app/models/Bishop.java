package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public final class Bishop extends Piece {

    public Bishop(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public List<Cell> availableMoves(Board board) {
        int bishopX = this.getCurrentCell().getX();
        int bishopY = this.getCurrentCell().getY();

        List<Cell> available = new ArrayList<Cell>();
        List<Cell> valid = new ArrayList<Cell>();

        /*
        get neighbour
         */
        available.add(new Cell(bishopX + 1, bishopY + 1));
        available.add(new Cell(bishopX - 1, bishopY + 1));
        available.add(new Cell(bishopX - 1, bishopY - 1));
        available.add(new Cell(bishopX + 1, bishopY - 1));

        for (Cell cell : available) {
            int nextX = cell.getX();
            int nextY = cell.getY();

            while (!board.isNotWithinTheBorders(nextX, nextY) && board.getBoardPieces()[nextX][nextY] == null) { //exp false
                valid.add(new Cell(nextX, nextY));
                int diffX = bishopX - cell.getX();
                int diffY = bishopY - cell.getY();
                nextX = nextX - diffX;
                nextY = nextY - diffY;
            }
            if (board.isNotWithinTheBorders(nextX, nextY)) {
                continue;
            } else if (board.getBoardPieces()[nextX][nextY].getColor() == getColor()) {
                continue;
            } else {
                valid.add(new Cell(nextX, nextY));
            }
        }
        return valid;
    }

    public String toString() {
/*        if(this.getColor() == PlayerColor.WHITE){
            return "♗";
        } else {
            return "♝";
        }*/
        return "B " + this.getColor();
    }
}
