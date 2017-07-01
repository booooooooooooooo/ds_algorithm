public class Solution {
    public int smallestFactorization(int a) {
      //CORNER
      if(a == 1) return 1;

      //factorize a by 7, 5, 3, 2
      int[] bucket = new int[10];//only bucket[2] ~ bucket[9] are used;
      Arrays.fill(bucket, 0);
      while(a % 7 == 0){
        bucket[7]++;
        a = a / 7;
      }
      while(a % 5 == 0){
        bucket[5]++;
        a = a / 5;
      }
      while(a % 3 == 0){
        bucket[3]++;
        a = a / 3;
      }
      while(a % 2 == 0){
        bucket[2]++;
        a = a / 2;
      }
      if(a != 1) return 0;
      
      //construct result
      bucket[9] = bucket[3] / 2;
      bucket[3] = bucket[3] % 2;

      bucket[8] = bucket[2] / 3;
      bucket[2] = bucket[2] % 3;

      bucket[6] = Math.min(bucket[3], bucket[2]);
      bucket[3] -= bucket[6];
      bucket[2] -= bucket[6];

      bucket[4] = bucket[2] / 2;
      bucket[2] = bucket[2] % 2;

      String s = "";
      for(int i = 2; i <= 9; i++){
        for(int j = 0; j < bucket[i]; j++){
          s = s + Integer.toString(i);
        }
      }
      //check overflow
      if(!isValidInteger(s)) return 0;
      else return  Integer.valueOf(s);
    }
    private boolean isValidInteger(String s){
      String maxInt = Integer.toString(Integer.MAX_VALUE);
      if(s.length() > maxInt.length()) return false;
      else if(s.length() <  maxInt.length()) return true;
      else if(s.compareTo(maxInt) <= 0) return true;
      else return false;
    }
}
