package board;

public class Pawn extends Piece {
    public Pawn(boolean active, char side, int[] place) {
        super('p', active, side, place);
    }

    public void movePawn(int[] coords, Chessboard chessboard) {
        if (chessboard.checkSquare(coords, getColor())) {
            chessboard.updateBoard(this, coords);
            setPosition(coords);
        }
    }

    public boolean move(String input, Chessboard chessboard) {

        input = input.substring(input.indexOf(".") + 1);
        int[] coords = new int[2];

        for (int i = 0; i < coords.length; i++) {
            coords[i] = input.charAt(i) - '0';
        }

        if (!super.getStatus()) {
            System.out.println("Invalid Move!");
            return false;
        }

        if (getPosition()[1] == coords[1]) {
            if (chessboard.getColorMove()) {
                if (getPosition()[0] == (coords[0] - 1)) {
                    movePawn(coords, chessboard);
                    return true;
                }
            } else {
                if (getPosition()[0] == (coords[0] + 1)) {
                    if (chessboard.checkSquare(coords, getColor())) {
                        movePawn(coords, chessboard);
                        return true;
                    }
                }
            }

        } else if ((getPosition()[1] == (coords[1] - 1) || getPosition()[1] == (coords[1] + 1))) {
            if (getPosition()[0] == (coords[0] + 1)) {
                movePawn(coords, chessboard);
                return true;
            }
        }

        System.out.println("Invalid Move!");
        return false;
    }
}
