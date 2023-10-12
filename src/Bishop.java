public class Bishop extends ChessPiece {
    private String color;

    public Bishop(String color) {
        super(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The bishop is trying to move out of the board
        }

        int diffLine = Math.abs(toLine - line);
        int diffColumn = Math.abs(toColumn - column);

        if (diffLine == diffColumn && diffLine != 0) {
            int stepLine = (toLine > line) ? 1 : -1;
            int stepColumn = (toColumn > column) ? 1 : -1;

            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;

            while (currentLine != toLine && currentColumn != toColumn) {
                if (board.getPiece(currentLine, currentColumn) != null) {
                    return false; // There is a piece blocking the bishop's path
                }
                currentLine += stepLine;
                currentColumn += stepColumn;
            }

            return true; // The bishop can move diagonally to the target position
        }

        return false; // The bishop cannot move to the target position
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
