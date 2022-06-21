package Board;

public class Piece {

    private static boolean alive;
    private static char type;
    private static char color;

    public Piece(char kind, boolean active, char side){
        type = kind;
        color = side;
        alive = active;
    }

    public char getType(){
        return type;
    }

    public boolean getStatus(){
        return alive;
    }

    public char getColor(){
        return color;
    }

}
