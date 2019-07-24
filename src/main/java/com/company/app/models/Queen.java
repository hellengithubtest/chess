package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Queen extends Piece {

    public Queen(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {
        boolean condition1 = (getCurrentCell().getX() == cell.getX() || getCurrentCell().getY() == cell.getY());
        boolean condition2 = (Math.abs(getCurrentCell().getX() - cell.getX()) == Math.abs(getCurrentCell().getY() - cell.getY()));
        return condition1 || condition2;
    }

/*    public List<Cell> getAvailableMoves(List<Cell> allCell) {
        for (int i = 0; i < allCell.size(); i++) {
            if(isValid(allCell.get(i))){
                continue;
            }else {
                allCell.remove(i);
            }
            return allCell;
        }
        return availableMoves;
    }*/

    public String toString() {
        return "Q " + this.color;
    }
}
