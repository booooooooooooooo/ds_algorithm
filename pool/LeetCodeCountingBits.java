public class Solution {
    public int[] countBits(int num) {
      //corner cases
      if(num == 0) return new int[]{0};

      int[] dp = new int[num + 1];
      dp[0] = 0;
      dp[1] = 1;
      int left = 2;
      while(left <= num){
        for(int i = left; i < Math.min(num + 1,left*2); i++){
          dp[i]  = 1 + dp[i%left];
        }
        left *= 2;
      }
      return dp;
    }
}
