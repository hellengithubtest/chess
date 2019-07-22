package com.company.app.models;

import com.company.app.Board;
import com.company.app.Cell;
import com.company.app.PlayerColor;

public class Knight extends Piece {

    public Knight(boolean available, Cell cell, PlayerColor color) {
        super(available, cell, color);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        double condition = Math.pow((fromX - toX), 2.0) + Math.pow((fromY - toY), 2.0);
        return condition == 5;
    }

}
