public class Rook extends ChessPiece {
    private String color;

    public Rook(String color) {
        super(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The rook is trying to move out of the board
        }

        if (line == toLine && column == toColumn) {
            return false; // The rook is trying to move to its current position
        }

        if (line != toLine && column != toColumn) {
            return false; // The rook can only move in straight lines
        }

        if (line == toLine) {
            int start = Math.min(column, toColumn) + 1;
            int end = Math.max(column, toColumn);
            for (int i = start; i < end; i++) {
                if (board.getPiece(line, i) != null) {
                    return false; // There is a piece blocking the rook's path
                }
            }
        } else {
            int start = Math.min(line, toLine) + 1;
            int end = Math.max(line, toLine);
            for (int i = start; i < end; i++) {
                if (board.getPiece(i, column) != null) {
                    return false; // There is a piece blocking the rook's path
                }
            }
        }

        return true; // The rook can move to the target position
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
