package chess;

import java.util.Collection;
import java.util.Vector;

public class Bishop implements ChessPiece{
    private ChessGame.TeamColor color;
    private PieceType type;

    public Bishop(ChessGame.TeamColor c){
        type = PieceType.BISHOP;
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
        ChessPosition upright = myPosition.findPosition(1, 1);
        while (upright != null && (board.getPiece(upright) == null || board.getPiece(upright).getTeamColor() != color)){
            list.add(new Move(myPosition, upright));
            if (board.getPiece(upright) != null) break;
            upright = upright.findPosition(1,1);
        }
        ChessPosition downright = myPosition.findPosition(-1, 1);
        while (downright != null && (board.getPiece(downright) == null || board.getPiece(downright).getTeamColor() != color)){
            list.add(new Move(myPosition, downright));
            if (board.getPiece(downright) != null) break;
            downright = downright.findPosition(-1,1);
        }
        ChessPosition downleft = myPosition.findPosition(-1, -1);
        while (downleft != null && (board.getPiece(downleft) == null || board.getPiece(downleft).getTeamColor() != color)){
            list.add(new Move(myPosition, downleft));
            if (board.getPiece(downleft) != null) break;
            downleft = downleft.findPosition(-1,-1);
        }
        ChessPosition upleft = myPosition.findPosition(1, -1);
        while (upleft != null && (board.getPiece(upleft) == null || board.getPiece(upleft).getTeamColor() != color)){
            list.add(new Move(myPosition, upleft));
            if (board.getPiece(upleft) != null) break;
            upleft = upleft.findPosition(1,-1);
        }
        return list;
    }
}
