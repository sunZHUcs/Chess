import java.util.Scanner;

public class PromptManager {

    public static void begin() {
        System.out.println("Welcome to Chess! To begin, enter the initial board position: (\"default\" for default OR fen code)");
        Scanner scanner = new Scanner(System.in);

        String position = scanner.nextLine();
        if (position.equalsIgnoreCase("default")) {
            Main.chessboard.fillBoard(position);
            Main.chessboard.setToMove(true);
        } else {
            Main.chessboard.fillBoard(position);
            System.out.println("Position Loaded. What color's turn is it? (White/Black)");
            Main.chessboard.setToMove(scanner.nextLine().equalsIgnoreCase("white"));
        }

        System.out.println("Position and Move set. Printing board...\n");
        Main.chessboard.printBoard();
        Main.chessboard.playChess();
    }
}
