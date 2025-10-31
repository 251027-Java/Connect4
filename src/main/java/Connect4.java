import java.util.*;

public class Connect4 {
    public static void main(String [] args) {
        // Game ends when the method in GameBoard.java to check for four is implemented or when 42 X's and O's total are inserted.
        int gameTurns = 42;
        GameBoard.initializeGameBoard();
        GameBoard.printGameBoard();

        while(gameTurns>=0 && !GameBoard.checkForWin()){
            GameBoard.playGame();
            GameBoard.lowestRowToInsert();
            if(gameTurns<=39) GameBoard.checkForWin();
            gameTurns--;

        }

    }
}
