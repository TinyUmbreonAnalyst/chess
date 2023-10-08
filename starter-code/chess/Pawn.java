package chess;

import java.util.Collection;
import java.util.Vector;

public class Pawn implements ChessPiece{
    private ChessGame.TeamColor color;
    private PieceType type;
    public Pawn(ChessGame.TeamColor c){
        type = PieceType.PAWN;
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
        if (color == ChessGame.TeamColor.WHITE) {
            return pieceMovesWhite(board, myPosition);
        }
        return pieceMovesBlack(board, myPosition);
    }

    private  Collection<ChessMove> pieceMovesBlack(ChessBoard board, ChessPosition myPosition) {
        Vector<ChessMove> list = new Vector<>();
        ChessPosition down = myPosition.findPosition(-1, 0);
        if(down != null && board.getPiece(down) == null) {
            if(down.getRow() == 1){
                list.addAll(getPromotions(myPosition, 0));
            }
            else list.add(new Move(myPosition, down));
            ChessPosition downtwo = myPosition.findPosition(-2, 0);
            boolean hasNotMoved = checkPos(myPosition);
            if(hasNotMoved && board.getPiece(downtwo) == null) {
                list.add(new Move(myPosition, downtwo));
            }
        }
        ChessPosition downright = myPosition.findPosition(-1, 1);
        ChessPosition downleft = myPosition.findPosition(-1, -1);
        if(downright != null && board.getPiece(downright) != null && board.getPiece(downright).getTeamColor() != color) {
            if(downright.getRow() == 1) {
                list.addAll(getPromotions(myPosition, 1));
            } else list.add(new Move(myPosition, downright));
        }
        if(downleft != null && board.getPiece(downleft) != null && board.getPiece(downleft).getTeamColor() != color) {
            if(downleft.getRow() == 1) {
                list.addAll(getPromotions(myPosition, -1));
            } else list.add(new Move(myPosition, downleft));
        }
        return list;
    }

    private  Collection<ChessMove> pieceMovesWhite(ChessBoard board, ChessPosition myPosition) {
        Vector<ChessMove> list = new Vector<>();
        ChessPosition up = myPosition.findPosition(1, 0);
        if(up != null && board.getPiece(up) == null) {
            if(up.getRow() == 8){
                list.addAll(getPromotions(myPosition, 0));
            }
            else list.add(new Move(myPosition, up));
            ChessPosition uptwo = myPosition.findPosition(2, 0);
            boolean hasNotMoved = checkPos(myPosition);
            if(hasNotMoved && board.getPiece(uptwo) == null) {
                list.add(new Move(myPosition, uptwo));
            }
        }
        ChessPosition upright = myPosition.findPosition(1, 1);
        ChessPosition upleft = myPosition.findPosition(1, -1);
        if(upright != null && board.getPiece(upright) != null && board.getPiece(upright).getTeamColor() != color) {
            if(upright.getRow() == 8) {
                list.addAll(getPromotions(myPosition, 1));
            } else list.add(new Move(myPosition, upright));
        }
        if(upleft != null && board.getPiece(upleft) != null && board.getPiece(upleft).getTeamColor() != color) {
            if(upleft.getRow() == 8) {
                list.addAll(getPromotions(myPosition, -1));
            } else list.add(new Move(myPosition, upleft));
        }
        return list;
    }

    private boolean checkPos(ChessPosition myPosition)
    {
        return (color == ChessGame.TeamColor.WHITE && myPosition.getRow() == 2) || (color == ChessGame.TeamColor.BLACK && myPosition.getRow() == 7);
    }

    private Collection<ChessMove> getPromotions(ChessPosition myPosition, int offset) {
        Vector<ChessMove> list = new Vector<>();
        ChessPosition move;
        if(color == ChessGame.TeamColor.WHITE) {
            move = new Position(8, myPosition.getColumn() + offset);
        }
        else  move = new Position(1, myPosition.getColumn() + offset);
        list.add(new Move(myPosition, move, PieceType.QUEEN));
        list.add(new Move(myPosition, move, PieceType.BISHOP));
        list.add(new Move(myPosition, move, PieceType.KNIGHT));
        list.add(new Move(myPosition, move, PieceType.ROOK));
        return list;
    }


}

