public class ChessBoard {
    public ChessPiece[][] board;
    public String nowPlayer;
    public int toLine;

    public ChessBoard(String white) {
        board = new ChessPiece[8][8];
        nowPlayer = "White";
    }

    public String nowPlayerColor() {
        return nowPlayer;
    }

    public boolean moveToPosition(int line, int column, int toline, int toColumn) {
        ChessPiece piece = board[line][column];
        if (piece != null && piece.getColor().equals(nowPlayer)) {
            if (piece.canMoveToPosition(this, line, column, toLine, toColumn)) {
                board[toLine][toColumn] = piece;
                board[line][column] = null;
                nowPlayer = (nowPlayer.equals("White")) ? "Black" : "White";
                return true;
            } else {
                System.out.println("Invalid move!");
                return false;
            }
        } else {
            System.out.println("No piece at the selected position or it's not your turn!");
            return false;
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getSymbol() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public Object getPiece(int toLine, int toColumn) {
        return null;
    }

    public boolean castling0() {
        return false;
    }

    public boolean castling7() {
        return false;
    }
}