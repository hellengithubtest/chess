package com.company.app.models;

import com.company.app.observer.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public final class Rook extends Piece {

    public Rook(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public List<Cell> availableMoves(Board board) {
        List<Cell> available = new ArrayList<Cell>();
        List<Cell> valid = new ArrayList<Cell>();

        int rookX = this.getCurrentCell().getX();
        int rookY = this.getCurrentCell().getY();

        available.add(new Cell(rookX + 1, rookY));
        available.add(new Cell(rookX - 1, rookY));
        available.add(new Cell(rookX, rookY + 1));
        available.add(new Cell(rookX, rookY - 1));

        for (Cell cell : available) {
            int nextX = cell.getX();
            int nextY = cell.getY();
            while (!board.isNotWithinTheBorders(nextX, nextY) && board.getBoardPieces()[nextX][nextY] == null) {
                valid.add(new Cell(nextX, nextY));
                int diffX = rookX - cell.getX();
                int diffY = rookY - cell.getY();
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
        if(this.getColor() == PlayerColor.WHITE){
            return "♖";
        } else {
            return "♜";
        }
        //return "R " + this.getColor();
    }
}
