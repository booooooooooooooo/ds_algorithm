import java.util.*;

public class Poj1979 {
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNext()) {
      int w = cin.nextInt();
      int h = cin.nextInt();
      if (w == 0 && h == 0) {
        break;
      }
      int[][] floor = new int[h][w];
      for (int y = 0; y < h; y++) {
        String temp = cin.next();
        for (int x = 0; x < w; x++) {
          floor[y][x] = temp.charAt(x);
        }
      }
      System.out.println(solve(floor, h, w));
    }
  }

  private static int solve(int[][] floor, int h, int w) {
    boolean[][] walk = new boolean[h][w];
    int startY = 30;
    int startX = 30;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        walk[y][x] = false;
        if (floor[y][x] == '@') {
          startY = y;
          startX = x;
        }
      }
    }
    dfs(walk, floor, startY, startX);
    int count = 0;
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (walk[y][x] == true) {
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(boolean[][] walk, int[][] floor, int y, int x) {
    if (y >= 0 && y < floor.length && x >= 0 && x < floor[0].length
        && (floor[y][x] == '.' || floor[y][x] == '@') && walk[y][x] == false) {
      walk[y][x] = true;
      for (int i = 0; i < dx.length; i++) {
        dfs(walk, floor, y + dy[i], x + dx[i]);
      }
    }
  }
}