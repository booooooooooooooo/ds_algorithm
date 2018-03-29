public class Solution {
  private int[] original;
  private Random rd;
    public Solution(int[] nums) {
      original = nums.clone();
      rd = new Random();
    }
    public int[] reset() {
      int[] result = original.clone();
      return result;
    }


    public int[] shuffle() {
      int[] result = original.clone();
      for(int i = 0; i < result.length; i++){
        int j = rd.nextInt(result.length - i) + i;//Caution: j may equals to i. nextInt() takes positive parameter
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
      }
      return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
