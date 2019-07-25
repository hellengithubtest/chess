package com.company.app.models;

import com.company.app.Board;
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

        for (int i = 0; i < available.size(); i++) {
            int nextX = available.get(i).getX();
            int nextY = available.get(i).getY();
            while (!board.isNotWithinTheBorders(nextX, nextY) && board.getBoardPieces()[nextX][nextY] == null) {
                valid.add(new Cell(nextX, nextY));
                int diffX = rookX - available.get(i).getX();
                int diffY = rookY - available.get(i).getY();
                nextX = nextX - diffX;
                nextY = nextY - diffY;
            }
            if (board.isNotWithinTheBorders(nextX, nextY)) {
                continue;
            } else if (board.getBoardPieces()[nextX][nextY].getColor() == getColor() || board.getBoardPieces()[nextX][nextY].getClass().getSimpleName().equals("King")) {
                continue;
            } else {
                valid.add(new Cell(nextX, nextY));
            }
        }
        return valid;
    }

    public String toString() {
        return "R " + this.getColor();
    }

}
