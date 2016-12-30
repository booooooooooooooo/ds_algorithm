/**
DP O(n^3)  O(n^3)????
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
      //corner cases
      if(s1.length() != s2.length()) return false;
      if(s1.length() == 0 && s2.length() == 0) return true;
      //TODO: check whether s1 has same char and also same frequency for each char with s2

      final int N = s1.length();
      boolean[][][] dp = new boolean[N + 1][N][N];
      for(int n = 0; n < N; n++){
        for(int i = 0; i < N; i++){
          Arrays.fill(dp[n][i], false);
        }
      }
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          dp[0][i][j] = true;
          dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
        }
      }
      for(int n = 0; n <= N; n++){
        for(int i = 0; i  + n - 1 < N; i++){
          for(int j = 0; j + n - 1 < N; j++){
            for(int k = 1; k < n; k++){
              if( ( dp[k][i][j] && dp[n - k][i + k][j + k] ) || ( dp[k][i][j + n - k] && dp[n - k][i + k][j] ) ){
                dp[n][i][j] = true;
                break;
              }
            }
          }
        }
      }
      return dp[N][0][0];
    }
}




/**
DFS TLE
For understanding problem purpose
Copied from http://blog.csdn.net/ljiabin/article/details/44537523
*/
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        return false;
    }
}
