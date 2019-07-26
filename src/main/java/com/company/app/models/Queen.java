package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public final class Queen extends Piece {

    public Queen(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public List<Cell> availableMoves(Board board) {
        List<Cell> available = new ArrayList<Cell>();
        List<Cell> valid = new ArrayList<Cell>();

        int queenX = this.getCurrentCell().getX();
        int queenY = this.getCurrentCell().getY();

        available.add(new Cell(this.getCurrentCell().getX() + 1, this.getCurrentCell().getY()));
        available.add(new Cell(this.getCurrentCell().getX() - 1, this.getCurrentCell().getY()));
        available.add(new Cell(this.getCurrentCell().getX(), this.getCurrentCell().getY() + 1));
        available.add(new Cell(this.getCurrentCell().getX(), this.getCurrentCell().getY() - 1));

        available.add(new Cell(this.getCurrentCell().getX() + 1, this.getCurrentCell().getY() + 1));
        available.add(new Cell(this.getCurrentCell().getX() - 1, this.getCurrentCell().getY() + 1));
        available.add(new Cell(this.getCurrentCell().getX() - 1, this.getCurrentCell().getY() - 1));
        available.add(new Cell(this.getCurrentCell().getX() + 1, this.getCurrentCell().getY() - 1));


        for (Cell cell : available) {
            int nextX = cell.getX();
            int nextY = cell.getY();
            while (!board.isNotWithinTheBorders(nextX, nextY) && board.getBoardPieces()[nextX][nextY] == null) {
                valid.add(new Cell(nextX, nextY));
                int diffX = queenX - cell.getX();
                int diffY = queenY - cell.getY();
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
        return "Q " + this.getColor();
    }
}
