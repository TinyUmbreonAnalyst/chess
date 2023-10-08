package chess;


public class Board implements ChessBoard{

    private ChessPiece[][] board;

    public Board(){
        board = new ChessPiece[8][8];
    }

    public Board(Board other) {
        board = new ChessPiece[8][8];
        if(other.board == null){
            board = null;
        }
        for (int i = 1; i < 9; ++i){
            for(int j = 1; j < 9; ++j){
                ChessPosition pos = new Position(i,j);
                board[i-1][j-1] = other.getPiece(pos);
            }
        }
    }
    @Override
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board[position.getRow()-1][position.getColumn()-1] = piece;
    }

    public void removePiece(ChessPosition position) {
        board[position.getRow()-1][position.getColumn()-1] = null;
    }

    @Override
    public ChessPiece getPiece(ChessPosition position) {
        return board[position.getRow()-1][position.getColumn()-1];
    }

    @Override
    public void resetBoard() {
        for (int i = 1; i < 9; ++i){
            for (int j = 1; j < 9; ++j) {
                ChessPosition p = new Position(i, j);
                removePiece(p);
                ChessPiece piece = initPiece(p);
                if (piece != null) {
                    addPiece(p, piece);
                }
            }
        }
    }

    private ChessPiece initPiece(ChessPosition position){
        ChessPiece piece;
        if(position.getRow() <= 2) {
            if (position.getRow() == 1){
                piece = initPiece(position.getColumn(), ChessGame.TeamColor.WHITE);
            }
            else piece = new Pawn(ChessGame.TeamColor.WHITE);
        }
        else if (position.getRow() >= 7) {
            if (position.getRow() == 8){
                piece = initPiece(position.getColumn(), ChessGame.TeamColor.BLACK);
            }
            else piece = new Pawn(ChessGame.TeamColor.BLACK);
        }
        else {
            return null;
        }
        return piece;

    }

    private ChessPiece initPiece(int column, ChessGame.TeamColor color) {
        switch (column) {
            case 1, 8 -> {
                return new Rook(color);
            }
            case 2, 7 -> {
                return new Knight(color);
            }
            case 3, 6 -> {
                return new Bishop(color);
            }
            case 4 ->{
                return new Queen(color);
            }
            case 5 ->{
                return new King(color);
            }
            default -> {
                return null;
            }
        }
    }
}
