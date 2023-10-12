public class Horse extends ChessPiece {
    private String color;

    public Horse(String color) {
        super (color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The horse is trying to move out of the board
        }

        int diffLine = Math.abs(toLine - line);
        int diffColumn = Math.abs(toColumn - column);

        if ((diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2)) {
            return true; // The horse can move in an L-shape
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
