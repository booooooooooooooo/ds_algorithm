import java.util.*;
public class Solution {
    public int hIndex(int[] citations) {
      Arrays.sort(citations);
      for(int i = 0; i < citations.length / 2; i++){
        int temp = citations[i];
        citations[i] = citations[citations.length - 1 - i];
        citations[citations.length - 1 - i] = temp;
      }
      int h = 1;//possible result + 1
      while(h - 1 < citations.length){
        if( h > citations[h-1]  ){
          break;//h = result + 1
        }
        h++;
      }
      h--;
      return h;

    }
}
