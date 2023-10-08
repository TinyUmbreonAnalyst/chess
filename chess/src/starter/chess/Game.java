package chess;

import java.util.Collection;
import java.util.Vector;

public class Game implements ChessGame{
    private TeamColor turn;
    ChessBoard board;

    public Game() {
        board = new Board();
        board.resetBoard();
        turn = TeamColor.WHITE;
    }

    public Game(Game other) {
        board = other.board;
        turn = other.turn;
    }
    @Override
    public TeamColor getTeamTurn() {
        return turn;
    }

    @Override
    public void setTeamTurn(TeamColor team) {
        turn = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
       if (board.getPiece(startPosition) == null){
           return null;
       }
        return new Vector<>(board.getPiece(startPosition).pieceMoves(board, startPosition));
    }


    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
        ChessPosition start = move.getStartPosition();
        var list = validMoves(start);
        if(list == null){
            throw new InvalidMoveException("No Piece There");
        }
        if(!list.contains(move)){
            throw new InvalidMoveException("Invalid Move!");
        }
        if (board.getPiece(start).getTeamColor() != turn) {
            throw new InvalidMoveException("Not your turn!");
        }
        Game next = getNextBoard(move);
        if(next.isInCheck(turn)) {
            throw new InvalidMoveException("Invalid. Puts King in Check!");
        }
        board = next.getBoard();
        nextTurn();
    }

    private Game getNextBoard(ChessMove move) {
        Game next = new Game(this);
        ChessBoard nBoard = next.getBoard();
        ChessPiece temp = nBoard.getPiece(move.getStartPosition());
        nBoard.removePiece(move.getStartPosition());
        nBoard.addPiece(move.getEndPosition(), temp);
        next.setBoard(nBoard);
        return next;
    }

    private void nextTurn() {
        if (turn == TeamColor.WHITE) setTeamTurn(TeamColor.BLACK);
        else setTeamTurn(TeamColor.WHITE);
    }

    private TeamColor opponent(TeamColor color) {
        if (color == TeamColor.WHITE) return TeamColor.BLACK;
        return TeamColor.WHITE;
    }
    @Override
    public boolean isInCheck(TeamColor teamColor) {
        ChessPosition KingPos = getKingPos(teamColor);
        Vector<ChessMove> list = new Vector<>();
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                ChessPosition pos = new Position(i, j);
                if(board.getPiece(pos) != null && board.getPiece(pos).getTeamColor() == opponent(teamColor)){
                    list.addAll(board.getPiece(pos).pieceMoves(board, pos));
                }
            }
        }
        for(int i = 0; i < list.size(); ++i){
            if (list.elementAt(i).getEndPosition().equals(KingPos)) {
                return true;
            }
        }
        return false;
    }

    private ChessPosition getKingPos(TeamColor teamColor) {
        for (int i = 1; i < 9; ++i){
            for (int j = 1; j < 9; ++j) {
                ChessPosition position = new Position(i, j);
                if(board.getPiece(position).getPieceType() == ChessPiece.PieceType.KING && board.getPiece(position).getTeamColor() == teamColor){
                    return position;
                }
            }
        }
        return null;
    }

    @Override
    public boolean isInCheckmate(TeamColor teamColor) {
        return isInCheck(teamColor) && isInStalemate(teamColor);
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor) {
        Vector<ChessMove> list = new Vector<>();
        for (int i = 1; i < 9; ++i) {
            for (int j = 1; j < 9; ++j) {
                ChessPosition pos = new Position(i, j);
                if(board.getPiece(pos) != null && board.getPiece(pos).getTeamColor() == teamColor) {
                    list.addAll(board.getPiece(pos).pieceMoves(board, pos));
                }
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            Game next = getNextBoard(list.elementAt(i));
            if(!(next.isInCheck(teamColor))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    @Override
    public ChessBoard getBoard() {
        return board;
    }
}
