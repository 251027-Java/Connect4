import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    static char[][] gameBoard = new char[6][7];
    static int columnNumber;
    static char playerType;
    public static void initializeGameBoard() {
        for(int i = 0; i < 6; i++) {
            Arrays.fill(gameBoard[i], '_');
        }

    }

    public static void printGameBoard() {
        for(int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }

    }

    public static void playGame() {
        System.out.println("Choose X or O to play: ");
        Scanner inputReader = new Scanner(System.in);
         playerType = inputReader.next().charAt(0);
        System.out.println("Choose a column to insert: 1, 2, 3, 4, 5, 6, 7 ");
        columnNumber = inputReader.nextInt();
    }

    public static int lowestRowToInsert(){
        int i ;
        boolean inserted = false;
        for(i = 5; i >= 0; i--) {
            if(gameBoard[i][columnNumber-1] == '_' && !inserted){
                gameBoard[i][columnNumber-1] = playerType;
                inserted = true;
            }
        }
        printGameBoard();
        return i+1;
    }

}
