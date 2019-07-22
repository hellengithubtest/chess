package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.Player;
import com.company.app.PlayerColor;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(boolean available, Cell cell, PlayerColor color) {

        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        int condition1 = Math.abs(fromX - toX);
        int condition2 = Math.abs(fromY - toY);
        return condition1 == condition2 ? true : false;
    }

    @Override
    public ArrayList<Cell> getAvailableMoves() {

        return super.getAvailableMoves();
    }
}
