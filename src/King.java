public class King extends ChessPiece {
    private String color;

    public King(String color) {
        super(color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine >= 8 || toColumn < 0 || toColumn >= 8) {
            return false; // The king is trying to move out of the board
        }

        if (line == toLine && column == toColumn) {
            return false; // The king is trying to move to its current position
        }

        int lineDiff = Math.abs(toLine - line);
        int columnDiff = Math.abs(toColumn - column);
        if (lineDiff > 1 || columnDiff > 1) {
            return false; // The king can only move to adjacent positions
        }

        return true; // The king can move to the target position
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = (ChessPiece) board.getPiece(i, j);
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.canMoveToPosition(board, i, j, line, column)) {
                        return true; // The king is under attack
                    }
                }
            }
        }

        return false; // The king is not under attack
    }
}
