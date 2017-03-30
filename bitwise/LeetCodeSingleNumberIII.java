public class Solution {
    public int[] singleNumber(int[] nums) {
      //get result[0]^result[1]
      int resultxor = 0;
      for(int i = 0; i < nums.length; i++) resultxor ^= nums[i];
      //divide nums[] according to bit at index.
      int index = 0;
      while(index < 32){
        if( ((resultxor >> index) & 1 ) == 1 ) break;
        index++;
      }
      boolean[] div = new boolean[nums.length];
      for(int i = 0; i < nums.length; i++){
        div[i] = ((nums[i] >> index) & 1 ) == 1 ? true : false;
      }
      //get result
      int[] result = {0, 0};
      for(int i = 0; i < nums.length; i++){
        if(div[i]) result[0] ^= nums[i];
        else result[1] ^= nums[i];
      }
      return result;
    }
}
