public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      //corner case: None

      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> cur = new ArrayList<Integer>();
      solve(nums, result, cur, 0);
      return result;
    }
    private void solve(int[] nums, List<List<Integer>> result, List<Integer> cur, int index){
      if(index == nums.length) result.add(makecopy(cur));
      else{
        int nextIndex = index;
        while(nextIndex < nums.length && nums[nextIndex] == nums[index])
          nextIndex++;
        solve(nums, result, cur, nextIndex);
        for(int i = index; i < nextIndex;i++){
          cur.add(nums[i]);
          solve(nums, result, cur, nextIndex);
        }
        for(int i = index; i < nextIndex; i++){
          cur.remove(cur.size() - 1);
        }
      }
    }
    private List<Integer> makecopy(List<Integer> cur){
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < cur.size(); i++)
        result.add(cur.get(i));
      return result;
    }

}
