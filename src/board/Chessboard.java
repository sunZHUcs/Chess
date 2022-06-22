package board;

import java.util.Scanner;

public class Chessboard {

    private final Piece[][] board = new Piece[8][8];
    private boolean w2m = true;

    public Chessboard() {
    }

    public void setToMove(boolean x) {
        w2m = x;
    }

    public boolean getColorMove() {
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
                board[y][0] = new Rook(true, color, new int[]{y, 0});
                board[y][1] = new Knight(true, color, new int[]{y, 1});
                board[y][2] = new Bishop(true, color, new int[]{y, 2});
                board[y][3] = new Queen(true, color, new int[]{y, 3});
                board[y][4] = new King(true, color, new int[]{y, 4});
                board[y][5] = new Bishop(true, color, new int[]{y, 5});
                board[y][6] = new Knight(true, color, new int[]{y, 6});
                board[y][7] = new Rook(true, color, new int[]{y, 7});
            }

            //Pawns
            for (int y = 1; y < 7; y = y + 5) {
                if (y == 1) {
                    color = 'w';
                } else {
                    color = 'b';
                }
                for (int x = 0; x < 8; x++) {
                    Piece p = new Pawn(true, color, new int[]{y, x});
                    board[y][x] = p;
                }
            }

            //Empty Spaces
            for (int y = 2; y < 6; y++) {
                for (int x = 0; x < 8; x++) {
                    Piece e = new Empty(new int[]{y, x});
                    board[y][x] = e;
                }
            }

        }  //Read Position from String


    }

    public void printBoard() {

        printX();
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
        System.out.println("    {a,b,c,d,e,f,g,h}\n");
    }

    public Piece[][] getBoard() {
        return board;
    }

    public boolean checkSquare(int[] chars, char pieceColor) {
        return board[chars[0]][chars[1]].getColor() != pieceColor;
    }

    public void updateBoard(Piece piece, int[] newplace) {
        int[] oldPos = piece.getPosition();
        board[oldPos[0]][oldPos[1]] = new Empty(oldPos);
        board[newplace[0]][newplace[1]] = piece;
    }

    public void playChess() {
        String color;
        if (w2m) {
            color = "White";
        } else {
            color = "Black";
        }

        System.out.println(color + " to move. Enter a move: [(piece)(square)x.(new square)]");
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        String[] input = in.split("x");
        char[] coords = input[0].toCharArray();
        int y = Character.getNumericValue(coords[1]);
        int x = Character.getNumericValue(coords[2]);

        if (board[y][x].move(input[1], this)) {
            System.out.println("Moved Successfully");
        }
        printBoard();
    }

}