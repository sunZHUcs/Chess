import Board.Chessboard;

public class Main {
    public static void main(String[] args) {

        Chessboard chessboard = new Chessboard();
        chessboard.fillBoard("default");
        chessboard.printBoard();
    }

    /*
           [a,b,c,d,e,f,g,h]

     [8]   [r,k,b,q,k,b,k,r]   [8]
     [7]   [p,p,p,p,p,p,p,p]   [7]
     [6]   [ , , , , , , , ]   [6]
     [5]   [ , , , , , , , ]   [5]
     [4]   [ , , , , , , , ]   [4]
     [3]   [ , , , , , , , ]   [3]
     [2]   [p,p,p,p,p,p,p,p]   [2]
     [1]   [r,k,b,q,k,b,k,r]   [1]

           [a,b,c,d,e,f,g,h]

    Logic:
    Prompt User -> What color to move-> From what position
        Create Chessboard
        Fill Chessboard (w/ all Pieces) (According to position)
        based on what color's move:
            printboard (w/ coordinates) (based on color -> flip/normal board)
            prompt -> enter next move
                Format: "Kc2" "Pa1" "Nc4"
                    Separate into 3 characters:
                        C1 = piece type
                        c2 = x coordinate
                        c3 = y coordinate
                    Check if move is legal:
                        Check if piece exists which can reach that square
                        check if square already has a piece of the same color
                        check if moving piece to square puts king in check
     */
}
