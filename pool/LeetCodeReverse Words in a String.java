public class Solution {
    public String reverseWords(String s) {
      String[] midRes = s.split(" ");
      String res = "";
      for(int i = 0; i < midRes.length; i++){
        String cur = midRes[i].trim();
        if(!cur.equals(""))
          res = cur + " " + res;
      }

      return res.trim();
    }
}
