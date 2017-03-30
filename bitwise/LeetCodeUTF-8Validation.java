public class Solution {
   public boolean validUtf8(int[] data) {
     //corner case
     if(data.length == 0) return false;

     int index = 0;
     while(index < data.length){
       //count initial 1 bit before first 0 bit
       int countBytes = 0;
       for(int i = 7; i >= 0; i--){
         if( ((data[index] >> i) & 1) == 1 ) countBytes++;
         else break;
       }
       //validate current charactor
       if(countBytes == 0) index += 1;//ascii
       else if(2 <= countBytes && countBytes <= 4){
         for(int i = index + 1; i <= index + countBytes - 1; i++){
           if(i >= data.length || ( (data[i] >> 6 ) & 3 ) != 2 ) return false;
         }
         index += countBytes;
       }else return false;
     }
     return true;
   }
}
