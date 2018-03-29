public class Solution {
    public boolean isSubsequence(String s, String t) {
      int ps = 0;
      int pt = 0;
      while(ps < s.length() && pt < t.length()){
        if(s.charAt(ps) == t.charAt(pt)){
          ps++;
        }
        pt++;

      }
      if(ps == s.length()) return true;
      else return false;
    }
}
