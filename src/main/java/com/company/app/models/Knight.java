package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.List;

public class Knight extends Piece {

    public Knight(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {
        double condition = Math.pow((getCurrentCell().getX() - cell.getX()), 2.0) + Math.pow((getCurrentCell().getY() - cell.getY()), 2.0);
        return condition == 5;
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
        return "K " + this.color;
    }
}
