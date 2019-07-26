package com.company.app.factory;

import com.company.app.Cell;
import com.company.app.PlayerColor;
import com.company.app.models.*;

import java.util.Stack;

public class FactoryBlack implements FactoryPiece {
    PlayerColor color = PlayerColor.BLACK;
    Stack <Cell> cellsBishop = new Stack<Cell>();
    Stack <Cell> cellsKnight = new Stack<Cell>();
    Stack <Cell> cellsPawn = new Stack<Cell>();
    Stack <Cell> cellsRook = new Stack<Cell>();

    int yFirstPosition = 7;
    int yPawnFirstPosition = 6;

    public FactoryBlack() {
        cellsBishop.push(new Cell(2 , yFirstPosition));
        cellsBishop.push(new Cell(5 ,yFirstPosition));
        cellsKnight.push(new Cell(1 ,yFirstPosition));
        cellsKnight.push(new Cell(6 ,yFirstPosition));
        cellsPawn.push(new Cell(0 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(1 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(2 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(3 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(4 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(5 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(6 ,yPawnFirstPosition));
        cellsPawn.push(new Cell(7 ,yPawnFirstPosition));
        cellsRook.push(new Cell(0 ,yFirstPosition));
        cellsRook.push(new Cell(7 ,yFirstPosition));
    }

    public Bishop createBishop() {
        return new Bishop(cellsBishop.pop(), color);
    }

    public King createKing() {
        return new King(new Cell(4, yFirstPosition), color);
    }

    public Knight createKnight() {
        return new Knight(cellsKnight.pop(), color);
    }

    public Pawn createPawn() {
        return new Pawn(cellsPawn.pop(), color);
    }

    public Queen createQueen() {
        return new Queen(new Cell(3, yFirstPosition), color);
    }

    public Rook createRook() {
        return new Rook(cellsRook.pop(), color);
    }
}