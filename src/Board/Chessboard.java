package Board;

public class Chessboard {

    private static Piece[][] board = new Piece[8][8];

    public Chessboard(){
    }

    public void fillBoard(String position){
        if(position.equalsIgnoreCase("default")){
            char color;
            for(int y = 0; y<8; y++){
                if(y == 0 || y==7){
                    if(y==0){
                        color = 'w';
                    }else{
                        color = 'b';
                    }
                    board[y][0] = new Rook(true, color);
                    board[y][1] = new Knight(true, color);
                    board[y][2] = new Bishop(true, color);
                    board[y][3] = new Queen(true, color);
                    board[y][4] = new King(true, color);
                    board[y][5] = new Bishop(true, color);
                    board[y][6] = new Knight(true, color);
                    board[y][7] = new Rook(true, color);
                }else if(y == 1 || y==6){
                    if(y==1){
                        color = 'w';
                    }else{
                        color = 'b';
                    }
                    for(int x = 0; x<8; x++){
                        board[y][x] = new Pawn(true, color);
                    }
                }else{
                    for(int x = 0; x<8; x++){
                        board[y][x] = new Empty();
                    }
                }
            }
        }else{
            //Read Position from String
        }
    }

    public void printBoard(){

        for(int y = 0; y<8; y++){

            String boardLine = "[";
            for(int x = 0; x<8; x++){
                boardLine = boardLine + board[y][x].toString() + ", ";
            }
            boardLine = boardLine + "]";

            System.out.println("{" + (y+1) + "} " + boardLine + "{" + (y+1) + "}");
        }

        /*
        for(int x = 0; x<8; x++){
            for(int y = 0; y<8; y++){

            }
        }
         */
    }

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
