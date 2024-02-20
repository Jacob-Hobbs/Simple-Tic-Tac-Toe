package tictactoe;

public class TicTacToeBoard {
    private String[][] ticTacToeArray;

    public TicTacToeBoard() {
        this.ticTacToeArray = new String[3][5];
    }

    public String[][] getTicTacToeArray() {
        return this.ticTacToeArray;
    }

    // TODO: Implement filling array[][] with user input
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


}
