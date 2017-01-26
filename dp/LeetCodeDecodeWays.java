public class Solution {
  public int numDecodings(String s) {
    // exclude corner cases
    if (s.isEmpty())
      return 0;

    int n = s.length();
    int[] dp = new int[n];
    // Be caution for dp[1]
    // Be caution for 0. 0001 is not valid.
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        if (Integer.parseInt(s.substring(0, 1)) == 0)
          dp[0] = 0;
        else
          dp[0] = 1;
      } else if (i == 1) {
        int twoToken = Integer.parseInt(s.substring(0, 2));
        int oneToken = Integer.parseInt(s.substring(1, 2));

        if (10 <= twoToken && twoToken <= 26 && oneToken != 0)
          dp[1] = dp[0] + 1;
        else if (10 <= twoToken && twoToken <= 26)
          dp[1] = 1;
        else if (oneToken != 0)
          dp[1] = dp[0];
        else
          dp[1] = 0;
      } else {
        int twoToken = Integer.parseInt(s.substring(i - 1, i + 1));
        int oneToken = Integer.parseInt(s.substring(i, i + 1));

        if (10 <= twoToken && twoToken <= 26 && oneToken != 0)
          dp[i] = dp[i - 1] + dp[i - 2];
        else if (10 <= twoToken && twoToken <= 26)
          dp[i] = dp[i - 2];
        else if (oneToken != 0)
          dp[i] = dp[i - 1];
        else
          dp[i] = 0;
      }
    }
    return dp[n - 1];
  }
}
