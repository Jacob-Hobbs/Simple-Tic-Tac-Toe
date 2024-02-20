package tictactoe;

public class TicTacToeBoard {
    private String[][] ticTacToeArray;

    public TicTacToeBoard() {
        this.ticTacToeArray = new String[3][5];
    }

    public String[][] getTicTacToeArray() {
        return this.ticTacToeArray;
    }

    public void setTicTacToeArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 2) {
                    if (j % 2 == 0) {
                        this.ticTacToeArray[i][j] = "X";
                    } else {
                        this.ticTacToeArray[i][j] = " ";
                    }
                } else {
                    if (j % 2 == 0) {
                        this.ticTacToeArray[i][j] = "O";
                    } else {
                        this.ticTacToeArray[i][j] = " ";
                    }
                }
            }
        }
    }

    public String printTicTacToeBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(this.ticTacToeArray[i][j]);
            }
            sb.append("\n");
        }
        return String.valueOf(sb);
    }


}
