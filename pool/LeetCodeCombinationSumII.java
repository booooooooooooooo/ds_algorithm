import java.util.*;
public class LeetCodeCombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      int[] unique = new int[candidates.length];
      int[] freq = new int[candidates.length];
      Arrays.fill(unique, -1);
      Arrays.fill(freq, 0);
      Arrays.sort(candidates);
      // for(int i = 0; i < candidates.length / 2; i++){
      //   int temp = candidates[i];
      //   candidates[i] = candidates[candidates.length - 1 - i];
      //   candidates[candidates.length - 1 - i] = temp;
      // }
      int endIndex = 0;
      for(int i = 0; i < candidates.length; i++){
        if(i == 0){
          unique[0] = candidates[0];
          freq[0]++;
        }else{
          if(candidates[i] == unique[endIndex]){
            freq[endIndex]++;
          } else{
            endIndex++;
            unique[endIndex] = candidates[i];
            freq[endIndex]++;
          }
        }
      }
      // for(int i = 0; i <= endIndex; i++){
      //   System.out.printf("Value: %d      Freq: %d\n", unique[i], freq[i]);
      // }
      // System.out.println();
      return solve(unique, freq, endIndex, target);
    }
    public List<List<Integer>> solve(int[] unique, int[] freq, int endIndex, int target){
      List<List<Integer>> combinations = new ArrayList<List<Integer>>();
      List<Integer> comb = new ArrayList<Integer>();
      solveSolve(unique, freq, endIndex, target, 0, comb, combinations);
      return combinations;
    }
    public void solveSolve(int[] unique, int[] freq, int endIndex, int target, int curIndex, List<Integer> comb,   List<List<Integer>> combinations){
      if(target == 0){
        combinations.add(new ArrayList<Integer>(comb));
        return;
      }else if(curIndex > endIndex || target < 0){
        return;
      }else{
        for(int i = 0; i <= freq[curIndex]; i++){
          if(i != 0) addSeveral(comb, unique[curIndex], 1);
          solveSolve(unique, freq, endIndex, target - i * unique[curIndex], curIndex + 1, comb, combinations);
        }
        deleteSeveral(comb, unique[curIndex], freq[curIndex]);
      }
    }
    public void addSeveral(List<Integer> comb, int elem, int i){
      for(int j = 0; j < i; j++){
        comb.add(Integer.valueOf(elem));
      }
    }
    public void deleteSeveral(List<Integer> comb, int elem, int i){
      for(int j = 0; j < i; j++){
        comb.remove(comb.size() - 1);
      }
    }
}
