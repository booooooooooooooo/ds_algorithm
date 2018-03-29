public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      //exclude corner case
      if(matrix.length == 0) return Integer.MIN_VALUE;

      //TODO: choose max of m and n

      int m = matrix.length;
      int n = matrix[0].length;

      //[i,j]
      int result = Integer.MIN_VALUE;
      for(int i = 0; i < n; i++){
        int[] acc = new int[m];
        Arrays.fill(acc, 0);
        for(int j = i; j < n; j++){
          TreeSet<Integer> set = new TreeSet<Integer>();
          set.add(0);//caution!!!
          int sumTol = 0;
          for(int l = 0; l < m; l++){
            acc[l] += matrix[l][j];
            sumTol += acc[l];
            Integer sumToAny = set.ceiling(sumTol - k);
            if(sumToAny != null){
              result = Math.max(result, sumTol - sumToAny);
            }
            set.add(sumTol);
          }
        }
      }
      return result;
    }
}
