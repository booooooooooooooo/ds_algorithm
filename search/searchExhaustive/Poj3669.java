import java.util.*;

public class Poj3669 {
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static Integer INF = Integer.MAX_VALUE;

  public static void main(String args[]) {
    int[][] strikeT = new int[300][300];
    for (int j = 0; j < strikeT.length; j++) {
      Arrays.fill(strikeT[j], 1001);
    }

    Scanner cin = new Scanner(System.in);
    int m = cin.nextInt();
    for (int i = 0; i < m; i++) {
      int x = cin.nextInt();
      int y = cin.nextInt();
      int t = cin.nextInt();
      update(strikeT, x, y, t);
    }
    System.out.println(solve(strikeT));
  }

  // update the time of the centor and the four lattices. Shorter time is what I want.
  private static void update(int[][] strikeT, int x, int y, int t) {
    if (strikeT[y][x] > t) {
      strikeT[y][x] = t;
    }
    for (int i = 0; i < dx.length; i++) {
      int nextY = y + dy[i];
      int nextX = x + dx[i];
      if (nextY >= 0 && nextY < strikeT.length && nextX >= 0 && nextX < strikeT[0].length
          && strikeT[nextY][nextX] > t) {
        strikeT[nextY][nextX] = t;
      }
    }
  }

  private static int solve(int[][] strikeT) {
    return bfs(strikeT);
  }

  private static int bfs(int[][] strikeT) {
    int[][] moveT = new int[300][300];
    for (int j = 0; j < moveT.length; j++) {
      Arrays.fill(moveT[j], INF);
    }
    Queue<Integer> Y = new ArrayDeque<Integer>();
    Queue<Integer> X = new ArrayDeque<Integer>();
    Queue<Integer> T = new ArrayDeque<Integer>();
    Y.add(0);
    X.add(0);
    T.add(0);
    moveT[0][0] = 0;
    while (!Y.isEmpty()) {
      int y = Y.remove();
      int x = X.remove();
      int t = T.remove();
      if (strikeT[y][x] == 1001)
        return t;
      for (int i = 0; i < dx.length; i++) {
        int nextY = y + dy[i];
        int nextX = x + dx[i];
        if (nextY >= 0 && nextY < strikeT.length && nextX >= 0 && nextX < strikeT[0].length
            && moveT[nextY][nextX] == INF && t + 1 < strikeT[nextY][nextX]) {
          Y.add(nextY);
          X.add(nextX);
          T.add(t + 1);
          moveT[nextY][nextX] = t + 1;
        }
      }
    }
    return -1;
  }
}
