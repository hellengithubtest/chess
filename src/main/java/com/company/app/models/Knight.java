package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public final class Knight extends Piece {

    public Knight(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public List<Cell> availableMoves(Board board) {
        List<Cell> available = new ArrayList<Cell>();
        List<Cell> valid = new ArrayList<Cell>();

        available.add(new Cell(this.getCurrentCell().getX() + 1, this.getCurrentCell().getY() + 2));
        available.add(new Cell(this.getCurrentCell().getX() + 2, this.getCurrentCell().getY() + 1));
        available.add(new Cell(this.getCurrentCell().getX() + 2, this.getCurrentCell().getY() - 1));
        available.add(new Cell(this.getCurrentCell().getX() + 1, this.getCurrentCell().getY() - 2));
        available.add(new Cell(this.getCurrentCell().getX() - 1, this.getCurrentCell().getY() - 2));
        available.add(new Cell(this.getCurrentCell().getX() - 2, this.getCurrentCell().getY() - 1));
        available.add(new Cell(this.getCurrentCell().getX() - 2, this.getCurrentCell().getY() + 1));
        available.add(new Cell(this.getCurrentCell().getX() - 1, this.getCurrentCell().getY() + 2));

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
/*        if(this.getColor() == PlayerColor.WHITE){
            return "♘";
        } else {
            return "♞";
        }*/
        return "H " + this.getColor();
    }
}
