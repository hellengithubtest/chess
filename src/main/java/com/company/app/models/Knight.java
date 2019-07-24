package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Knight extends Piece {

    public Knight(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {
        boolean condition1 = Math.abs(getCurrentCell().getX() - cell.getX()) == 1  & Math.abs(getCurrentCell().getY() - cell.getY()) == 2;
        boolean condition2 = Math.abs(getCurrentCell().getX() - cell.getX()) == 2  & Math.abs(getCurrentCell().getY() - cell.getY()) == 1;
        return condition1 || condition2;
    }
    /*
    can leap over
     */

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
        return "H " + this.color;
    }
}
