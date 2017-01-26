import java.util.*;

public class Test{
  public static void main(String args[]){
    long a = 2000000000;
    long b = -294967296;
    System.out.println(b - a);
  }
}


class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
      //exclude corner case
      if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
      //initialize dp array and others
      Map<Integer, Boolean> dp = new HashMap<Integer, Boolean>();
      boolean[] used = new boolean[maxChoosableInteger + 1];
      Arrays.fill(used, false);
      //call solve and return result
      return solve(used, desiredTotal, dp);

    }

    public boolean solve(boolean[] used, int leftTotal, Map<Integer, Boolean> dp){
      int key = convert(used);
      if(dp.containsKey(key))
        return dp.get(key);
      else{
        boolean canWin = false;
        for(int i = 1; i < used.length; i++){
          if(!used[i]){
            if(leftTotal - i <= 0){//base case
              canWin = true;
              break;
            }else{
              used[i] = true;
              boolean nextPlayerCanWin = solve(used, leftTotal - i, dp);
              used[i] = false;
              if(!nextPlayerCanWin){
                canWin = true;
                break;
              }
            }
          }
        }
        dp.put(key, canWin);
        return canWin;
      }
    }

    public int convert(boolean[] used){
      int result = 0;
      for(int i = 0; i < used.length; i++){
        result = result * 2 + (used[i] == true ? 1 : 0);
      }
      return result;
    }
}
