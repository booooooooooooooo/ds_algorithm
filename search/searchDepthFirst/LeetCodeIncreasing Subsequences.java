public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
      //corner case

      List<Integer> cur = new ArrayList<Integer>();
      Set<List<Integer>> result = new HashSet<List<Integer>>();
      int index = 0;//next valid index
      solve(nums, result, cur, index);
      return new ArrayList(result);
    }
    private void solve(int[] nums, Set<List<Integer>> result, List<Integer> cur, int index){
      if(index == nums.length){
        if(cur.size() >= 2) result.add(makecopy(cur));
      }else{
        int nextIndex;
        //use nums[index]
        if(cur.isEmpty())
          nextIndex = index + 1;
        else{
          nextIndex = index + 1;
          while(nextIndex < nums.length && nums[nextIndex] < cur.get(cur.size() - 1))
            nextIndex++;
        }
        solve(nums, result, cur, nextIndex);
        //do not use nums[index]
        nextIndex = index + 1;
        while(nextIndex < nums.length && nums[nextIndex] < nums[index])
          nextIndex++;
        cur.add(nums[index]);
        solve(nums, result, cur, nextIndex);
        cur.remove(cur.size() - 1);
      }
    }
    private List<Integer> makecopy(List<Integer> cur){
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < cur.size(); i++)
        result.add(cur.get(i));
      return result;
    }
}
