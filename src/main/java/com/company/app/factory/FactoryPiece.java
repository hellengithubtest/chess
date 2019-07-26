package com.company.app.factory;

import com.company.app.models.*;

public interface FactoryPiece {
    Bishop createBishop();
    King createKing();
    Knight createKnight();
    Pawn createPawn();
    Queen createQueen();
    Rook createRook();
}
