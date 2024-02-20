package tictactoe;

import java.util.Arrays;

public class GameInterface {
    private final TicTacToeBoard ticTacToeBoard;

    // Default constructor for GameInterface class
    public GameInterface() {
        this.ticTacToeBoard = new TicTacToeBoard();
    }

    public void start() {
        this.ticTacToeBoard.setTicTacToeArray();
        System.out.println(this.ticTacToeBoard.printTicTacToeBoard());
    }

}
