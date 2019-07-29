package com.company.app.observer;

import com.company.app.models.Piece;

import java.util.List;

public interface Observer {
    void update(List<Piece> deletedItems);
}
