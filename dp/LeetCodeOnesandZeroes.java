/**
 * Recursion
 */
public class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int l = strs.length;
    // count number of zero and one of each string in strs
    int[][] freqArr = new int[l][2];
    for (int i = 0; i < l; i++)
      Arrays.fill(freqArr[i], 0);
    for (int i = 0; i < l; i++) {
      String s = strs[i];
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '0') {
          freqArr[i][0]++;
        } else {
          freqArr[i][1]++;
        }
      }
    }
    // initialize dp arrays
    int[][][] dp = new int[l][m + 1][n + 1];
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < m + 1; j++) {
        for (int k = 0; k < n + 1; k++)
          dp[i][j][k] = -1;
      }
    }
    // call dfs and return result. Use dp to memorized sub solution.
    return dfs(l - 1, m, n, freqArr, dp);
  }

  public int dfs(int index, int zeroLeft, int oneLeft, int[][] freqArr,
                 int[][][] dp) {
    if (index < 0)
      return 0;
    else {
      if (dp[index][zeroLeft][oneLeft] != -1)
        return dp[index][zeroLeft][oneLeft];

      int zeroAtIndex = freqArr[index][0];
      int oneAtIndex = freqArr[index][1];
      int result =
          (zeroAtIndex > zeroLeft || oneAtIndex > oneLeft)
              ? dfs(index - 1, zeroLeft, oneLeft, freqArr, dp)
              : Math.max(dfs(index - 1, zeroLeft, oneLeft, freqArr, dp),
                         1 + dfs(index - 1, zeroLeft - zeroAtIndex,
                                 oneLeft - oneAtIndex, freqArr, dp));
      dp[index][zeroLeft][oneLeft] = result;
      return result;
    }
  }
}

/**
 * Iteration
 */
public class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int l = strs.length;
    // count number of zero and one of each string in strs
    int[][] freqArr = new int[l][2];
    for (int i = 0; i < l; i++)
      Arrays.fill(freqArr[i], 0);
    for (int i = 0; i < l; i++) {
      String s = strs[i];
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '0') {
          freqArr[i][0]++;
        } else {
          freqArr[i][1]++;
        }
      }
    }
    // initialize dp arrays
    int[][][] dp = new int[m + 1][n + 1][l];
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        for (int k = 0; k < l; k++) {
          int zeroAtIndex = freqArr[k][0];
          int oneAtIndex = freqArr[k][1];
          if (zeroAtIndex > i || oneAtIndex > j) {
            dp[i][j][k] = (k == 0) ? 0 : dp[i][j][k - 1];
          } else {
            dp[i][j][k] =
                (k == 0)
                    ? 1
                    : Math.max(dp[i][j][k - 1],
                               dp[i - zeroAtIndex][j - oneAtIndex][k - 1] + 1);
          }
        }
      }
    }
    // return result
    return dp[m][n][l - 1];
  }
}
