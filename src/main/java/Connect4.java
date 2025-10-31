import java.util.Scanner;

public class Connect4 {
    public static void main(String [] args) {
        // new branch
        int gameTurns = 5;
        GameBoard.initializeGameBoard();
        GameBoard.printGameBoard();
        while(gameTurns>=0){
            GameBoard.playGame();
            GameBoard.lowestRowToInsert();
            gameTurns--;
        }

    }
}
