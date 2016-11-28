public class Solution {
    public int singleNumber(int[] nums) {
      int[] binaryResult = new int[32];
      Arrays.fill(binaryResult, 0);
      int result = 0;

      for(int i = 0; i < nums.length; i++) update(binaryResult, nums[i]);
      for(int i = binaryResult.length - 2; i >= 0; i--){
        result = result * 2 + binaryResult[i];
      }
      return binaryResult[binaryResult.length - 1] == 0 ? result :  (result + Integer.MIN_VALUE ) ;
    }

    public void update(int[] binaryResult, int value){
      if(value < 0){
        binaryResult[binaryResult.length - 1] = (binaryResult[binaryResult.length - 1] + 1) % 3;
        value = value -  Integer.MIN_VALUE;
      }
      int i = 0;
      while(value > 0){
        binaryResult[i] = ( binaryResult[i] + value % 2) % 3;
        i++;
        value /= 2;
      }

    }
}



//
// public class Solution {
//     public int singleNumber(int[] nums) {
//       int[] binaryResult = new int[32];
//       Arrays.fill(binaryResult, 0);
//       int result = 0;
//
//       for(int i = 0; i < nums.length; i++) update(binaryResult, nums[i]);
//       for(int i = binaryResult.length - 2; i >= 0; i--){
//         result = result * 2 + binaryResult[i];
//       }
//       return binaryResult[binaryResult.length - 1] == 0 ? result :  (result | Integer.MIN_VALUE ) ;
//     }
//
//     public void update(int[] binaryResult, int value){
//       if(value < 0){
//         binaryResult[binaryResult.length - 1] = (binaryResult[binaryResult.length - 1] + 1) % 3;
//         value = value & Integer.MAX_VALUE;
//       }
//       int i = 0;
//       while(value > 0){
//         binaryResult[i] = ( binaryResult[i] + value % 2) % 3;
//         i++;
//         value /= 2;
//       }
//
//     }
// }
