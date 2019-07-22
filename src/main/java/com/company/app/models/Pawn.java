package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(boolean available, Cell cell, PlayerColor color) {
        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        boolean condition1 = (fromX == toX);
        boolean condition2 = (fromY >= 2 && toY == fromY + 1) || (fromY == 2 && toY == fromY + 2);
        return condition1 && condition2;
    }


}
