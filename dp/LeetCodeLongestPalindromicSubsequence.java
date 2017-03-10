public class Solution {
    public int longestPalindromeSubseq(String s) {
      //dp[i][j]  = length of longest subsequence of s.substring(i, j + 1)
      int[][] dp = new int[s.length()][s.length()];
      for(int len = 1; len <= s.length(); len++){
        for(int i = 0; i <= s.length() - len; i++){
          if(len == 1 ) dp[i][i + len - 1] = 1;
          else if( len == 2) dp[i][i + len - 1] = s.charAt(i) == s.charAt(i+len-1) ? 2 : 1;
          else
            dp[i][i + len - 1] = s.charAt(i) == s.charAt(i+len-1) ? dp[i+ 1][i+len-1-1] + 2: Math.max(dp[i][i+len-1-1], dp[i+1][i+len-1]);
        }
      }
      return dp[0][s.length()-1];
    }
}
