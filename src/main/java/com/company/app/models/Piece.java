package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.Player;
import com.company.app.PlayerColor;

import java.util.ArrayList;

public class Piece {
    private Cell currentCell;
    protected ArrayList<Cell> availableMoves;
    private boolean available;
    public PlayerColor color;

    public Piece(boolean available, Cell currentCell, PlayerColor color){
       super();
       this.available = available;
       this.currentCell = currentCell;
       this.color = color;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        return true;
    }

    public boolean validMoves() {
        return true;
    }
    public PlayerColor getColor() {
        return this.color;
    }
    public ArrayList<Cell> getAvailableMoves() {
        return availableMoves;
    }
}
