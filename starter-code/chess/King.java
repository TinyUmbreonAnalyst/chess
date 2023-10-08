package chess;

import java.util.Collection;
import java.util.Vector;

public class King implements ChessPiece{
    private ChessGame.TeamColor color;
    private PieceType type;

    public King(ChessGame.TeamColor c){
        type = PieceType.KING;
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
        //left
        ChessPosition left = myPosition.findPosition(0, -1);
        if(left != null && (board.getPiece(left) == null || board.getPiece(left).getTeamColor() != color)) list.add(new Move(myPosition, left));
        //up
        ChessPosition up = myPosition.findPosition(1, 0);
        if(up != null && (board.getPiece(up) == null || board.getPiece(up).getTeamColor() != color)) list.add(new Move(myPosition, up));
        //right
        ChessPosition right = myPosition.findPosition(0, 1);
        if(right != null && (board.getPiece(right) == null || board.getPiece(right).getTeamColor() != color)) list.add(new Move(myPosition, right));
        //down
        ChessPosition down = myPosition.findPosition(-1, 0);
        if(down != null && (board.getPiece(down) == null || board.getPiece(down).getTeamColor() != color)) list.add(new Move(myPosition, down));
        //diagonals
        ChessPosition upright = myPosition.findPosition(1, 1);
        if(upright != null && (board.getPiece(upright) == null || board.getPiece(upright).getTeamColor() != color)) list.add(new Move(myPosition, upright));
        ChessPosition downright = myPosition.findPosition(-1, 1);
        if(downright != null && (board.getPiece(downright) == null || board.getPiece(downright).getTeamColor() != color)) list.add(new Move(myPosition, downright));
        ChessPosition downleft = myPosition.findPosition(-1, -1);
        if(downleft != null && (board.getPiece(downleft) == null || board.getPiece(downleft).getTeamColor() != color)) list.add(new Move(myPosition, downleft));
        ChessPosition upleft = myPosition.findPosition(-1, 1);
        if(upleft != null && (board.getPiece(upleft) == null || board.getPiece(upleft).getTeamColor() != color)) list.add(new Move(myPosition, upleft));
        return list;
    }
}
