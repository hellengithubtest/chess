package com.company.app.factory;

import com.company.app.Cell;
import com.company.app.PlayerColor;
import com.company.app.models.*;
import java.util.ArrayList;
import java.util.List;

public class CreateSetOfPieces implements FactorySet {
    int yWhite = 0;
    int yPawnWhite = 1;

    int yBlack = 7;
    int yPawnBlack = 6;

    public List<Piece> createSet(PlayerColor color) {
        List<Piece> resultSet = new ArrayList<Piece>();

        int y = color == PlayerColor.WHITE ? yWhite : yBlack;
        int yPawn = color == PlayerColor.WHITE ? yPawnWhite : yPawnBlack;

        for (int i = 0; i < 8; i++) {
            resultSet.add(new Pawn(new Cell(i, yPawn), color));
        }
        resultSet.add(new Rook( new Cell(0, y), color));
        resultSet.add(new Rook(new Cell(7, y), color));
        resultSet.add(new Knight( new Cell(1, y), color));
        resultSet.add(new Knight(new Cell(6, y), color));
        resultSet.add(new Bishop(new Cell(2, y), color));
        resultSet.add(new Bishop(new Cell(5, y), color));
        resultSet.add(new Queen(new Cell(3, y), color));
        resultSet.add(new King(new Cell(4, y), color));
        return resultSet;
    }
}
