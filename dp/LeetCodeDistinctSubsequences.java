public class Solution {
    public int numDistinct(String s, String t) {
      //corner cases
      if(t.isEmpty()) return 1;
      else if(s.isEmpty()) return 0;
      else ;

      final int M = s.length();
      final int N = t.length();

      char[] a = s.toCharArray();
      char[] b = t.toCharArray();

      int[][] dp = new int[M][N];
      for(int i = 0; i < M; i++){
        for(int j = 0; j < N; j++){
          if(i == 0 && j == 0){
            dp[0][0] = (a[0] == b[0]) ? 1 : 0;
          }else if(i == 0){
            dp[0][j] = 0;
          }else if(j == 0){
            dp[i][0] = (a[i] == b[0]) ? dp[i - 1][0] + 1 : dp[i - 1][0];
          }else{
            dp[i][j] = (a[i] == b[j]) ? (dp[i - 1][j] + dp[i - 1][j - 1]) : dp[i - 1][j];
          }
        }
      }
      return dp[M - 1][N - 1];
    }
}
