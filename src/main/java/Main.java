public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(board);
        Player player2 = new Player(board);
        ChessGame newGame = new ChessGame(player1, player2);
    }
}
