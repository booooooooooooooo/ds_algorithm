public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
      int result = 0;
      for(int i = 30; i >= 0; i--){
        if( ((m >> i) & 1) == 1 && ((n >> i) & 1) == 1) result += (1 << i);
        else if( ((m >> i) & 1) == 0 && ((n >> i) & 1) == 0) continue;
        else break;
      }
      return result;
    }
}
