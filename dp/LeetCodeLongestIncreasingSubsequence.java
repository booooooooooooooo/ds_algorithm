public class Solution {
    public int lengthOfLIS(int[] nums) {
      //exclude corner case
      if(nums.length == 0) return 0;

      //dp[i] = mininum end number with length i + 1
      int[] dp = new int[nums.length];
      int pointerToAppendForDP = 0;
      for(int x : nums){
        int lowerBound = getLowerBound(dp, pointerToAppendForDP, x);
        if(lowerBound == pointerToAppendForDP){
          dp[pointerToAppendForDP] = x;
          pointerToAppendForDP++;
        }else{
          dp[lowerBound] = x;
        }
      }
      return (pointerToAppendForDP - 1) + 1;
    }
    public int getLowerBound(int[] dp, int pointerToAppendForDP, int x){
      int low = 0;
      int high = pointerToAppendForDP;//[low, high)
      while(low < high){
        int mid = low + (high - low) / 2;
        if(dp[mid] < x){
          low = mid + 1;
        }else{
          high = mid;
        }
      }
      return low;
    }
}
