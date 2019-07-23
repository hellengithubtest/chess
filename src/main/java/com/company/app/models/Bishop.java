package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Cell cell, PlayerColor color) {

        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {

        int condition1 = Math.abs(getCurrentCell().getX() - cell.getX());
        int condition2 = Math.abs(getCurrentCell().getY() - cell.getY());
        return condition1 == condition2 ? true : false;
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
        return "B " + this.color;
    }
}
