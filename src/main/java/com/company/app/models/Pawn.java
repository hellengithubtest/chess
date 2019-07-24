package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Pawn extends Piece {

    public Pawn(Cell cell, PlayerColor color) {
        super(cell, color);
    }

    @Override
    public boolean isValid(Cell cell) {
        System.out.println("current x: " + getCurrentCell().getX());
        System.out.println("current y: " + getCurrentCell().getY());

        boolean condition1 = (getCurrentCell().getX() == cell.getX());
        boolean condition2 = (Math.abs(getCurrentCell().getY() - cell.getY()) <= 2);
        boolean condition3 =  (getCurrentCell().getY() == 2 && cell.getY() == getCurrentCell().getY() + 2);
        return condition1 && condition2;
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

        return "P " + this.color;
    }

}
