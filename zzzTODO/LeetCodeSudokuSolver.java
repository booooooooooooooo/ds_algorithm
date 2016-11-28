import java.util.*;
public class Solution {
  public boolean answerFound;
  public final int[] dx = {1, 0, -1, 0};
  public final int[] dy = {0, 1, 0, -1};
  public Solution() { answerFound = false; }
  public void solveSudoku(char[][] board) { solve(board, 0, 0); }

  public void solve(char[][] board, int x, int y) {

    // base case
    if (isValidSudoku(board)) {
      answerFound = true;
      return;
    }

    // valid position and needs recursion
    if (0 <= x && x < board.length && 0 <= y && y < board.length &&
        board[x][y] == '.') {
      for (int value = 1; value <= 9; value++) {
        for (int i = 0; i < 4; i++) {
          board[x][y] = (char)(value + '0');
          solve(board, x + dx[i], y + dy[i]);
          if (answerFound)
            return;
          board[x][y] = '.';
        }
      }
    }
  }

  public boolean isValidSudoku(char[][] board) {
    return isValidRow(board) && isValidColumn(board) && isValidGrid(board);
  }

  public boolean isValidRow(char[][] board) {
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    for (int i = 0; i < board.length; i++) {
      table.clear();
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.' ||
            table.containsKey(Character.toString(board[i][j])))
          return false;
        table.put(Character.toString(board[i][j]), 888);
      }
    }
    return true;
  }

  public boolean isValidColumn(char[][] board) {
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    for (int j = 0; j < board.length; j++) {
      table.clear();
      for (int i = 0; i < board.length; i++) {
        if (board[i][j] == '.' ||
            table.containsKey(Character.toString(board[i][j])))
          return false;
        table.put(Character.toString(board[i][j]), 888);
      }
    }
    return true;
  }

  public boolean isValidGrid(char[][] board) {
    Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    for (int x = 0; x < board.length; x = x + 3) {
      for (int y = 0; y < board.length; y = y + 3) {
        table.clear();
        for (int i = x; i < x + 3; i++) {
          for (int j = y; j < y + 3; j++) {
            if (board[i][j] == '.' ||
                table.containsKey(Character.toString(board[i][j])))
              return false;
            table.put(Character.toString(board[i][j]), 888);
          }
        }
      }
    }
    return true;
  }
}
