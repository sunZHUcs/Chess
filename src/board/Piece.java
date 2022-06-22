package board;

public class Piece {

    private final boolean alive;
    private final char type;
    private final char color;
    private int[] position;

    public Piece(char kind, boolean active, char side, int[] place) {
        type = kind;
        color = side;
        alive = active;
        position = place;
    }

    public char getType() {

        if (type == 'e') {
            return ' ';
        } else {
            return type;
        }
    }

    public boolean isEmpty(){
        return type == 'e';
    }

    public boolean getStatus() {
        return alive;
    }

    public char getColor() {
        return color;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] chars) {
        position = chars;
    }

    public void movePiece(int[] coords, Chessboard chessboard){
        chessboard.updateBoard(this, coords);
        setPosition(coords);
    }

    public boolean move(String input, Chessboard chessboard) {
        return false;
    }

}
