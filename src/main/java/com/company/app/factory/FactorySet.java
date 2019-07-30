package com.company.app.factory;

import com.company.app.PlayerColor;
import com.company.app.models.Piece;

import java.util.List;

public interface FactorySet {
    List<Piece> createSet(PlayerColor color);
}
