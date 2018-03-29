public class Solution {
  private int[] nums;
  private Random rd;
    public Solution(int[] nums) {
      this.nums = nums;
      this.rd = new Random();
    }

    public int pick(int target) {
      int index = -1;
      int count = 0;
      for(int i = 0; i < nums.length; i++){
        if(nums[i] == target){
          if(rd.nextInt(count + 1) == count) index = i;
          count++;
        }
      }
      return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
