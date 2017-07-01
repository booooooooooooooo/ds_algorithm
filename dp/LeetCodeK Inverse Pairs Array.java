public class Solution {
    public int kInversePairs(int n, int k) {
      //corner: meaningless input
      if(n <= 0) return 0;
      if(k < 0) return 0;
      //impossible task
      if(k > n * (n - 1) / 2) return 0;
      //possible task
      int[][] dp = new int[n + 1][k + 1];
      for(int i = 0; i < n + 1; i++) Arrays.fill(dp[i], 0);
      dp[1][0] = 1;
      for(int i = 2; i < n + 1; i++)
        for(int j = 0; j < k + 1; j++){
          if(j == 0) dp[i][j] = 1;
          else if( (j-1) - (i-1) >= 0 ) dp[i][j] = ( (dp[i-1][j] + dp[i][j-1] - dp[i-1][(j-1)-(i-1)])% (1000000000 + 7) + (1000000000 + 7) ) % (1000000000 + 7);
          else dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % (1000000000 + 7);

        }
      return dp[n][k];
    }
}
