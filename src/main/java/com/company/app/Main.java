package com.company.app;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(PlayerColor.WHITE);
        Player player2 = new Player(PlayerColor.BLACK);

        System.out.println("Pieces for first player" + player1.getPieces());
    }
}
