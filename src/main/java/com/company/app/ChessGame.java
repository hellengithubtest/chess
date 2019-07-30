package com.company.app;

import com.company.app.models.Piece;
import com.company.app.models.PlayerI;
import sun.tracing.dtrace.DTraceProviderFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChessGame {
        private Board board;
        private Player player1;
        private Player player2;


        public void processTurn(Player player) {
            Random random = new Random();
            List<Cell> validSteps = new ArrayList<Cell>();
            Piece randomPiece = null;

            while(board.getAvailablePieces(player.getColor()) != null){
                randomPiece = board.getRandomPiece(player.getColor());
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
            Player player = player1;
            processTurn(player);
            while (true) {
                player = (player.getColor() == PlayerColor.WHITE ? player2 : player1);
                processTurn(player);
                if (isGameContinue(player)) {
                    continue;
                } else {
                    break;
                }
            }
        }

        public void initializeGame() {
            PlayerI player1 = new Player(PlayerColor.WHITE);
            PlayerI player2 = new Player(PlayerColor.BLACK);

            board = new Board();

            player1.createPieces(board);
            player2.createPieces(board);

            board.printBoard();
        }

        public boolean isGameContinue(Player player) {
            //if king of opponent is removed and if the opponent haven't available pieces
            if (!board.isKingAlive(player.getOpponentColor()) || board.getAvailablePieces(player.getOpponentColor()).size() == 0) {
                System.out.println("The " + player.getColor() + " is win");
                return false;
            } else if (board.getAvailablePieces(player.getOpponentColor()).size() == 1){
                //if the available pieces is one
                //check if the piece is can move
                return board.getRandomPiece(player.getOpponentColor()).availableMoves(board).size() >= 1 ? true : false;
            } else {
                return true;
            }
        }
    }
