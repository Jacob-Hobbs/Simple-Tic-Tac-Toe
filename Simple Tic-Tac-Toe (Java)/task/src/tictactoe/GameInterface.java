package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameInterface {
    private final TicTacToeBoard ticTacToeBoard;
    private final Scanner scanner;

    // Default constructor for GameInterface class
    public GameInterface() {
        this.ticTacToeBoard = new TicTacToeBoard();
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        String input = scanner.nextLine();
        this.ticTacToeBoard.setTicTacToeArray(input);
        System.out.println(this.ticTacToeBoard.printTicTacToeBoard());
    }

}
