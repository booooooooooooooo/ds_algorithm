public class Solution {
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();

    boolean[] matchEmpty = new boolean[n];
    Arrays.fill(matchEmpty, false);
    for (int i = 0; i < n; i++) {
      if (p.charAt(i) != '*')
        break;
      matchEmpty[i] = true;
    }

    if (m == 0 && n == 0)
      return true;
    else if (m == 0) {
      return matchEmpty[n - 1];
    } else if (n == 0) {
      return false;
    } else {
      boolean[][] dp = new boolean[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (isMatchedChar(s.charAt(i), p.charAt(j))) {
            if (i == 0 && j == 0)
              dp[i][j] = true;
            else if (i == 0)
              dp[i][j] = matchEmpty[j - 1];
            else if (j == 0)
              dp[i][j] = false;
            else
              dp[i][j] = dp[i - 1][j - 1];
          } else if (p.charAt(j) == '*') {
            dp[i][j] = (j - 1 >= 0 ? dp[i][j - 1] : false) ||
                       (i - 1 >= 0 ? dp[i - 1][j] : matchEmpty[j]);
          } else {
            dp[i][j] = false;
          }
        }
      }
      return dp[m - 1][n - 1];
    }
  }
  public boolean isMatchedChar(char x, char y) {
    if (x == y || y == '?')
      return true;
    else
      return false;
  }
}
