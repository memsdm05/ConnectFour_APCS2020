/**
 * Connect Four
 *
 * @since 5/11/2020
 * @author Ben Browner
 */

public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;

    private int winner;

    /**
     * Prepares the board for a new game.
     */
    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1;
        winner = 0;
    }

    /**
     * Is the game over?
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver() {
        currentPlayer = (currentPlayer == 1)? 2 : 1;
        winCheck();
        currentPlayer = (currentPlayer == 1)? 2 : 1;
        return  winner > 0 || boardFull();
    }

    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public Position[] getWinningPositions() {
        return winningPositions;
    }


    private void winCheck() {
        winningPositions = new Position[]{new Position()};

        // Horizontal Check
        for (int j = 0; j < board[0].length - 3; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == currentPlayer
                        && board[i][j + 1] == currentPlayer
                        && board[i][j + 2] == currentPlayer
                        && board[i][j + 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j),
                            new Position(i, j+1),
                            new Position(i, j+2),
                            new Position(i, j+3)};
                    winner = currentPlayer;
                }
            }
        }
        // Vertical Check
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == currentPlayer
                        && board[i + 1][j] == currentPlayer
                        && board[i + 2][j] == currentPlayer
                        && board[i + 3][j] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j),
                            new Position(i+1, j),
                            new Position(i+2, j),
                            new Position(i+3, j)};
                    winner = currentPlayer;
                }
            }
        }
        // Ascending Diagonal Check
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == currentPlayer
                        && board[i - 1][j + 1] == currentPlayer
                        && board[i - 2][j + 2] == currentPlayer
                        && board[i - 3][j + 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j),
                            new Position(i-1, j+1),
                            new Position(i-2, j+2),
                            new Position(i-3, j+3)};
                    winner = currentPlayer;
                }
            }
        }
        // Descending Diagonal Check
        for (int i = 3; i < board.length; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (board[i][j] == currentPlayer
                        && board[i - 1][j - 1] == currentPlayer
                        && board[i - 2][j - 2] == currentPlayer
                        && board[i - 3][j - 3] == currentPlayer) {
                    winningPositions = new Position[]{new Position(i, j),
                            new Position(i-1, j-1),
                            new Position(i-2, j-2),
                            new Position(i-3, j-3)};
                    winner = currentPlayer;
                }
            }
        }
    }

    /**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
    public boolean columnFull(int column) {
        return board[0][column] > 0;
    }

    private boolean boardFull() {
        int full = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (columnFull(col)) {
                full++;
            }
        }
        return full == board[0].length;
    }

    /**
     * Change the game to reflect the current player placing a piece in the column.
     * @param column the column number
     */
    public void play(int column) {
        if (!columnFull(column)) {
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][column] == 0) {
                    board[i][column] = currentPlayer;
                    currentPlayer = (currentPlayer == 1)? 2 : 1;
                    return;
                }
            }
        }
    }

    /**
     * What is the current board configuration?
     * @return for each cell on the board grid:
     *   0 if it is not filled,
     *   1 if it is filled by the first player's piece,
     *   2 if it is filled by the second player's piece.
     */
    public int[][] getBoard() {
        return board;
    }
}
