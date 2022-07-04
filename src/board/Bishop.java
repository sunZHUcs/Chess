package board;

public class Bishop extends Piece {
    public Bishop(boolean active, char side, int[] place) {
        super('b', active, side, place);
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

        if(Math.abs(x-ix) == Math.abs(y-iy)){
            int z = Math.abs(x-ix);
            for(int i = 1; i<z; i++){
                if(y<iy && x<ix){
                    if(!chessboard.checkSquare(new int[]{ix - i, iy - i},this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }else if(y>iy && x>ix){
                    if(!chessboard.checkSquare(new int[]{ix+i, iy+i}, this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }else if(y>iy && x<ix){
                    if(!chessboard.checkSquare(new int[]{ix-i, iy+i}, this)){
                        System.out.println("Invalid Move!");
                        return false;
                    }
                }else{
                    if(!chessboard.checkSquare(new int[]{ix+i, iy-i}, this)){
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
