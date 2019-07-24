package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private Cell currentCell;
    public PlayerColor color;

    public Piece(Cell currentCell, PlayerColor color) {
       super();
       this.currentCell = currentCell;
       this.color = color;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell nextCell) {
        this.currentCell = nextCell;
    }
    public boolean isValid(Cell cell) {
        return true;
    }
    public PlayerColor getColor() {
        return this.color;
    }

    public boolean isOpponent(Piece piece) {
        return piece != null && this.color != piece.color;
    }
    public List<Cell> getAvailableMoves(List<Cell> allCell) {
        ArrayList<Cell> availableMoves = new ArrayList<Cell>();
        int size = allCell.size();
        for (int i = 0; i < size; i++) {
            if(isValid(allCell.get(i))){
                availableMoves.add(allCell.get(i));
            }else {
                continue;
            }
        }

        return availableMoves;
    }

    public String toString() {
        return "Current cell: " + currentCell + " Color: " + color;
    }
}
