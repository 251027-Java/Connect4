import java.util.*;
import java.lang.Math;

public class Connect4 {
    static int gameTurns = 1;

    public static int getGameTurns(){
        return gameTurns;
    }
    public static void main(String [] args) {
        // Game ends when the method in GameBoard.java to check for four is implemented or when available
        // colArray is empty

        GameBoard.initializeGameBoard();
        GameBoard.printGameBoard();
        boolean gameOver = false;

        while(!GameBoard.EmptyAvailableColumns() && !gameOver){
            GameBoard.playGame();
            GameBoard.lowestRowToInsert();

            if(Math.ceil((double) gameTurns / 2) >= 4) {
                gameOver = GameBoard.checkForWin();
            }
            gameTurns++;
            if(gameOver || GameBoard.EmptyAvailableColumns()){
                System.out.println("Game over.");
            }
        }

    }

}
