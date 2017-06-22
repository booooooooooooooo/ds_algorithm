public class Solution {
    public boolean search(int[] nums, int target) {
      if(nums.length >= 2 && nums[0] == nums[nums.length - 1]){
        if(nums[0] == target) return true;
        else{
          int last = nums.length - 1;
          while(last >= 0 && nums[last] == nums[0]) last--;
          return solve(nums, 0, last + 1, target);
        }
      }

      return solve(nums, 0, nums.length, target);
    }
    private boolean solve(int[] nums, int first, int last, int target){
      //empty range
      if(first >= last) return false;
      //not-empty range
      while(first < last){
        int mid = first + (last - first) / 2;
        if(target > nums[mid]){
          if( nums[mid] < nums[first] && target > nums[last - 1]) last = mid;
          else first = mid + 1;
        }else if( target < nums[mid]){
          if( nums[mid] >= nums[first] && target < nums[first]) first = mid + 1;
          else last = mid;
        }else
          return true;
      }
      return false;
    }
}
