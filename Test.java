import java.util.*;

public class Test{
  public static void main(String args[]){
    System.out.println((new Solution()).validUtf8(new int[]{235, 40, 4}));
  }
}

 class Solution {
    public boolean validUtf8(int[] data) {
      //corner case
      if(data.length == 0) return false;

      //count initial 1 bit before first 0 bit
      int countBytes = 0;
      for(int i = 7; i >= 0; i--){
        if( ((data[0] >> i) & 1) == 1 ) countBytes++;
        else break;
      }
      if(countBytes == 0) return true;//ascii
      else if(2 <= countBytes && countBytes <= 4){
        for(int i = 1; i <= countBytes - 1; i++){
          if(i >= data.length || ( (data[i] >> 6 ) & 3 ) != 2 ) return false;
        }
        return true;
      }else return false;
    }
}
