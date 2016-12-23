public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
      //exclude corner case
      if(s.isEmpty() && wordDict.contains("")) return true;
      if(s.isEmpty() && !wordDict.contains("")) return false;


      //initialize dp array
      int n = s.length();
      boolean[] dp = new boolean[n];

      //scan
      for(int i = 0; i < n; i++){
        dp[i] = false;
        for(int j = i; j >= 0; j--){
          String word = s.substring(j, i + 1);
          if(wordDict.contains(word) && ( j == 0 || dp[j - 1] == true)) dp[i] = true;
        }
      }

      //return result
      return dp[n - 1];
    }
}
