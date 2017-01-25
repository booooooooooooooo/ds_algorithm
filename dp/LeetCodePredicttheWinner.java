public class Solution {
    public boolean PredictTheWinner(int[] nums) {
      //exclude corner cases
      if(nums.length == 0) return false;
      //get length of nums for convinience
      int n = nums.length;
      //initialize dp array
      int[][] dp = new int[n][n];//dp[i][j] := maximum value of (player1's score - player2's score) when they compete on [i, j] and player1 picks first
      //update dp array
      for(int i = n - 1; i >= 0; i--){
        for(int j = i; j <= n - 1; j++){
          if(i == j)
            dp[i][j] = nums[i];
          else if(i + 1 == j)
            dp[i][j] = Math.abs(nums[i] - nums[j]);
          else{
            dp[i][j] = Math.max(Math.min(dp[i + 1][j - 1] + nums[i] - nums[j], dp[i + 2][j] + nums[i] - nums[i + 1]),
                                Math.min( dp[i + 1][j - 1]+ nums[j] - nums[i], dp[i][j - 2] + nums[j] - nums[j - 1] ));
          }
        }
      }
      //return result
      return dp[0][n - 1] >= 0 ? true : false;
    }
}
