package chess;

import java.util.Objects;

public class Position implements ChessPosition{


    private int row;
    private int column;

    public Position(){
        row = 0;
        column = 0;
    }

    public Position(int r, int c) {
        row = r;
        column = c;
    }
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public ChessPosition findPosition(int rowOffset, int columnOffset) {
        Position p = new Position(row + rowOffset, column + columnOffset);
        if (p.isValid()){
            return p;
        }
        return null;
    }

    private boolean isValid(){
        return row >= 1 && row <= 8 && column >= 1 && column <= 8;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
