package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Rook extends Piece {

    public Rook(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {
        boolean condition1 = (getCurrentCell().getX() == cell.getX());
        boolean condition2 = (getCurrentCell().getY() == cell.getY());
        return condition1 || condition2;
    }

    //ArrayList<Cell> availableMoves =  new ArrayList<Cell>();
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
        return "R " + this.color;
    }

}
