    import java.util.Arrays;
    import java.util.Scanner;

    public class GameBoard {
        // create and initialize gameboard
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
            // Add player 2 and don't ask for this every time later.
            System.out.println("Choose X or O to play: ");
            Scanner inputReader = new Scanner(System.in);
             playerType = inputReader.next().charAt(0);
            System.out.println("Choose a column to insert: 1, 2, 3, 4, 5, 6, 7 ");
            columnNumber = inputReader.nextInt();

        }

        public static void lowestRowToInsert(){
            // figure out which row to insert X or O based on user's column choice
            int i ;
            boolean inserted = false;
            for(i = 5; i >= 0; i--) {
                if(gameBoard[i][columnNumber-1] == '_' && !inserted){
                    gameBoard[i][columnNumber-1] = playerType;
                    inserted = true;
                }
            }
            printGameBoard();
        }

        /*
        ADD method to check if four in a row/column or diagonal.



         */
    }
