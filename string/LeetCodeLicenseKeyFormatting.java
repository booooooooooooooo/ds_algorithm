public class Solution {
    public String licenseKeyFormatting(String S, int K) {
      String result = "";
      int i = S.length() - 1;
      while(i >= 0){
        String temp = "";
        int count = 0;
        while(i >= 0 & count < K){
          if(S.charAt(i) != '-'){
            temp = S.substring(i, i + 1) + temp;
            count++;
          }
          i--;
        }
        temp = temp.toUpperCase();
        result = temp == "" ? result : temp + "-" + result;
      }
      result = result == "" ? result : result.substring(0, result.length() - 1);
      return result;
    }
}
