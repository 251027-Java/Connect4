import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {

    public static void printGameBoard() {
        char[][] gameBoard = new char[6][7];
        for(int i = 0; i < 6; i++) {
            Arrays.fill(gameBoard[i], '_');
        }
        for(int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
    }

    public static void playGame() {
        System.out.println("Choose X or O to play.");
        Scanner inputReader = new Scanner(System.in);
    }
}
