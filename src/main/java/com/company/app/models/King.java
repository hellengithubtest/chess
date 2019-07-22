package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

public class King extends Piece {

    public King(boolean available, Cell cell, PlayerColor color) {
        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        boolean condition1 = Math.abs(fromX - toX ) <= 1;
        boolean condition2 = Math.abs(fromY - toY ) <= 1;

        return condition1 && condition2;
    }

}
