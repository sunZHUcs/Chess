package Board;

public class Chessboard {

    private static final Piece[][] board = new Piece[8][8];

    public Chessboard(){
    }

    public void fillBoard(String position){
        if(position.equalsIgnoreCase("default")){
            char color;

            //Backranks
            for(int y = 0; y<8; y=y+7){
                if(y==0){
                    color = 'w';
                }else{
                    color = 'b';
                }
                Piece r = new Rook(true, color);
                Piece n = new Knight(true, color);
                Piece b = new Bishop(true, color);
                Piece q = new Queen(true, color);
                Piece k = new King(true, color);
                board[y][0] = r;
                board[y][1] = k;
                board[y][2] = b;
                board[y][3] = q;
                board[y][4] = k;
                board[y][5] = b;
                board[y][6] = k;
                board[y][7] = r;
            }

            //Pawns
            for(int y = 1; y<7; y=y+5){
                if(y==1){
                    color = 'w';
                }else{
                    color = 'b';
                }
                for(int x = 0; x<8; x++){
                    Piece p = new Pawn(true, color);
                    board[y][x] = p;
                }
            }

            //Empty Spaces
            for(int y = 2; y<6; y++){
                for(int x = 0; x<8; x++){
                    Piece e = new Empty();
                    board[y][x] = e;
                }
            }

        }else{
            //Read Position from String
        }

    }

    public void printBoard(){

        for(int y = 0; y<8; y++){
            for(int x = 0; x<8; x++) {
                if (x == 7) {
                    System.out.print(board[y][x].getType());
                } else{
                    System.out.print(board[y][x].getType() + ", ");
                }
            }
        System.out.println();
        }
    }

        /*
        for(int x = 0; x<8; x++){
            for(int y = 0; y<8; y++){

            }
        }
         */

    public void printX(){
        System.out.println("{a} {b} {c} {d} {e} {f} {g} {h}");
    }

    public static void printY(){
        for(int i = 0; i<8; i++){
            System.out.println("{" + i + "} ");
        }
    }

    public static Piece[][] getBoard(){
        return board;
    }
}
