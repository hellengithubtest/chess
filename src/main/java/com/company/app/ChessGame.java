package com.company.app;

import com.company.app.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChessGame {
        private final Board board;
        private Player player1;
        private Player player2;

        public ChessGame(Board board, Player player1, Player player2) {
            this.board = board;
            this.player1 = player1;
            this.player2 = player2;
        }

        public void processTurn(Player player) {
            Random random = new Random();

            player.checkPieces(board.getDeletedPeaces());
            int count = player.getPieces().size();
            List<Cell> availableAround = new ArrayList<Cell>();
            List<Cell> validSteps = new ArrayList<Cell>();
            Piece randomPiece = null;


            do {
                randomPiece = player.getRandomPiece();

                System.out.println("Random piece " + randomPiece + " " + randomPiece.getCurrentCell());

                availableAround = board.getSquareAround(randomPiece);

                System.out.println("available around " + availableAround);

                validSteps = randomPiece.getAvailableMoves(availableAround);
                System.out.println("valid steps " + validSteps);
                count--;

            } while (count > 0 & validSteps.size() == 0);

            if(count <= 0 & validSteps.size() == 0){
                board.setWin(true); //
            } else {
                Cell nextCell = validSteps.get(random.nextInt(validSteps.size()));
                board.executeMove(randomPiece, nextCell);
                System.out.println("The piece " + randomPiece + " Move to " + nextCell);
            }

        }

        public void startGame() {
            while (true) {
                processTurn(player1);
                if(this.board.getWin()) {
                    System.out.println("Player 1 is win");
                    break;
                }
                processTurn(player2);
                if(this.board.getWin()) {
                    System.out.println("Player 2 is win");
                    break;
                }
            }

        }
    }
