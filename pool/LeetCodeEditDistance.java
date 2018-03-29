public class Solution {
  public int minDistance(String word1, String word2) {
    // corner cases TODO
    if (word1.length() == 0)
      return word2.length();
    if (word2.length() == 0)
      return word1.length();

    final int m = word1.length();
    final int n = word2.length();
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[0][0] = (word1.charAt(0) == word2.charAt(0)) ? 0 : 1;
        } else if (i == 0) {
          dp[0][j] =
              (word1.charAt(0) == word2.charAt(j)) ? j : dp[0][j - 1] + 1;
        } else if (j == 0) {
          dp[i][0] =
              (word1.charAt(i) == word2.charAt(0)) ? i : dp[i - 1][0] + 1;
        } else {
          dp[i][j] =
              (word1.charAt(i) == word2.charAt(j))
                  ? dp[i - 1][j - 1]
                  : (Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                              dp[i - 1][j - 1] + 1));
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
