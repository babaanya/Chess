public class Pawn extends ChessPiece {
    private String color;

    public Pawn(String color) {
        super(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The pawn is trying to move out of the board
        }

        int diffLine = toLine - line;
        int diffColumn = toColumn - column;

        if (color.equals("White")) {
            if (diffLine == 1 && diffColumn == 0) {
                return true; // The white pawn can move one step forward
            } else if (line == 1 && diffLine == 2 && diffColumn == 0 && board.getPiece(toLine, toColumn) == null) {
                return true; // The white pawn can move two steps forward on its first move
            }
        } else if (color.equals("Black")) {
            if (diffLine == -1 && diffColumn == 0) {
                return true; // The black pawn can move one step forward
            } else if (line == 6 && diffLine == -2 && diffColumn == 0 && board.getPiece(toLine, toColumn) == null) {
                return true; // The black pawn can move two steps forward on its first move
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}