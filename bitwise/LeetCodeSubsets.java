public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      int[] flag = new int[nums.length];
      Arrays.fill(flag, 0);
      int sizeOfResult = 1;
      for(int i = 0; i < nums.length; i++) sizeOfResult *= 2;
      for(int i = 0; i < sizeOfResult; i++){
        result.add(getSubset(nums, flag));
        succ(flag);
      }
      return result;
    }
    public List<Integer> getSubset(int[] nums, int[] flag){
      List<Integer> subset = new ArrayList<Integer>();
      for(int i = 0; i < nums.length; i++){
        if(flag[i] == 1) subset.add(nums[i]);
      }
      return subset;
    }
    public void succ(int[] flag){
      for(int i = flag.length - 1; i >= 0; i--){
        if(flag[i] == 0){
          flag[i] = 1;
          break;
        } else {
          flag[i] = 0;
        }
      }
    }
}
