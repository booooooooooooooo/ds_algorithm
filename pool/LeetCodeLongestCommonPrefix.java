/**
length == 0?
length == 1?
Keep great caution on boundaries!!
TODO: try another idea. After excluding empty, select strs[0] out, then compare other strings with it to find out result.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
      //exclude null
      if(strs == null) return "";
      //exclude empty array
      if(strs.length == 0) return "";
      //exclude length 1 case
      if(strs.length == 1) return strs[0];

      //scan
      int index = 0;
      while( isCommon(strs, index)) index++;
      return strs[0].substring(0, index);
    }

    public boolean isCommon(String[] strs, int index){
      for(int i = 0; i < strs.length - 1; i++){
        if( index <= strs[i].length() - 1 && index <= strs[i + 1].length() - 1
            && strs[i].charAt(index) == strs[i + 1].charAt(index) ) continue;
        else
          return false;
      }
      return true;
    }
}
