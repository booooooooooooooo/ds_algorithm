public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      Set<String> result = new HashSet<String>();
      Set<Integer> stat = new HashSet<Integer>();
      int key = 0;
      for(int i = 0; i < s.length(); i++){
        key = ( (key << 2) & 0xfffff ) + translateChar(s.charAt(i));
        if(i >= 9){
          if(stat.contains(key)) result.add(s.substring(i - 9, i + 1));
          else stat.add(key);
        }
      }
      return new ArrayList<String>(result);
    }
    public int translateChar(char c){
      //A:00, C:01, G:10, T:11
      if(c == 'A'){
        return 0;
      }else if(c == 'C'){
        return 1;
      }else if(c == 'G'){
        return 2;
      }else{
        return 3;
      }
    }
}
