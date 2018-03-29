public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //make map
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
          if(!map.containsKey(nums[i])) map.put(nums[i], 0);
          map.put(nums[i], map.get(nums[i]) + 1);
        }
        //make bucket
        List<List<Integer>> bucket = new ArrayList<List<Integer>>();
        for(int i = 0; i <= nums.length; i++) bucket.add(new ArrayList<Integer>());
        for(Integer num : map.keySet()){
          Integer freq = map.get(num);
          bucket.get(freq).add(num);
        }
        //make result
        List<Integer> result = new ArrayList<Integer>();
        for(int i = bucket.size() - 1; i >= 0; i--){
          for(int j = 0; j < bucket.get(i).size(); j++)
            result.add(bucket.get(i).get(j));
          k -= bucket.get(i).size();
          if(k <= 0) return result.subList(0, result.size() + k);
        }
        return result;
    }
}
