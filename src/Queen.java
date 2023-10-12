public class Queen extends ChessPiece {
    private String color;

    public Queen(String color) {
        super(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The queen is trying to move out of the board
        }

        if (line == toLine && column == toColumn) {
            return false; // The queen is trying to move to its current position
        }

        if (line != toLine && column != toColumn && Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false; // The queen can only move in straight lines or diagonally
        }

        if (line == toLine) {
            int start = Math.min(column, toColumn) + 1;
            int end = Math.max(column, toColumn);
            for (int i = start; i < end; i++) {
                if (board.getPiece(line, i) != null) {
                    return false; // There is a piece blocking the queen's path
                }
            }
        } else if (column == toColumn) {
            int start = Math.min(line, toLine) + 1;
            int end = Math.max(line, toLine);
            for (int i = start; i < end; i++) {
                if (board.getPiece(i, column) != null) {
                    return false; // There is a piece blocking the queen's path
                }
            }
        } else {
            int startLine = Math.min(line, toLine) + 1;
            int endLine = Math.max(line, toLine);
            int startColumn = Math.min(column, toColumn) + 1;
            int endColumn = Math.max(column, toColumn);
            for (int i = startLine, j = startColumn; i < endLine && j < endColumn; i++, j++) {
                if (board.getPiece(i, j) != null) {
                    return false; // There is a piece blocking the queen's path
                }
            }
        }

        return true; // The queen can move to the target position
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

