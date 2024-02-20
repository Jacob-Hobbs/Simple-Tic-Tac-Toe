package tictactoe;

import java.sql.SQLOutput;
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

    // Method to maintain flow of current game logic
    public void start() {

        String input = scanner.nextLine();
        this.ticTacToeBoard.setTicTacToeArray(input);
        System.out.println(this.ticTacToeBoard.printTicTacToeBoard());
        System.out.println(this.ticTacToeBoard.getResult(input));
    }
}
