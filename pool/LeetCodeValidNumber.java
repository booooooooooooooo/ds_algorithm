public class Solution {
    public boolean isNumber(String s) {
      //strip blank
      s = s.trim();
      if(s.length() == 0) return false;

      if(s.charAt(0) == '-') s = s.substring(1, s.length());

      return isPositiveInteger(s) || isPositiveDecimal(s) || isPositiveSciNotation(s);
    }
    //01 is true
    public boolean isPositiveInteger(String s){
      if(s.length() == 0) return false;
      else{
        if(s.charAt(0) == '0'){
          if(s.length() == 1) return true;
          else return false;
        }else{
          for(int i = 0; i < s.length(); i++){//!! i starts from 0
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') continue;
            else return false;
          }
          return true;
        }
      }
    }
    public boolean isPositiveDecimal(String s){
      int startOfRightPart = -1;
      if(s.length() >= 1 && s.charAt(0) == '.'){
        startOfRightPart = 1;
      }else if(s.length() >= 2 && s.charAt(0) == '0' && s.charAt(1) == '.'){
        startOfRightPart = 2;
      }else{
        return false;
      }

      int indexOfLastNonZero = -1;
      for(int i = startOfRightPart; i < s.length(); i++){
        if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
          if(s.charAt(i) != '0') indexOfLastNonZero = i;
          continue;
        }else{
          return false;
        }
      }
      if(indexOfLastNonZero != s.length() - 1 ) return false;
      return true;

    }
    public boolean isPositiveSciNotation(String s){
      //find letter e
      int indexOfE = -1;
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == 'e'){
          indexOfE = i;
          break;
        }
      }
      if(indexOfE == -1) return false;
      //two parts divided by e should be two integers
      return (isPositiveInteger(s.substring(0, indexOfE)) || isPositiveDecimal(s.substring(0, indexOfE)) )
            && isPositiveInteger(s.substring(indexOfE + 1, s.length()));
    }
}
