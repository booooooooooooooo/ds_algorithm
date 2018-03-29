public class Solution {
    public int totalHammingDistance(int[] nums) {
      //exclude corner case
      //no corner case

      int total = 0;
      for(int i = 0; i < 32; i++){
        int count0 = 0;
        int count1 = 0;
        for(int j = 0; j < nums.length; j++){
          if( (nums[j] & (1 << i) ) == 0 ) count0++;//Caution for sign bit. Left shift avoids sign bit complement
          else count1++;
        }
        total += count0 * count1;
      }
      return total;
    }
}
