/*
Use one dimentional dp array
remember k = 0
remember j - i + 1 >= 2
*/
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
      //use one dimentional dp array instead of two
      int[]dp = new int[nums.length];
      //[i,j] && j - i + 1 >= 2
      if(k == 0){//k = 0
        for(int i = 0; i < nums.length - 1; i ++){
          if(nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        return false;
      }else{
        for(int i = nums.length - 1; i >= 0; i--){
          for(int j = i; j <= nums.length - 1; j++){
            if(i == nums.length - 1) dp[j] = nums[i] % k;//first dp value
            else if(j == i) dp[j] = nums[i] % k;//diagonal values
            else dp[j] = (nums[i] % k + dp[j]) % k;//common value
            if( j - i + 1 >= 2 && dp[j] == 0) return true;
          }
        }
        return false;
      }


    }
}
