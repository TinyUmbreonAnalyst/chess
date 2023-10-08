package chess;

import java.util.Collection;
import java.util.Vector;

public class Queen implements ChessPiece{
    private ChessGame.TeamColor color;
    private PieceType type;

    public Queen(ChessGame.TeamColor c){
        type = PieceType.QUEEN;
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
        ChessPosition up = myPosition.findPosition(1, 0);
        while (up != null && (board.getPiece(up) == null || board.getPiece(up).getTeamColor() != color)){
            list.add(new Move(myPosition, up));
            if (board.getPiece(up) != null) break;
            up = up.findPosition(1,0);
        }
        ChessPosition upright = myPosition.findPosition(1, 1);
        while (upright != null && (board.getPiece(upright) == null || board.getPiece(upright).getTeamColor() != color)){
            list.add(new Move(myPosition, upright));
            if (board.getPiece(upright) != null) break;
            upright = upright.findPosition(1,1);
        }
        ChessPosition right = myPosition.findPosition(0, 1);
        while (right != null && (board.getPiece(right) == null || board.getPiece(right).getTeamColor() != color)){
            list.add(new Move(myPosition, right));
            if (board.getPiece(right) != null) break;
            right = right.findPosition(0,1);
        }
        ChessPosition downright = myPosition.findPosition(-1, 1);
        while (downright != null && (board.getPiece(downright) == null || board.getPiece(downright).getTeamColor() != color)){
            list.add(new Move(myPosition, downright));
            if (board.getPiece(downright) != null) break;
            downright = downright.findPosition(-1,1);
        }
        ChessPosition down = myPosition.findPosition(-1, 0);
        while (down != null && (board.getPiece(down) == null || board.getPiece(down).getTeamColor() != color)){
            list.add(new Move(myPosition, down));
            if (board.getPiece(down) != null) break;
            down = down.findPosition(-1,0);
        }
        ChessPosition downleft = myPosition.findPosition(-1, -1);
        while (downleft != null && (board.getPiece(downleft) == null || board.getPiece(downleft).getTeamColor() != color)){
            list.add(new Move(myPosition, downleft));
            if (board.getPiece(downleft) != null) break;
            downleft = downleft.findPosition(-1,-1);
        }
        ChessPosition left = myPosition.findPosition(0, -1);
        while (left != null && (board.getPiece(left) == null || board.getPiece(left).getTeamColor() != color)){
            list.add(new Move(myPosition, left));
            if (board.getPiece(left) != null) break;
            left = left.findPosition(0,-1);
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