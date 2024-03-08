import java.util.Scanner;

public class Connect4 {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    private char[][] board;
    private int lastRow;
    private int lastCol;
    private char currentPlayer;

    public Connect4() {
        board = new char[ROWS][COLUMNS];
        initializeBoard();
        currentPlayer = PLAYER1;
    }

    public void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        for (int col = 0; col < COLUMNS * 4 + 1; col++) {
            System.out.print("-");
        }
        System.out.println();
        for (int col = 0; col < COLUMNS; col++) {
            System.out.print("  " + (col + 1) + " ");
        }
        System.out.println();
    }

    public boolean dropPiece(int col) {
        if (col < 0 || col >= COLUMNS) {
            System.out.println("Invalid column number! Please choose a column between 1 and " + COLUMNS);
            return false;
        }

        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                lastRow = row;
                lastCol = col;
                return true;
            }
        }

        System.out.println("Column is full! Choose another column.");
        return false;
    }

    public boolean checkWinner() {
        // Check horizontally
        for (int col = 0; col <= COLUMNS - 4; col++) {
            for (int row = 0; row < ROWS; row++) {
                if (board[row][col] == currentPlayer &&
                    board[row][col + 1] == currentPlayer &&
                    board[row][col + 2] == currentPlayer &&
                    board[row][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check vertically
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] == currentPlayer &&
                    board[row + 1][col] == currentPlayer &&
                    board[row + 2][col] == currentPlayer &&
                    board[row + 3][col] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check diagonally (bottom-left to top-right)
        for (int col = 0; col <= COLUMNS - 4; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] == currentPlayer &&
                    board[row + 1][col + 1] == currentPlayer &&
                    board[row + 2][col + 2] == currentPlayer &&
                    board[row + 3][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check diagonally (top-left to bottom-right)
        for (int col = 0; col <= COLUMNS - 4; col++) {
            for (int row = 3; row < ROWS; row++) {
                if (board[row][col] == currentPlayer &&
                    board[row - 1][col + 1] == currentPlayer &&
                    board[row - 2][col + 2] == currentPlayer &&
                    board[row - 3][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    public void switchPlayer() {
        if (currentPlayer == PLAYER1) {
            currentPlayer = PLAYER2;
        } else {
            currentPlayer = PLAYER1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connect4 game = new Connect4();

        boolean gameWon = false;
        while (!gameWon) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + "'s turn. Choose a column (1-" + COLUMNS + "):");
            int col = scanner.nextInt() - 1;

            if (game.dropPiece(col)) {
                if (game.checkWinner()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    gameWon = true;
                } else {
                    game.switchPlayer();
                }
            }
        }
        scanner.close();
    }
}