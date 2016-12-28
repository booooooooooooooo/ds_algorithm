/**
DP
*/
public class Solution {
    public boolean isMatch(String s, String p) {
      //exclude null case
      if(s == null || p == null) return false;
      //exclude "" case
      if( s.equals("")  || p.equals("")) {
        if(s.equals("")  && p.equals(""))
          return true;
        else if(s.equals("") ){
          if(matchEmpty(p)) return true;
          else return false;
        }else
          return false;
      }

      int m = s.length();
      int n = p.length();
      boolean[][] dp = new boolean[m][n];
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          if( charIsMatch( s.charAt(i),  p.charAt(j)) ){
            if(i == 0 && j == 0)
              dp[i][j] = true;
            else if(i == 0)
              dp[i][j] = matchEmpty(p.substring(0, j)) ? true : false;
            else if(j == 0)
              dp[i][j] = false;
            else
              dp[i][j] = dp[i - 1][j - 1];
          }else if(p.charAt(j) == '*'){
            if( charIsMatch( s.charAt(i),  p.charAt(j - 1))  ){
              dp[i][j] = ( j - 2 < 0 ? false : dp[i][j - 2] ) || dp[i][j - 1] || (i - 1 < 0 ?  matchEmpty(p.substring(0, j + 1)) : dp[i - 1][j]);
            }else
              dp[i][j] = j - 2 < 0 ? false : dp[i][j - 2];
          }else
            dp[i][j] = false;
        }
      }
      return dp[m - 1][n - 1];
    }
    public boolean charIsMatch(char x, char y){
      if(x == y || x == '.' ||  y == '.') return true;
      else return false;
    }
    public boolean matchEmpty(String s){
      if(s == "") return true;
      else{
        int index = 0;
        while(index < s.length()){
          if(s.charAt(index) != '*' && index + 1 < s.length() && s.charAt(index + 1) == '*' )
            index += 2;
          else return false;
        }
        return true;
      }
    }
}


/**
DFS + prunning
*/
public class Solution {
    public boolean isMatch(String s, String p) {
      //exclude null case
      if(s == null || p == null) return false;
      //exclude "" case
      if( s.equals("")  || p.equals("")) {
        if(s.equals("")  && p.equals(""))
          return true;
        else if(s.equals("") ){
          if(matchEmpty(p)) return true;
          else return false;
        }else
          return false;
      }
      //initialzie a dp hashMap to record matching pair
      HashMap<Integer, HashSet<Integer>> visited = new HashMap<Integer, HashSet<Integer>>();

      //return result;
      return dfs(s, 0, p, 0, visited);
    }
    public boolean dfs(String s, int indexS, String p, int indexP, HashMap<Integer, HashSet<Integer>> visited){
      if(visited.containsKey(indexS) && visited.get(indexS).contains(indexP) )
        return false;//has already process this branch.pruning.
      else if( indexS == s.length() && indexP == p.length() )
        return true;//true case
      else{
        if(!visited.containsKey(indexS)) visited.put(indexS, new HashSet<Integer>());
        visited.get(indexS).add(indexP);

        if( indexS == s.length() ){
          if(indexP  + 1 < p.length() && p.charAt(indexP + 1) == '*')
            return dfs(s, indexS, p, indexP + 2, visited);
          else
            return false;
        }else if( indexP == p.length()){
          return false;
        }else{
          if(charIsMatch(s.charAt(indexS), p.charAt(indexP))){//a, a or a .
            if(indexP + 1 < p.length() && p.charAt(indexP + 1) == '*')
              return dfs(s, indexS, p, indexP + 2, visited)
                    || dfs(s, indexS + 1, p, indexP + 2, visited)
                    || dfs(s, indexS + 1, p, indexP, visited);
            else
              return dfs(s, indexS + 1, p, indexP + 1, visited);
          }else{//a, c
              if(indexP  + 1 < p.length() && p.charAt(indexP + 1) == '*')
                return dfs(s, indexS, p, indexP + 2, visited);
              else
                return false;
          }
        }

      }
    }
    public boolean charIsMatch(char x, char y){
      if(x == y || x == '.' ||  y == '.') return true;
      else return false;
    }
    public boolean matchEmpty(String s){
      if(s == "") return true;
      else{
        int index = 0;
        while(index < s.length()){
          if(s.charAt(index) != '*' && index + 1 < s.length() && s.charAt(index + 1) == '*' )
            index += 2;
          else return false;
        }
        return true;
      }
    }
}
