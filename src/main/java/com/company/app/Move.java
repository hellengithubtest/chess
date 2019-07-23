package com.company.app;
import com.company.app.models.Piece;

public class Move {
    Piece piece;
    Cell cell;

    public Move(Piece piece, Cell cell) {
        this.piece = piece;
        this.cell = cell;
    }

/*    public Move getRandomMove(Board board, PlayerColor color, List<Piece> lisOfPieces) {
        Random random = new Random();

        List<Piece> piecesCanMove = this.getMovablePieces(lisOfPieces);
        int choice = random.nextInt(piecesCanMove.size());
        Piece selectedPiece = piecesCanMove.get(choice);

        List<Cell> moves = selectedPiece.getAvailableMoves();
        Cell cell = moves.get(random.nextInt(moves.size()));
        return new Move(selectedPiece, cell);
    }*/

 /*   public List<Piece> getMovablePieces(List<Piece> listOfPieces) {
        ArrayList<Piece> piecesCanMove = new ArrayList<Piece>();
        for(Piece p : listOfPieces){
            if (p.getCurrentCell())
        }
    }*/
}
