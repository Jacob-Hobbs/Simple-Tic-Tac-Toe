package tictactoe;

public class TicTacToeBoard {
    private String[][] ticTacToeArray;
    private String winner;

    public TicTacToeBoard() {
        this.ticTacToeArray = new String[3][5];
        this.winner = "none";
    }

    public String[][] getTicTacToeArray() {
        return this.ticTacToeArray;
    }

    public void setTicTacToeArray(String input) {
        int currentChar = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (j % 2 == 0) {
                    this.ticTacToeArray[i][j] = String.valueOf(input.charAt(currentChar));
                    currentChar++;
                } else {
                    this.ticTacToeArray[i][j] = " ";
                }
            }
        }
    }

    public String printTicTacToeBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int i = 0; i < 3; i++) {
            sb.append("| ");
            for (int j = 0; j < 5; j++) {
                sb.append(this.ticTacToeArray[i][j]);
            }
            sb.append(" |");
            sb.append("\n");
        }
        sb.append("---------");
        return String.valueOf(sb);
    }

    public String getResult(String input) {
        if (impossibleBoard(input)) {
            return "Impossible";
        } else if ((horizontalWin(input)) || (horizontalWin(input)) || (diagonalWin(input))) {
            return this.winner + " wins";
        } else if (!(horizontalWin(input) || horizontalWin(input) || diagonalWin(input))
                && (this.winner.equals("none")) && ((countSymbol(input, "X") +
                countSymbol(input, "O")) != 9)) {
            return "Game not finished";
        }
        return "Draw";
    }

    public boolean horizontalWin(String input) {

    }

    public boolean verticalWin(String input) {

    }

    public boolean diagonalWin(String input) {

    }

    // TODO: Set Impossible conditions:
    // TODO: 1. When the number of X's is two greater or more than O's (vice versa).
    // TODO: 2. When there are multiple winners (O-O-O & X-X-X).
    public boolean impossibleBoard(String input) {
        int xCount = countSymbol(input, "X");
        int oCount = countSymbol(input, "O");
        // Impossible when: the number of X's is two greater or more than O's (vice versa)
        if ((xCount - oCount >= 2) || (oCount - xCount >= 2)) {
            return true;
        }
        // Impossible when: there are multiple winners (O-O-O & X-X-X)
        // TODO: Create logic for condition 2
    }

    public int countSymbol(String input, String symbol) {
        int symbolCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(symbol)) {
                symbolCount++;
            }
        }
        return symbolCount;
    }
}
