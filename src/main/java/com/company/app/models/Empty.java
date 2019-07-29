package com.company.app.models;

import com.company.app.Cell;
import com.company.app.PlayerColor;
import com.company.app.Board;

import java.util.List;

public class Empty extends Piece {
    public Empty(Cell currentCell, PlayerColor color) {
        super(currentCell, color);
    }

    public List<Cell> availableMoves(Board board) {
        return null;
    }
}
