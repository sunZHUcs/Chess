package board;

public class Pawn extends Piece {
    public Pawn(boolean active, char side, int[] place) {
        super('p', active, side, place);
    }

    public boolean move(String input, Chessboard chessboard) {

        int[] coords = new int[2];
        int x = Character.getNumericValue(input.charAt(0));
        int y = Character.getNumericValue(input.charAt(1));
        int ix = getPosition()[0];
        int iy = getPosition()[1];
        coords[0] = x;
        coords[1] = y;

        if (super.getStatus()) {
            System.out.println("Invalid Move!");
            return false;
        }

        //Moving up/down into empty squares with both white and black
        if (ix == x) {
            if (chessboard.getColorMove()) {
                if (iy == (y - 1)) {
                    if (chessboard.getBoard()[y][x].isEmpty()) {
                        super.movePiece(coords, chessboard);
                        return true;
                    }
                }
            } else {
                if (iy == (y + 1)) {
                    if (chessboard.checkSquare(coords, this)) {
                        super.movePiece(coords, chessboard);
                        return true;
                    }
                }
            }

            //Captures
        } else if ((ix == (x - 1) || ix == (x + 1))) {
            if (chessboard.getColorMove()) {
                if (iy == (y - 1)) {
                    if (chessboard.checkSquare(coords, this)) {
                        super.movePiece(coords, chessboard);
                        return true;
                    }
                }
            } else {
                if (iy == (y + 1)) {
                    if (chessboard.checkSquare(coords, this)) {
                        super.movePiece(coords, chessboard);
                        return true;
                    }
                }
            }
        }

        System.out.println("Invalid Move!");
        return false;
    }
}
