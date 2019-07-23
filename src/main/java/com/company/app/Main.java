package com.company.app;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(PlayerColor.WHITE);
        Player player2 = new Player(PlayerColor.BLACK);

        Board board = new Board();
        board.initialize(player1);
        board.initialize(player2);

        System.out.println("Pieces for first player" + player1.getPieces());
        System.out.println("Pieces for first player" + player2.getPieces());
        System.out.println("Board" + board);
        board.print();

        ChessGame game = new ChessGame(board, player1, player2);
        game.startGame();
    }
}
