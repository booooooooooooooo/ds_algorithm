public class Solution {
    public int search(int[] nums, int target) {
      //exclude empty list case, actually this is covered in last step return -1
      if(nums.length == 0) return -1;
      //process general case
      int first = 0;
      int last = nums.length;
      while(first < last){
        int mid = first + (last - first) / 2;
        if(target > nums[mid]){
          if( nums[mid] < nums[0] && target > nums[last - 1]) last = mid;//abnormal case
          else first = mid + 1;
        }else if( target < nums[mid]){
          if( nums[mid] >= nums[0] && target < nums[first]) first = mid + 1;//abnormal case
          else last = mid;
        }else return mid;
      }
      //not found return -1
      return -1;
    }
}
