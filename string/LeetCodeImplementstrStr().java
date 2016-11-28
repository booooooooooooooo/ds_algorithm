public class Solution {
    public int strStr(String haystack, String needle) {
      //exclude null case
      if(haystack == null || needle == null) return -1;
      //exclude empty case
      if(needle.isEmpty()) return 0;


      //Scan with two pointers, return index if found.
      int pointer = 0;//pointer of haystack
      while(pointer < haystack.length()){
        if(haystackContainsNeedleFromThisPoint(pointer, 0, haystack, needle) ){
          return pointer;
        }else{
          pointer++;
        }
      }

      //return
      return -1;
    }

    public boolean haystackContainsNeedleFromThisPoint(int p1, int p2, String s1, String s2){
      while(p1 <= s1.length() - 1 && p2 <= s2.length() -1){
        if(s1.charAt(p1) != s2.charAt(p2)) return false;
        p1++;
        p2++;
      }
      if(p2 == s2.length()) return true;
      else return false;
    }
}
