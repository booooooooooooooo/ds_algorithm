/**
nums has no duplicates
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      boolean[] used = new boolean[nums.length];
      Arrays.fill(used, false);
      dfs(nums, used, new ArrayList<Integer>(), result);
      return result;
    }


    public void dfs(int[] nums, boolean[] used, ArrayList<Integer> permutation, List<List<Integer>> result){
      if(permutation.size() == nums.length) result.add( (ArrayList<Integer>)permutation.clone() );
      for(int i = 0; i < nums.length; i++){
        if(!used[i]){
          permutation.add(nums[i]);
          used[i] = true;
          dfs(nums, used, permutation, result);
          permutation.remove(permutation.size() - 1);
          used[i] = false;
        }
      }
    }
}
