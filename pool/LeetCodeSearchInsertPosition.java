public class Solution {
    public int searchInsert(int[] nums, int target) {
      return lowerBound(nums, 0, nums.length, target);
    }
    int lowerBound(int[] array, int first, int last, int value) {
      while(first < last){
        int mid = first + (last - first) / 2;
        if(array[mid] < value) first = mid + 1;
        else last = mid;
      }
      return first;
    }
}
