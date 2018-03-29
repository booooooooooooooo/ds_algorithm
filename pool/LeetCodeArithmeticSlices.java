public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      //exclude corner case

      //normal case
      int[] interval = new int[A.length];//index 0 is not used
      int[] count = new int[A.length];//index 0 is not used
      for(int i = 1; i < A.length; i++){
        if(i == 1){
          interval[1] = A[1] - A[0];
          count[1] = 1;
        }else{
          interval[i] = A[i] - A[i - 1];
          count[i] = interval[i - 1] == interval[i] ? count[i - 1] + 1 : 1;
        }
      }
      int result = 0;
      for(int i = 1; i < A.length; i++)
        result += count[i] - 1;
      return result;
    }
}
