/**
DP
*/
public class Solution {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 1;
        else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}

import java.math.BigInteger;
public class LeetCodeUniquePaths {
  public int uniquePaths(int m, int n) {
    BigInteger count = BigInteger.valueOf(1);
    ;
    for (int i = n - 1 + 1; i <= n - 1 + m - 1; i++)
      count = count.multiply(BigInteger.valueOf(i));
    // System.out.println(count);
    for (int i = 1; i <= m - 1; i++)
      count = count.divide(BigInteger.valueOf(i));
    // System.out.println(count);
    return Integer.parseInt(count.toString());
  }
}
