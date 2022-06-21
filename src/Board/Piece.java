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

    public String toString(){
        if(type == 'e'){
            return " ";
        }else{
            return String.valueOf(type);
        }
    }
}
