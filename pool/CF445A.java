/**
Fill each connect area with two colors.
*/

import java.util.*;
public class CF445A {
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n, m;
    n = cin.nextInt();
    m = cin.nextInt();
    char[][] board = new char[n][m];
    for (int i = 0; i < n; i++) {
      String temp = cin.next();
      for (int j = 0; j < m; j++) {
        board[i][j] = temp.charAt(j);
      }
    }

    solve(board);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  static void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          fill(board, i, j, 'W');
        }
      }
    }
  }

  static void fill(char[][] board, int x, int y, char color) {
    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == '.') {
      board[x][y] = color;
      for (int i = 0; i < dx.length; i++) {
        fill(board, x + dx[i], y + dy[i], opposite(color));
      }
    }
  }

  static char opposite(char color) {
    if (color == 'W')
      return 'B';
    else
      return 'W';
  }
}
