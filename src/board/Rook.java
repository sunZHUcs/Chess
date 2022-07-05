package board;

public class Rook extends Piece {
    public Rook(boolean active, char side, int[] place) {
        super('r', active, side, place);
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

        int z;
        if(x == ix){
            z = Math.abs(y-iy);
            if(y>iy){
                for(int i = 1; i<z; i++){
                    if(!chessboard.checkSquare(new int[]{x, iy + i},this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }
            }else{
                for(int i = 1; i<z; i++){
                    if(!chessboard.checkSquare(new int[]{x, iy - i},this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }
            }
        }else if(y == iy){
            z = Math.abs(x-ix);
            if(x>ix){
                for(int i = 1; i<z; i++){
                    if(!chessboard.checkSquare(new int[]{ix+i, y},this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }
            }else{
                for(int i = 1; i<z; i++){
                    if(!chessboard.checkSquare(new int[]{ix-i, y},this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }
            }
        }else{
            System.out.println("Invalid Move!");
            return false;
        }

        if(chessboard.getBoard()[y][x].getColor() != this.getColor()){
            super.movePiece(coords, chessboard);
            return true;
        }
        System.out.println("Invalid Move!");
        return false;
    }
}