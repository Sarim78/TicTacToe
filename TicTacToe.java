import java.util.Scanner;

public class TicTacToe {
  static final int ROWS = 3, COLUMNS = 3;
  static int[][] board = new int[ROWS][COLUMNS];
  static Scanner sc = new Scanner(System.in);
  static int turn = 1;

  public static void main(String[] args) {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        board[i][j] = 0;
      }
    }

    while (true) {
      displayBoard();
      playerMove();
      if (checkForWin()) {
        System.out.println("Player " + turn + " wins!");
        break;
      }
      if (checkForDraw()) {
        System.out.println("Draw.");
        break;
      }
      turn = turn == 1 ? 2 : 1;
    }
  }

  static void displayBoard() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        System.out.print(board[i][j] == 0 ? "-" : board[i][j] == 1 ? "X" : "O");
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  static void playerMove() {
    int row, column;
    do {
      System.out.println("Player " + turn + " move (row column): ");
      row = sc.nextInt() - 1;
      column = sc.nextInt() - 1;
    } while (board[row][column] != 0);
    board[row][column] = turn;
  }

  static boolean checkForWin() {
    for (int i = 0; i < ROWS; i++) {
      if (board[i][0] == turn && board[i][1] == turn && board[i][2] == turn) {
        return true;
      }
    }
    for (int j = 0; j < COLUMNS; j++) {
      if (board[0][j] == turn && board[1][j] == turn && board[2][j] == turn) {
        return true;
      }
    }
    if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
      return true;
    }
    if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn) {
      return true;
    }
    return false;
  }

  static boolean checkForDraw() {
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLUMNS; j++) {
        if (board[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }
}