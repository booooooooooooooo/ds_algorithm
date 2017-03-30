public class Solution {
    public int singleNumber(int[] nums) {
      int result = 0;
      for(int i = 0; i < 32; i++){
        int curBit = 0;
        for(int j = 0; j < nums.length; j++){
          curBit += ( (nums[j] >> i) & 1 );
          curBit %= 3;
        }
        result |= ( (curBit == 0 ? 0 : 1) << i);
      }
      return result;
    }
}
