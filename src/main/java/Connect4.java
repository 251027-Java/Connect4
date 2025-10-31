import java.util.*;

public class Connect4 {
    static int gameTurns = 1;

    public static int getGameTurns(){
        return gameTurns;
    }
    public static void main(String [] args) {
        // Game ends when the method in GameBoard.java to check for four is implemented or when 42 X's and O's total are inserted.

        GameBoard.initializeGameBoard();
        GameBoard.printGameBoard();
        boolean gameOver = false;

        while(gameTurns<=42 && !gameOver){
            GameBoard.playGame();
            GameBoard.lowestRowToInsert();
            if(gameTurns>=7) {
                gameOver = GameBoard.checkForWin();
            }
            gameTurns++;
            if(gameTurns==43){
                System.out.println("Game over.");
            }
        }

    }

}
