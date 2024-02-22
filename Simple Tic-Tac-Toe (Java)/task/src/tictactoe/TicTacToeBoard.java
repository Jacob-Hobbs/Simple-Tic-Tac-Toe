package tictactoe;

import java.util.ArrayList;

public class TicTacToeBoard {
    private String[][] ticTacToeArray;
    private String winner;

    private ArrayList<String> winnerList;

    // TicTacToeBoard default constructor
    public TicTacToeBoard() {
        this.ticTacToeArray = new String[3][5];
        this.winner = "none";
        this.winnerList = new ArrayList<>();
    }

    // Method to return TicTacToe board as array[][]
    public String[][] getTicTacToeArray() {
        return this.ticTacToeArray;
    }

    // Method to set the values of the TicTacToe board according to user input
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

    // Method to output current TicTacToe board to terminal with styling
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

    // Method to output result of TicTacToe game given user input
    public String getResult(String input) {
        if (impossibleBoard(input)) {
            return "Impossible";
        }
        this.winnerList.clear();
        if ((horizontalWin(input)) || (verticalWin(input)) || (diagonalWin(input))) {
            return this.winner + " wins";
        } else if (!(horizontalWin(input) || verticalWin(input) || diagonalWin(input))
                && (this.winner.equals("none")) && ((countSymbol(input, "X") +
                countSymbol(input, "O")) != 9)) {
            return "Game not finished";
        }
        return "Draw";
    }

    // Method to return boolean depending on horizontal win condition
    public boolean horizontalWin(String input) {
        boolean returnBoolean = false;
        for (int i = 0; i < 2; i++) {
            String symbol = i == 0 ? "X" : "O";
            if (winCondition(0, 1, 2, input, symbol)) {
                returnBoolean = true;
            }
            if (winCondition(3, 4, 5, input, symbol)) {
                returnBoolean = true;
            }
            if (winCondition(6, 7, 8, input, symbol)) {
                returnBoolean = true;
            }
        }
        if (!this.winnerList.isEmpty()) {
            this.winner = this.winnerList.get(0);
        }
        return returnBoolean;
    }

    // Method to return boolean depending on vertical win condition
    public boolean verticalWin(String input) {
        boolean returnBoolean = false;
        for (int i = 0; i < 2; i++) {
            String symbol = i == 0 ? "X" : "O";
            if (winCondition(0, 3, 6, input, symbol)) {
                returnBoolean = true;
            }
            if (winCondition(1, 4, 7, input, symbol)) {
                returnBoolean = true;
            }
            if (winCondition(2, 5, 8, input, symbol)) {
                returnBoolean = true;
            }
        }
        if (!this.winnerList.isEmpty()) {
            this.winner = this.winnerList.get(0);
        }
        return returnBoolean;
    }

    // Method to return boolean depending on diagonal win condition
    public boolean diagonalWin(String input) {
        boolean returnBoolean = false;
        for (int i = 0; i < 2; i++) {
            String symbol = i == 0 ? "X" : "O";
            if (winCondition(0, 4, 8, input, symbol)) {
                returnBoolean = true;
            }
            if (winCondition(2, 4, 6, input, symbol)) {
                returnBoolean = true;
            }
        }
        if (!this.winnerList.isEmpty()) {
            this.winner = this.winnerList.get(0);
        }
        return returnBoolean;
    }

    // Method to determine if user input describes impossible gameplay scenario
    public boolean impossibleBoard(String input) {
        int xCount = countSymbol(input, "X");
        int oCount = countSymbol(input, "O");
        // Impossible when: the number of X's is two greater or more than O's (vice versa)
        if ((xCount - oCount >= 2) || (oCount - xCount >= 2)) {
            return true;
        }
        // Impossible when: there are multiple winners (O-O-O & X-X-X)
        if ((horizontalWin(input) || verticalWin(input) || diagonalWin(input)) &&
                (this.winnerList.contains("X") && this.winnerList.contains("O"))) {
            return true;
        }
        return false;
    }

    // Method to count how many of each X's and O's have been played
    public int countSymbol(String input, String symbol) {
        int symbolCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(symbol)) {
                symbolCount++;
            }
        }
        return symbolCount;
    }

    public boolean winCondition(int x, int y, int z, String input, String symbol) {
        if ((String.valueOf(input.charAt(x)).equals(symbol) &&
                String.valueOf(input.charAt(y)).equals(symbol)
                && String.valueOf(input.charAt(z)).equals(symbol))) {
            this.winnerList.add(symbol);
            return true;
        }
        return false;
    }
}
