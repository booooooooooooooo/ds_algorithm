public class Solution {
    public boolean canPartition(int[] nums) {
      //exclude corner case
      if(nums.length == 0) return false;
      //normal case
      List<HashSet<Integer>> dp = new ArrayList<HashSet<Integer>>();
      for(int i = 0; i < nums.length; i++){
        dp.add(new HashSet<Integer>());
        if(i == 0) dp.get(0).add(nums[i]);
        else{
          for(Integer diff : dp.get(i - 1)){
            int d1 = diff + nums[i];
            int d2 = Math.abs(diff - nums[i]);
            dp.get(i).add(d1);
            dp.get(i).add(d2);
          }
        }
      }
      return dp.get(nums.length - 1).contains(0) ? true : false;
    }
}
