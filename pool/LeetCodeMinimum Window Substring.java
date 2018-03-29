public class Solution {
    public String minWindow(String s, String t) {
      //cornor

      Map<String, Integer> map = new HashMap<String ,Integer>();
      int count = 0;
      for(int i = 0; i < t.length(); i++){
        String cur = String.valueOf(t.charAt(i));
        if(!map.containsKey(cur)) map.put(cur, 0);
        map.put(cur, map.get(cur) + 1);
        count++;
      }
      int l = 0;
      int r = s.length();
      int start = 0;
      for(int end = 0; end < s.length(); end++){
        String endS = String.valueOf(s.charAt(end));
        if(map.containsKey(endS)){
          if(map.get(endS) > 0) count--;
          map.put(endS, map.get(endS) - 1);
        }
        while(start < s.length()){
          String startS = String.valueOf(s.charAt(start));
          if(!map.containsKey(startS)) start++;
          else if(map.containsKey(startS) && map.get(startS) < 0 ){
            map.put(startS, map.get(startS) + 1);
            start++;
          }
          else break;
        }

        if(count == 0 && end + 1 - start < r - l){
          l = start;
          r = end + 1;
        }
      }
      return count == 0 ? s.substring(l, r) : "";
    }
}
