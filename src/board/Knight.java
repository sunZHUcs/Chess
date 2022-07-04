package board;

public class Knight extends Piece {
    public Knight(boolean active, char side, int[] place) {
        super('n', active, side, place);
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

        if(x == ix+1 || x==ix-1){
            if(y == iy+2 || y==iy-2){
                if(chessboard.checkSquare(coords,this)){
                    super.movePiece(coords, chessboard);
                    return true;
                }
            }
        }else if(x==ix+2 || x==ix-2){
            if(y==iy+1 || y==iy-1){
                if(chessboard.checkSquare(coords, this)){
                    super.movePiece(coords, chessboard);
                    return true;
                }
            }
        }

        System.out.println("Invalid Move!");
        return false;
    }

}