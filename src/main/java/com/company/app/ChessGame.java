package com.company.app;

import com.company.app.factory.CreateSetOfPieces;
import com.company.app.factory.FactorySet;
import com.company.app.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChessGame {
        private Board board;

        public void processTurn(PlayerColor color) {
            Random random = new Random();
            List<Cell> validSteps = new ArrayList<Cell>();
            Piece randomPiece = null;

            while(board.getAvailablePieces(color) != null){
                randomPiece = board.getRandomPiece(color);
                validSteps = randomPiece.availableMoves(board);
                while (validSteps.size() != 0){
                    System.out.println(validSteps.size());
                    Cell nextCell = validSteps.get(random.nextInt(validSteps.size()));
                    System.out.println("Random piece " + randomPiece + " " + randomPiece.getCurrentCell() + " valid steps " + validSteps);
                    board.executeMove(randomPiece, nextCell);
                    System.out.println("The piece " + randomPiece + " Move to " + nextCell);
                    return;
                }

            }
            return;
        }

        public void startGame() {
            PlayerColor color = PlayerColor.WHITE;
            processTurn(color);
            while (true) {
                color = getOpponentColor(color);
                processTurn(color);
                if (isGameContinue(color)) {
                    continue;
                } else {
                    break;
                }
            }
        }

        public void initializeGame() {
            FactorySet factorySet = new CreateSetOfPieces();
            board = new Board();
            board.loadSetOfPieces(factorySet.createSet(PlayerColor.WHITE));
            board.loadSetOfPieces(factorySet.createSet(PlayerColor.BLACK));

            board.printBoard();
        }

        public boolean isGameContinue(PlayerColor color) {
            //if king of opponent is removed and if the opponent haven't available pieces
            if (!board.isKingAlive(getOpponentColor(color)) || board.getAvailablePieces(getOpponentColor(color)).size() == 0) {
                System.out.println("The " + color + " is win");
                return false;
            } else if (board.getAvailablePieces(getOpponentColor(color)).size() == 1){
                //if the available pieces is one
                //check if the piece is can move
                return board.getRandomPiece(getOpponentColor(color)).availableMoves(board).size() >= 1 ? true : false;
            } else {
                return true;
            }
        }

        public PlayerColor getOpponentColor(PlayerColor color) {
            return color == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
        }
    }
