public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      //corner cases TODO
      if(s3.length() != s1.length() + s2.length()) return false;
      if(s1.equals("")) return s2.equals(s3);
      if(s2.equals("")) return s1.equals(s3);

      int m = s1.length();
      int n = s2.length();
      boolean[][] dp = new boolean[m + 1][n + 1];//s1 [0, i), s2 [0, j), s3 [0, i + j)
      for(int i = 0; i <= m; i++){
        for(int j = 0; j <= n; j++){
          if(i == 0 && j == 0){
            dp[0][0] = true;
          }else if(i == 0){
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
          }else if(j == 0){
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
          }else{
            dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))
                       || dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
          }
        }
      }
      return dp[m][n];
    }
}
