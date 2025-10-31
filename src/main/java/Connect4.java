import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    static char[][] gameBoard = new char[6][7];
    static int columnNumber;
    static char playerType;

    public static void initializeGameBoard() {
        for (int i = 0; i < 6; i++) {
            Arrays.fill(gameBoard[i], '_');
        }
    }

    public static void printGameBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(gameBoard[i]));
        }
    }

    public static void playGame() {
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Choose X or O to play: ");
        playerType = inputReader.next().toUpperCase().charAt(0);

        System.out.print("Choose a column to insert (1–7): ");
        columnNumber = inputReader.nextInt();

        while (columnNumber < 1 || columnNumber > 7) {
            System.out.print("Invalid column. Choose between 1–7: ");
            columnNumber = inputReader.nextInt();
        }
    }

    public static boolean lowestRowToInsert() {
        for (int i = 5; i >= 0; i--) {
            if (gameBoard[i][columnNumber - 1] == '_') {
                gameBoard[i][columnNumber - 1] = playerType;
                printGameBoard();
                return true;
            }
        }
        System.out.println("Column full! Try again.");
        return false;
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
