public class Solution {
    public int subarraySum(int[] nums, int k) {
      Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
      int[] sum = new int[nums.length + 1];
      sum[0] = 0;
      for(int i = 1; i < nums.length + 1; i++){
        sum[i] = sum[i-1] + nums[i-1];
        if(!map.containsKey(sum[i])) map.put(sum[i], new ArrayList<Integer>());
        map.get(sum[i]).add(i);
      }
      int count = 0;
      for(int i = 0;i < nums.length + 1; i++){
        int key = sum[i] + k;
        if(map.containsKey(key)){
          List<Integer> endIndices = map.get(key);
          //TODO: use binary search to enhance speed
          for(Integer end : endIndices){
            if(end > i) count++;
          }
        }
      }
      return count;
    }
}
