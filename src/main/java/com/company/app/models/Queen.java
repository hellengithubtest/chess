package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Queen extends Piece {

    public Queen(boolean available, Cell cell, PlayerColor color) {
        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        boolean condition1 = (fromX == toX || fromY == toY);
        boolean condition2 = (Math.abs(fromX - toX) == Math.abs(fromY - toY));
        return condition1 || condition2;
    }

}
