package com.company.app;

public class ChessGame {
        private final Board board;
        private Player[] players;
        private PlayerColor color = PlayerColor.WHITE;

        public ChessGame(Board board, Player[] players) {
            this.board = board;
            this.players = players;
        }
    }
