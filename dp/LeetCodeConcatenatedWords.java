public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
      Set<String> wordDict = new HashSet<String>();
      for(int i = 0; i < words.length; i++){
        wordDict.add(words[i]);
      }

      List<String> result = new ArrayList<String>();
      for(int i = 0; i < words.length; i++){
        if(isValid(words[i], wordDict))
          result.add(words[i]);
      }
      return result;
    }

    public boolean isValid(String word, Set<String> wordDict){
      //corner case
      if(wordDict.contains("")) return false;//I think this should be true. But leetcode agrees with false.


      int n = word.length();
      boolean[] dp = new boolean[n];
      Arrays.fill(dp, false);
      for(int i = 0; i < n - 1; i++){
        for(int j = i; j >= 0; j--){
          if( (j == 0 ||dp[j - 1] == true )  && wordDict.contains( word.substring(j, i + 1) ) ){
            dp[i] = true;
            break;
          }
        }
      }
      for(int j = n - 1; j >= 1; j--){
        if(dp[j - 1] == true && wordDict.contains(word.substring(j, n))){
          dp[n - 1] = true;
          break;
        }
      }
      return dp[n - 1];
    }
}
