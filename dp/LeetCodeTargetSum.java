public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
      //exclude corner cases
      if(S > 1000 || S < -1000) return 0;
      if(nums.length == 0) return 0;

      //get length of nums for convinience
      int n = nums.length;
      //initialize dp array
      int[][] dp = new int[n][2001];//dp[i][j] := # of ways to constitute j - 1000 using nums[0] ~ nums[i]
      for(int i = 0; i < n; i++)
        Arrays.fill(dp[i], 0);
      dp[0][1000 + nums[0]] += 1;
      dp[0][1000 - nums[0]] += 1;
      //update dp array
      for(int i = 0; i < n - 1; i++){
          for(int j = 0; j < 2001; j++){
            if(dp[i][j] != 0){
              int temp = nums[i + 1];
              if(0 <= j + temp && j + temp <= 2000) dp[i + 1][j + temp] += dp[i][j];
              if(0 <= j - temp && j - temp <= 2000) dp[i + 1][j - temp] += dp[i][j];
            }
          }
      }
      //return result
      return dp[n - 1][1000 + S];
    }
}
