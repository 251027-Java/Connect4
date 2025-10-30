import java.util.Arrays;

public class GameBoard {

    public static void printGameBoard() {
        char[][] gameBoard = new char[4][4];
        for(int i = 0; i < 4; i++) {
            Arrays.fill(gameBoard[i], '_');
        }
        for(int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
    }

}
