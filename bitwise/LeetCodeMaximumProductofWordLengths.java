public class Solution {
    public int maxProduct(String[] words) {
      //make mask[]
      int[] mask = new int[words.length];
      for(int i = 0; i < words.length; i++){
        int m = 0;
        for(int j = 0; j < words[i].length();j++){
          m |= (1<< (words[i].charAt(j) - 'a'));
        }
        mask[i] = m;
      }
      //update result
      int result = 0;
      for(int i = 0; i < words.length; i++){
        for(int j = i + 1; j < words.length; j++){
          if((mask[i] & mask[j]) == 0) result = Math.max(result, words[i].length() * words[j].length());
        }
      }
      //return result
      return result;
    }
}
