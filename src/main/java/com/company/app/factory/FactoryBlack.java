package com.company.app.factory;

import com.company.app.Cell;
import com.company.app.PlayerColor;
import com.company.app.models.*;

import java.util.Stack;

public class FactoryBlack implements FactoryPiece {
    PlayerColor color = PlayerColor.BLACK;
    int yFirstPosition = 7;
    int yPawnFirstPosition = 6;

    public Bishop createBishop() {
        Stack <Cell> cellsBishop = new Stack<Cell>();
        cellsBishop.push(new Cell(2 , yFirstPosition));
        cellsBishop.push(new Cell(5 ,yFirstPosition));
        return new Bishop(cellsBishop.pop(), color);
    }

    public King createKing() {
        return new King(new Cell(4, yFirstPosition), color);
    }

    public Knight createKnight() {
        Stack <Cell> cellsKnight = new Stack<Cell>();
        cellsKnight.push(new Cell(1 ,yFirstPosition));
        cellsKnight.push(new Cell(5 ,yFirstPosition));
        return new Knight(cellsKnight.pop(), color);
    }

    public Pawn createPawn() {
        Stack <Cell> cellsPawn = new Stack<Cell>();
        cellsPawn.push(new Cell(0 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(1 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(2 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(3 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(4 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(5 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(6 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(7 ,yPawnFirstPosition));
        return new Pawn(cellsPawn.pop(), color);
    }

    public Queen createQueen() {
        return new Queen(new Cell(3, yFirstPosition), color);
    }

    public Rook createRook() {
        Stack <Cell> cellsRook = new Stack<Cell>();
        cellsRook.push(new Cell(2 ,yFirstPosition));
        cellsRook.push(new Cell(5 ,yFirstPosition));
        return new Rook(cellsRook.pop(), color);
    }
}