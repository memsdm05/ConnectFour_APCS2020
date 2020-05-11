
public class ConnectFour implements BoardGame{
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;

    private int winner;

    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1;
        winner = 0;
    }

    public boolean gameOver() {
        currentPlayer = (currentPlayer == 1)? 2 : 1;
        winCheck();
        currentPlayer = (currentPlayer == 1)? 2 : 1;
        return  winner > 0 || boardFull();
    }

    public int getWinner() {
        return winner;
    }

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


    public int[][] getBoard() {
        return board;
    }
}
