import java.util.*;
public class Poj3176 {
  public static int n;
  public static int[][] highest;
  public static int[][] triangle;
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    n = cin.nextInt();
    highest = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(highest[i], -1);
    }

    triangle = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = cin.nextInt();
      }
    }
    System.out.println(solve(0, 0));
  }
  private static int solve(int i, int j) {
    if (highest[i][j] != -1)
      return highest[i][j];
    int res;
    if (i == n - 1) {
      res = triangle[i][j];
    } else {
      res = Math.max(solve(i + 1, j), solve(i + 1, j + 1)) + triangle[i][j];
    }
    highest[i][j] = res;
    return res;
  }
}
