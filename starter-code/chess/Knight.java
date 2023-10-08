package chess;

import java.util.Collection;
import java.util.Vector;

public class Knight implements ChessPiece{
    private ChessGame.TeamColor color;
    private PieceType type;

    public Knight(ChessGame.TeamColor c){
        type = PieceType.KNIGHT;
        color = c;
    }

    @Override
    public ChessGame.TeamColor getTeamColor() {
        return color;
    }

    @Override
    public PieceType getPieceType() {
        return type;
    }


    public  Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Vector<ChessMove> list = new Vector<>();
        ChessPosition twoupleft = myPosition.findPosition(2, -1);
        ChessPosition twoupright = myPosition.findPosition(2, 1);
        ChessPosition tworightup = myPosition.findPosition(1, 2);
        ChessPosition tworightdown = myPosition.findPosition(-1, 2);
        ChessPosition twodownright = myPosition.findPosition(-2, 1);
        ChessPosition twodownleft = myPosition.findPosition(-2, -1);
        ChessPosition twoleftdown = myPosition.findPosition(-1, -2);
        ChessPosition twoleftup = myPosition.findPosition(1, -2);
        if (twoupleft != null && (board.getPiece(twoupleft) == null || board.getPiece(twoupleft).getTeamColor() != color)){
            list.add(new Move(myPosition, twoupleft));
        }
        if (twoupright != null && (board.getPiece(twoupright) == null || board.getPiece(twoupright).getTeamColor() != color)){
            list.add(new Move(myPosition, twoupright));
        }
        if (tworightup != null && (board.getPiece(tworightup) == null || board.getPiece(tworightup).getTeamColor() != color)){
            list.add(new Move(myPosition, tworightup));
        }
        if (tworightdown != null && (board.getPiece(tworightdown) == null || board.getPiece(tworightdown).getTeamColor() != color)){
            list.add(new Move(myPosition, tworightdown));
        }
        if (twodownright != null && (board.getPiece(twodownright) == null || board.getPiece(twodownright).getTeamColor() != color)){
            list.add(new Move(myPosition, twodownright));
        }
        if (twodownleft != null && (board.getPiece(twodownleft) == null || board.getPiece(twodownleft).getTeamColor() != color)){
            list.add(new Move(myPosition, twodownleft));
        }
        if (twoleftdown != null && (board.getPiece(twoleftdown) == null || board.getPiece(twoleftdown).getTeamColor() != color)){
            list.add(new Move(myPosition, twoleftdown));
        }
        if (twoleftup != null && (board.getPiece(twoleftup) == null || board.getPiece(twoleftup).getTeamColor() != color)){
            list.add(new Move(myPosition, twoleftup));
        }
        return list;
    }
}