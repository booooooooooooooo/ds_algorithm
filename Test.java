import java.util.*;

public class Test{
  public static void main(String args[]){
    // Solution solution = new Solution();
    int[] nums = {1, 1, 2};
    // System.out.println(solution.permuteUnique(nums));
    System.out.println(Arrays.toString(nums));
  }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      //corner case??
      //initialize
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Hashtable<Integer, Integer> freqTable = new Hashtable<Integer, Integer>();
      for(int i = 0; i < nums.length; i++){
        if(freqTable.containsKey(nums[i])) freqTable.put(nums[i], freqTable.get(nums[i]) + 1 );
        else freqTable.put(nums[i], 1);
      }
      List<Integer> numArr = new ArrayList<Integer>(freqTable.keySet());
      Integer[] permutation = new Integer[nums.length];
      boolean[] filled = new boolean[nums.length];
      Arrays.fill(filled, false);
      //call dfs to update result
      dfs(freqTable, numArr, 0, 0, -1, permutation, filled, result);
      //return result
      return result;

    }
    public void dfs(Hashtable<Integer, Integer> freqTable, List<Integer>  numArr, int indexNumArr, int count, int prevIndexPermutation, Integer[] permutation , boolean[] filled, List<List<Integer>> result ){
      if(indexNumArr == numArr.size()){//base case
        result.add( new ArrayList<Integer>(Arrays.asList(permutation)) );
      }else{
        int start = count == 0 ? 0 : prevIndexPermutation + 1;
        for(int i = start; i < permutation.length; i++){
          if(!filled[i]){
            permutation[i] = numArr.get(indexNumArr);
            filled[i] = true;
            if(count + 1 == freqTable.get(numArr.get(indexNumArr))) dfs(freqTable, numArr, indexNumArr + 1, 0, -1, permutation, filled,result);
            else dfs(freqTable, numArr, indexNumArr, count + 1, i, permutation, filled, result);
            filled[i] = false;
          }
        }
      }
    }
}
