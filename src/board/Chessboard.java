package board;

import java.util.Arrays;
import java.util.Scanner;

public class Chessboard {

    private final Piece[][] board = new Piece[8][8];
    private boolean w2m = true;
    private boolean over = false;

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
                board[y][0] = new Rook(true, color, new int[]{0, y});
                board[y][1] = new Knight(true, color, new int[]{1, y});
                board[y][2] = new Bishop(true, color, new int[]{2, y});
                board[y][3] = new Queen(true, color, new int[]{3, y});
                board[y][4] = new King(true, color, new int[]{4, y});
                board[y][5] = new Bishop(true, color, new int[]{5, y});
                board[y][6] = new Knight(true, color, new int[]{6, y});
                board[y][7] = new Rook(true, color, new int[]{7, y});
            }

            //Pawns
            for (int y = 1; y < 7; y = y + 5) {
                if (y == 1) {
                    color = 'w';
                } else {
                    color = 'b';
                }
                for (int x = 0; x < 8; x++) {
                    Piece p = new Pawn(true, color, new int[]{x, y});
                    board[y][x] = p;
                }
            }

            //Empty Spaces
            for (int y = 2; y < 6; y++) {
                for (int x = 0; x < 8; x++) {
                    Piece e = new Empty(new int[]{x, y});
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

    public boolean getGameStatus() {
        return over;
    }

    public boolean checkSquare(int[] coords, Piece piece) {

        char type = piece.getType();
        if (type == 'p' || type == 'n' || type == 'k')  {
            return board[coords[1]][coords[0]].getColor() != piece.getColor();
        }else if (type == 'b' || type == 'r'){
            return board[coords[1]][coords[0]].isEmpty();
        }
        //return board[chars[1]][chars[0]].getColor() != pieceColor;
        return false;
    }

    public void updateBoard(Piece piece, int[] newplace) {
        int[] oldPos = piece.getPosition();
        System.out.println(Arrays.toString(oldPos));
        System.out.println(Arrays.toString(newplace));
        board[oldPos[1]][oldPos[0]] = new Empty(oldPos);
        board[newplace[1]][newplace[0]] = piece;
    }

    public void playChess() {
        String color;
        if (w2m) {
            color = "White";
        } else {
            color = "Black";
        }

        System.out.println(color + " to move. Enter a move: [(piece)(square).(new square)]");
        Scanner scan = new Scanner(System.in);


        String in = scan.nextLine().substring(1);

        //adjust by one -- y coords
        in = in.replaceAll("1", "0");
        in = in.replaceAll("2", "1");
        in = in.replaceAll("3", "2");
        in = in.replaceAll("4", "3");
        in = in.replaceAll("5", "4");
        in = in.replaceAll("6", "5");
        in = in.replaceAll("7", "6");
        in = in.replaceAll("8", "7");

        //x coordinates
        in = in.replaceAll("a", "0");
        in = in.replaceAll("b", "1");
        in = in.replaceAll("c", "2");
        in = in.replaceAll("d", "3");
        in = in.replaceAll("e", "4");
        in = in.replaceAll("f", "5");
        in = in.replaceAll("g", "6");
        in = in.replaceAll("h", "7");

        String[] input = in.split("\\.");
        int y = Character.getNumericValue(input[0].charAt(1));
        int x = Character.getNumericValue(input[0].charAt(0));

        System.out.println(input[1]);
        if (!board[y][x].move(input[1], this)) {
            playChess();
        }

        printBoard();
        System.out.println("Method Completed");
    }

}
