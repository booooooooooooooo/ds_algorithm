import java.util.*;
import java.lang.Math;

public class Poj1163 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    // n is number of rows
    int n = cin.nextInt();

    // Read in triangle
    int triangle[][] = new int[n][];
    for (int i = 0; i < n; i++) {
      triangle[i] = new int[i + 1];
      for (int j = 0; j <= i; j++) {
        triangle[i][j] = cin.nextInt();
      }
    }

    // Initialize DP array
    int dp[][] = new int[n][];
    for (int i = 0; i < n; i++) {
      dp[i] = new int[i + 1];
      for (int j = 0; j <= i; j++) {
        dp[i][j] = -1;
      }
    }

    // Get and print result
    int result = solve(0, 0, n, triangle, dp);
    System.out.println(result);
  }

  public static int solve(int row, int col, int n, int[][] triangle,
                          int[][] dp) {
    if (dp[row][col] >= 0) {
      return dp[row][col];
    }
    int rest;
    if (row == n - 1) {
      rest = 0;
    } else {
      rest = Math.max(solve(row + 1, col, n, triangle, dp),
                      solve(row + 1, col + 1, n, triangle, dp));
    }
    return dp[row][col] = rest + triangle[row][col];
  }
}
