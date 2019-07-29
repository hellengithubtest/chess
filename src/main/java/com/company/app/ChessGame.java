package com.company.app;

import com.company.app.models.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChessGame {
        private Board board;
        private Player player1;
        private Player player2;


        public boolean processTurn(Player player) {
            Random random = new Random();
            if(!board.isAliveKing(player.getColor())) {
                board.setWin(true);
                return true;
            }
            board.printBoard();
            int count = player.getPieces().size();

            List<Cell> validSteps = new ArrayList<Cell>();
            Piece randomPiece = null;

            while(count != 0){
                randomPiece = player.getRandomPiece();
                validSteps = randomPiece.availableMoves(board);
                while (validSteps.size() != 0){
                    System.out.println(validSteps.size());
                    Cell nextCell = validSteps.get(random.nextInt(validSteps.size()));
                    System.out.println("Random piece " + randomPiece + " " + randomPiece.getCurrentCell() + " valid steps " + validSteps);
                    board.executeMove(randomPiece, nextCell);
                    System.out.println("The piece " + randomPiece + " Move to " + nextCell);
                    return true;
                }

            }
            board.setWin(true);
            return true;
        }

        public void startGame() {
            while (true) {
                processTurn(player1);
                if (this.board.getWin()) {
                    System.out.println("Player 2 is win");
                    break;
                    }
                processTurn(player2);
                if (this.board.getWin()) {
                    System.out.println("Player 1 is win");
                    break;
                }
            }
        }

        public void initializeGame() {
            player1 = new Player(PlayerColor.WHITE);
            player2 = new Player(PlayerColor.BLACK);

            board = new Board();
            board.registerObserver(player1);
            board.registerObserver(player2);

            board.putAllPiecesFromPlayer(player1);
            System.out.println(player1.getPieces());

            board.putAllPiecesFromPlayer(player2);
            System.out.println(player2.getPieces());

            board.printBoard();
        }

        public PlayerColor getAnotherColor(PlayerColor color) {
            if (color == player1.getColor()) {
                return player2.getColor();
            } else {
                return player1.getColor();
            }
        }
    }
