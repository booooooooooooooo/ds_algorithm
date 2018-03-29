public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //corner
        if(nums.length == 0) return 0;

        int[] ends = new int[nums.length];
        int curEnd = nums.length;
        int curSum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
          curSum += nums[i];
          if(curSum < s) ends[i] = -1;
          else{
            while(curSum - nums[curEnd - 1] >= s){
              curSum -= nums[curEnd - 1];
              curEnd -= 1;
            }
            ends[i] = curEnd;
          }
        }

        int result = 0;
        for(int i = 0; i < ends.length; i++) result = Math.max(result, ends[i] == -1 ? 0 : ends[i] - i);
        if(result == 0) return 0;
        else{
          for(int i = 0; i < ends.length; i++)
            if(ends[i] != -1)
              result = Math.min(result, ends[i] - i);
          return result;
        }
    }
}
