package Board;

public class Piece {

    private final boolean alive;
    private final char type;
    private final char color;

    public Piece(char kind, boolean active, char side) {
        type = kind;
        color = side;
        alive = active;
    }

    public char getType() {

        if (type == 'e') {
            return ' ';
        } else {
            return type;
        }
    }

    public boolean getStatus() {
        return alive;
    }

    public char getColor() {
        return color;
    }

}
