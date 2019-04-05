//
// A simple 2D Tic Tac Toe Game
//
// By: Ariessa Norramli
//

import java.util.Scanner;

public class TicTacToeGame {

  private char[][] board;
  private char currentPlayer;

  public TicTacToeGame() {
    board = new char[3][3];
    currentPlayer = 'X';
    initBoard();
  }

  // Set every spot in board to empty values
  public void initBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  // Print current board
  public void printBoard() {
    System.out.println("    0     1     2  ");
    System.out.println("       |     |     ");
    System.out.println(" 0  " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2]);
    System.out.println("  _____|_____|_____");
    System.out.println("       |     |     ");
    System.out.println(" 1  " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2]);
    System.out.println("  _____|_____|_____");
    System.out.println("       |     |     ");
    System.out.println(" 2  " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2]);
    System.out.println("       |     |     ");
  }

  // Check whether the board is full or not
  public Boolean isBoardFull() {
    Boolean isFull = true;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-')
          isFull = false;
      }
    }

    return isFull;
  }

  // Check whether there's a win
  public Boolean checkWin(int x, int y) {
    // Horizontal
    if (board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][y] == 'X')
      return true;

    // Vertical
    else if (board[0][y] == board[1][y] && board[1][y] == board[2][y] && board[x][y] == 'X')
      return true;

    // Diagonal
    else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[x][y] == board[1][1])
      return true;

    // Opposite Diagonal
    else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[x][y] == board[1][1])
      return true;

    else
      return false;
  }

  // Change Player
  public void changePlayer() {
    if (currentPlayer == 'X')
      currentPlayer = 'O';

    else
      currentPlayer = 'X';
  }

  // Check whether the spot is empty or not
  public Boolean isSpotEmpty(int row, int column) {
    if (board[row][column] == '-') {
      board[row][column] = currentPlayer;
      return true;
    }

    return false;
  }

  public static void main(String[] args) {

    TicTacToeGame game = new TicTacToeGame();

    Scanner scan = new Scanner(System.in);

    int x = 0;
    int y = 0;
    Boolean isInputValid = false;
    Boolean win = false;
    Boolean draw = false;

    while (isInputValid != true) {

      game.printBoard();

      System.out.print("Player [" + game.currentPlayer + "], please enter x value: ");

      if (scan.hasNextInt()) {
        x = scan.nextInt();
        isInputValid = true;

        if (x < 0 || x > 2) {
          System.out.println("Incorrect x value entered!");
          isInputValid = false;
          continue;
        }
      }

      else {
        System.out.println("Incorrect x value entered!");
        isInputValid = false;
        continue;
      }


      if (isInputValid == true) {
        System.out.print("Player [" + game.currentPlayer + "], please enter y value: ");

        if (scan.hasNextInt()) {
            y = scan.nextInt();
            isInputValid = true;

            if (y < 0 || y > 2) {
              System.out.println("Incorrect y value entered!");
              isInputValid = false;
              continue;
            }
        }

        else {
          System.out.println("Incorrect y value entered!");
          isInputValid = false;
          continue;
        }
      }

      if (game.isSpotEmpty(x, y) == true) {

        if (game.checkWin(x, y) == true) {
          System.out.println("Player [" + game.currentPlayer +"] has won the game!");
          return;
        }
      }

      else {
        System.out.println("That space is occupied!");
        isInputValid = false;
        continue;
      }

      if (game.isBoardFull()) {
        System.out.println("Game over! It's a draw!");
        return;
      }

      game.changePlayer();
      isInputValid = false;
    }
  }
}
