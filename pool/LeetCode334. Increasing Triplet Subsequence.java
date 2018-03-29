public class Solution {
    public boolean increasingTriplet(int[] nums) {
      //cornor TODO

      int[] dp = new int[4];//dp[0] is not used
      int index = 1;//next to be used
      for(int n : nums){
        int lb = getLowerBound(dp, 1, index, n);
        dp[lb] = n;
        if(lb == index) index++;
        if(index > 3) return true;
      }
      return false;
    }
    private int getLowerBound(int[] arr, int start, int end, int target){
      int low = start;
      int high = end;
      while(low < high){
        int mid = low + (high - low) / 2;
        if(arr[mid] < target) low = mid + 1;
        else high = mid;
      }
      return low;
    }
}
