public class Solution {
    public int maxProduct(int[] nums) {
      //corner: though meaningless case
      if(nums.length == 0) return 0;

      int[] minDp = new int[nums.length];
      int[] maxDp = new int[nums.length];

      minDp[0] = nums[0];
      maxDp[0] = nums[0];
      for(int i = 1; i < nums.length; i++){
        if(nums[i] == 0){
          minDp[i] = 0;
          maxDp[i] = 0;
        }else if(nums[i] > 0){
          maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
          minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
        }
        else{
          maxDp[i] = Math.max(nums[i], minDp[i - 1] * nums[i]);
          minDp[i] = Math.min(nums[i], maxDp[i - 1] * nums[i]);
        }
      }
      int res = maxDp[0];
      for(int i = 1; i < maxDp.length; i++) res = Math.max(res, maxDp[i]);
      return res;
    }
}
