package com.company.app;

import com.company.app.models.Piece;

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

            player.checkPieces(board.getDeletedPeaces());
            Random random = new Random();
            Piece randomPiece = player.getRandomPiece();
            List<Cell> validSteps = board.getSquareAround(randomPiece);
            if(validSteps.size() == 0) {
                System.out.println("the piece is blocked");
            }
            System.out.println("Random: " + randomPiece.getCurrentCell() + " ");
            System.out.println("List of valid: " + validSteps );
/*            player.checkPieces(board.getDeletedPeaces());
            List<Cell> validSteps = new ArrayList<Cell>();
            Random random = new Random();
            while(validSteps.isEmpty()) {
                List<Cell> allCell = board.getListOfOther(player.color);
                Piece randomPiece = player.getRandomPiece();
                Cell someCell = randomPiece.getCurrentCell();
                System.out.println("Current piece " + randomPiece + "coord" + randomPiece.getCurrentCell());
                validSteps = randomPiece.getAvailableMoves(allCell);
            }
            System.out.println("List of valid steps" + validSteps);
            Cell nextCell = validSteps.get(random.nextInt(validSteps.size()));*/



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
