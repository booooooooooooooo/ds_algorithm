public class Solution {
    public int maxCoins(int[] nums) {
      //exluce corner case
      if(nums.length == 0) return 0;
      //*******************
      int n = nums.length;
      int[][] dp = new int[n][n];//dp[0][n-1] is result
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          dp[i][j] = -1;
        }
      }
      for(int len = 0; len <= n - 1; len++){
        for(int left = 0; left + len <= n - 1; left++){
          int right = left + len;
          for(int i = left; i <= right; i++){
            int boundLeft = left == 0 ? 1 : nums[left - 1];
            int boundRight = right == n - 1 ? 1 : nums[right + 1];
            int partLeft = i == left ? 0 : dp[left][i-1];
            int partRight = right == i ? 0 : dp[i+1][right];
            dp[left][right] = Math.max(dp[left][right], boundLeft*nums[i]*boundRight + partLeft + partRight);
          }
        }
      }
      return dp[0][n-1];
    }
}
