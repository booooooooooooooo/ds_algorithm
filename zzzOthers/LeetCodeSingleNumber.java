// public class Solution {
//     public int singleNumber(int[] nums) {
//       int result = nums[0];
//       for(int i = 1; i < nums.length; i++) result = result ^ nums[i];
//       return result;
//
//     }
// }


public class Solution {
    public int singleNumber(int[] nums) {
      for(int i = 1; i < nums.length; i++) nums[0] = nums[0] ^ nums[i];
      return nums[0];

    }
}
