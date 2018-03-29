public class Solution {
    public int splitArray(int[] nums, int m) {
      int l = 0;
      int r = 0;
      for(int i = 0; i < nums.length; i++){
        l = Math.max(l, nums[i]);
        r += nums[i];
      }
      while(l < r){
        int mid = l + (r - l) / 2;
        if(isValid(mid, nums, m)){
          r = mid;
        }else{
          l = mid + 1;
        }
      }
      return l;
    }
    public boolean isValid(int minSum, int[] nums, int m){
      int count = 0;
      int sum = 0;
      for(int i = 0; i < nums.length; i++){
        if(sum + nums[i] > minSum){
          count++;
          sum = nums[i];
        }else{
          sum += nums[i];
        }
      }
      if(sum != 0) count++;

      if(count <= m) return true;
      else return false;
    }
}
