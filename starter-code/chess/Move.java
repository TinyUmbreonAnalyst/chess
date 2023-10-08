package chess;

import java.util.Objects;

public class Move implements ChessMove{

    private ChessPosition start;
    private ChessPosition end;

    private ChessPiece.PieceType promotion;

    public Move(ChessPosition s, ChessPosition e, ChessPiece.PieceType p){
        start = s;
        end = e;
        promotion = p;
    }
    public Move(ChessPosition s, ChessPosition e){
        start = s;
        end = e;
        promotion = null;
    }
    @Override
    public ChessPosition getStartPosition() {
        return start;
    }

    @Override
    public ChessPosition getEndPosition() {
        return end;
    }

    @Override
    public ChessPiece.PieceType getPromotionPiece() {
        return promotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move move)) return false;
        return Objects.equals(start, move.start) && Objects.equals(end, move.end) && Objects.equals(promotion, move.promotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, promotion);
    }
}
