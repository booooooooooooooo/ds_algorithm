import java.util.*;
public class Solution {
    public boolean canCross(int[] stones) {
      //<stone number, steps to arrive it>
      HashMap<Integer, HashSet<Integer>> jump = new HashMap<Integer, HashSet<Integer>>();
      HashSet<Integer> setAtStone1 =  new HashSet<Integer>();
      setAtStone1.add(1);
      jump.put(1, setAtStone1);
      for(int i = 1; i < stones.length; i++){
        Integer stoneNumber = stones[i];
        if(jump.get(stoneNumber) != null){
          HashSet<Integer> steps = jump.get(stoneNumber);
          for(Integer step : steps){
            for(int j = -1; j <= 1; j++){
              //Be carefull for null.
              if(step + j > 0){
                if(jump.get(stoneNumber + step + j) == null){
                  jump.put(stoneNumber + step + j, new HashSet<Integer>());
                }
                jump.get(stoneNumber + step + j).add(step + j);
              }
            }
          }
        }
      }
      if(jump.get(stones[stones.length - 1]) == null) return false;
      else return true;
    }
}
