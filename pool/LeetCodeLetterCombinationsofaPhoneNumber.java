import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
      //exclude corner case
      if(digits.length() == 0) return new ArrayList<String>();
      //make constant digit - characters mappings. 0 - 0, 1 - 1,...,9 - 9
      String[] mp = new String[]{"0", "1", "abc", "def", "ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
      //do dfs to update  result
      List<String> result = new ArrayList<String>();
      solve(mp, result, digits, 0, "");
      //return result
      return result;
    }
    public void solve(String[] mp, List<String> result, String digits, int index, String cur){
      if(index == digits.length()) result.add(cur + "");//copy string
      else{
        String brunches = mp[digits.charAt(index) - '0'];
        for(int i = 0; i < brunches.length(); i++){
          solve(mp, result, digits, index + 1, cur + brunches.charAt(i));
        }
      }

    }
}
