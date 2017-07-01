public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0; i < C.length; i++){
        for(int j = 0; j < D.length; j++){
          int key = -C[i] - D[j];
          if(!map.containsKey(key)) map.put(key, 0);
          map.put(key, map.get(key) + 1);
        }
      }
      int result = 0;
      for(int i = 0; i < A.length; i++){
        for(int j = 0; j < B.length; j++){
          int key = A[i] + B[j];
          if(map.containsKey(key)) result += map.get(key);
        }
      }
      return result;
    }
}
