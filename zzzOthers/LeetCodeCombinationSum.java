import java.util.*;
public class LeetCodeCombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    solve(candidates, target, path, 0, result);
    return result;
  }

  void solve(int[] candidates, int target, ArrayList<Integer> path, int index,
             List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<Integer>(path));
      return;
    } else if (index >= candidates.length) {
      return;
    } else {
      for (int i = 0; i <= target / candidates[index]; i++) {
        for (int j = 1; j <= i; j++) {
          path.add(candidates[index]);
        }
        solve(candidates, target - i * candidates[index], path, index + 1,
              result);
        for (int j = 1; j <= i; j++) {
          path.remove(path.size() - 1);
        }
      }
    }
  }
}
