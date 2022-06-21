package Board;

public class Chessboard {

    private final Piece[][] board = new Piece[8][8];
    private boolean w2m = true;

    public Chessboard() {
    }

    public void setToMove(boolean x){
        w2m = x;
    }

    public boolean getColorMove(){
        return w2m;
    }

    public void fillBoard(String position) {
        if (position.equalsIgnoreCase("default")) {
            char color;

            //Backranks
            for (int y = 0; y < 8; y = y + 7) {
                if (y == 0) {
                    color = 'w';
                } else {
                    color = 'b';
                }
                board[y][0] = new Rook(true, color);
                board[y][1] = new Knight(true, color);
                board[y][2] = new Bishop(true, color);
                board[y][3] = new Queen(true, color);
                board[y][4] = new King(true, color);
                board[y][5] = new Bishop(true, color);
                board[y][6] = new Knight(true, color);
                board[y][7] = new Rook(true, color);
            }

            //Pawns
            for (int y = 1; y < 7; y = y + 5) {
                if (y == 1) {
                    color = 'w';
                } else {
                    color = 'b';
                }
                for (int x = 0; x < 8; x++) {
                    Piece p = new Pawn(true, color);
                    board[y][x] = p;
                }
            }

            //Empty Spaces
            for (int y = 2; y < 6; y++) {
                for (int x = 0; x < 8; x++) {
                    Piece e = new Empty();
                    board[y][x] = e;
                }
            }

        }  //Read Position from String


    }

    public void printBoard() {

        printX();
        System.out.println();
        for (int y = 0; y < 8; y++) {

            StringBuilder boardLine = new StringBuilder("[");
            for (int x = 0; x < 8; x++) {

                if (x == 7) {
                    boardLine.append(board[y][x].getType());
                } else {
                    boardLine.append(board[y][x].getType()).append(",");
                }
            }
            boardLine.append("]");

            System.out.println("{" + (y + 1) + "} " + boardLine + " {" + (y + 1) + "}");
        }
        System.out.println();
        printX();
    }

    public void printX() {
        System.out.println("    {a, b, c, d, e, f, g, h}");
    }

    public Piece[][] getBoard() {
        return board;
    }
}
