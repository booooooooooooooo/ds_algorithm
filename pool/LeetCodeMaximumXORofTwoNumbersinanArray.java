public class Solution {
    public int findMaximumXOR(int[] nums) {
        //exclude corner case


        int result = 0;

        Set<Integer> negative = new HashSet<Integer>();
        Set<Integer> positive = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
          if( (nums[i] & (1 << 31)) == 0 ) positive.add(i);
          else negative.add(i);
        }
        for(int index = 30; index >= 0; index--){
          Set<Integer> setP0 = new HashSet<Integer>();
          Set<Integer> setP1 = new HashSet<Integer>();
          for(Integer i : positive){
            if((nums[i] & (1 << index) ) == 0 ) setP0.add(i);
            else setP1.add(i);
          }
          if(setP0.size() != positive.size() && setP1.size() != positive.size()){
            result = Math.max(result, solve(nums, setP0, setP1, index));
            break;
          }
        }
        for(int index = 30; index >= 0; index--){
          Set<Integer> setN0 = new HashSet<Integer>();
          Set<Integer> setN1 = new HashSet<Integer>();
          for(Integer i : negative){
            if((nums[i] & (1 << index) ) == 0 ) setN0.add(i);
            else setN1.add(i);
          }
          if(setN0.size() != negative.size() && setN1.size() != negative.size()){
            result = Math.max(result, solve(nums, setN0, setN1, index));
            break;
          }
        }
        return result;
    }
    public int solve(int[] nums, Set<Integer> set0, Set<Integer> set1, int index){
      if(index == -1) return 0;
      Set<Integer> set00 = new HashSet<Integer>();
      Set<Integer> set01 = new HashSet<Integer>();
      Set<Integer> set10 = new HashSet<Integer>();
      Set<Integer> set11 = new HashSet<Integer>();
      for(Integer i : set0){
        if( (nums[i] & (1 << index)) == 0 ) set00.add(i);
        else set01.add(i);
      }
      for(Integer i : set1){
        if( (nums[i] & (1 << index)) == 0 ) set10.add(i);
        else set11.add(i);
      }

      if(set00.size() * set11.size() == 0 && set01.size() * set10.size() == 0){
        return solve(nums, set0, set1, index - 1);
      }else if(set00.size() * set11.size() == 0){
        return (1<<index) + solve(nums, set01, set10, index - 1);
      }else if(set01.size() * set10.size() == 0){
        return (1<<index) + solve(nums, set00, set11, index - 1);
      }else{
        return (1 << index) + Math.max(solve(nums, set00, set11, index - 1),solve(nums, set01, set10, index - 1));
      }
    }
}
