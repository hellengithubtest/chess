package com.company.app.builder;

import com.company.app.PlayerColor;
import com.company.app.models.*;
import java.util.ArrayList;
import java.util.List;

class CreateSetOfPieces implements FactorySet {
    int yWhite = 0;
    int yPawnWhite = 1;

    int yBlack = 7;
    int yPawnBlack = 6;

    public CreateSetOfPieces(PlayerColor color) {
        createSet(color);
    }

    public void createSet(PlayerColor color) {
        List<Piece> resultSet = new ArrayList<Piece>();


    }
}
