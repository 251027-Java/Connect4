import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameBoard {
    static char[][] gameBoard = new char[6][7];
    static int columnNumber;
    static boolean player1 = true;
    static String[] columns = new String[7];
    static ArrayList<Integer> availableColumns = new ArrayList<Integer>(7);

    public static boolean EmptyAvailableColumns(){
        return availableColumns.isEmpty();
    }

    public static void initializeGameBoard() {
        for(int i = 0; i < 7; i++){
            availableColumns.add(i+1);
        }
        System.out.println("Player 1 is X and Player 2 is O.");
        for (int i = 0; i < 6; i++) {
            Arrays.fill(gameBoard[i], '_');
        }
        Arrays.fill(columns, "Empty");
    }

    public static void printGameBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
    }

    public static void playGame() {
        if(Connect4.getGameTurns()%2!=0){
            player1 = true;
            System.out.print("Player X: ");
        }
        else {
            player1 = false;
            System.out.print("Player O: ");
        }

        System.out.print("Choose a column from the following: "+availableColumns+" : ");
        Scanner inputReader = new Scanner(System.in);
        try {
            columnNumber = inputReader.nextInt();
            while (columnNumber < 1 || columnNumber > 7 || columns[columnNumber-1].equals("Full")) {
                System.out.print("Invalid column. Choose a column from the following "+availableColumns+" : ");
                columnNumber = inputReader.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Choose a column from the following: "+availableColumns+" : ");
            inputReader.next();
            columnNumber = inputReader.nextInt();
        }

    }

    public static void lowestRowToInsert() {
        for (int i = 5; i >= 0; i--) {
            if (gameBoard[i][columnNumber - 1] == '_') {
                if(player1) gameBoard[i][columnNumber - 1] = 'X';
                else gameBoard[i][columnNumber - 1] = 'O';
                printGameBoard();
                if(i==0) {
                    columns[columnNumber-1] = "Full";
                    availableColumns.remove(Integer.valueOf(columnNumber));
                }
                break;
            }
        }
    }

    public static boolean checkForWin() {
        // Check horizontal

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                char c = gameBoard[row][col];
                if (c != '_' &&
                        c == gameBoard[row][col + 1] &&
                        c == gameBoard[row][col + 2] &&
                        c == gameBoard[row][col + 3]) {
                            System.out.println("Player " + c + " wins horizontally!");
                            return true;

                }
            }
        }

        // Check vertical
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                char c = gameBoard[row][col];
                if (c != '_' &&
                        c == gameBoard[row + 1][col] &&
                        c == gameBoard[row + 2][col] &&
                        c == gameBoard[row + 3][col]) {
                            System.out.println("Player " + c + " wins vertically!");
                            return true;
                }
            }
        }

        // Check diagonal (down-right)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                char c = gameBoard[row][col];
                if (c != '_' &&
                        c == gameBoard[row + 1][col + 1] &&
                        c == gameBoard[row + 2][col + 2] &&
                        c == gameBoard[row + 3][col + 3]) {
                            System.out.println("Player " + c + " wins diagonally!");
                            return true;
                }
            }
        }

        // Check diagonal (up-right)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                char c = gameBoard[row][col];
                if (c != '_' &&
                        c == gameBoard[row - 1][col + 1] &&
                        c == gameBoard[row - 2][col + 2] &&
                        c == gameBoard[row - 3][col + 3]) {
                            System.out.println("Player " + c + " wins diagonally!");
                            return true;
                }
            }
        }
        return false; // No winner yet
    }
}
