public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
      //exclude corner case
      if(s.isEmpty() && wordDict.contains("")) return null;
      if(s.isEmpty() && !wordDict.contains("")) return null;


      //initialize dp array
      int n = s.length();
      boolean[] dp = new boolean[n];
      //initialize record List
      List<List<Integer>> prevListList = new ArrayList<List<Integer>>();
      for(int i = 0; i < n; i++) prevListList.add(new ArrayList<Integer>());

      //scan to update dp and prevListList
      for(int i = 0; i < n; i++){
        dp[i] = false;
        for(int j = i; j >= 0; j--){
          String word = s.substring(j, i + 1);
          if(wordDict.contains(word) && (j == 0 || dp[j - 1] == true) ){
            dp[i] = true;
            prevListList.get(i).add(j - 1);//add -1 to list if the current index is the end of first word
          }
        }
      }

      //initialize result
      List<String> result = new ArrayList<String>();
      //call dfs to get result
      List<String> candidate = new ArrayList<String>();
      dfs(result, candidate, n - 1, prevListList, s);

      //return result
      return result;
    }
    public void dfs(List<String> result, List<String> candidate, int index, List<List<Integer>> prevListList, String s){
      if(index == -1){
        result.add(translate(candidate));
      }else{
        List<Integer> prevList = prevListList.get(index);
        for(int i = 0; i < prevList.size(); i++){
          candidate.add( s.substring(prevList.get(i) + 1, index + 1) );
          dfs(result, candidate, prevList.get(i), prevListList, s);
          candidate.remove(candidate.size() - 1);
        }
      }
    }

    public String translate(List<String> candidate){
      String result = "";
      for(int i = candidate.size() - 1; i >= 0 ; i--){
        if(i == candidate.size() - 1 ) result += candidate.get( candidate.size() - 1 );
        else{
          result += " ";
          result += candidate.get(i);
        }
      }
      return result;
    }
}
