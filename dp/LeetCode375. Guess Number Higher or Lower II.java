public class Solution {
    public int getMoneyAmount(int n) {
      int[][] dp = new int[n + 1][n + 1];
      for(int i = n; i >= 1; i--){
        dp[i][i] = 0;
        for(int j = i + 1; j <= n; j++){
          dp[i][j] = Integer.MAX_VALUE;
          for(int k = i; k <= j; k++)
            dp[i][j] = Math.min(dp[i][j],
                                k + Math.max(k == i ? 0 : dp[i][k-1],
                                             k == j ? 0 : dp[k+1][j]));
        }
      }
      return dp[1][n];
    }
}
