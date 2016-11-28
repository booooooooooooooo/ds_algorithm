  public class Solution {
      public int[] searchRange(int[] nums, int target) {
        int l = lowerBound(nums, 0, nums.length, target);
        int h = upperBound(nums, 0, nums.length, target);
        if (l == h) {
          return new int[] {-1, -1};
        }
        return new int[] {l, h - 1};
      }

      int lowerBound(int[] array, int first, int last, int value) {
        while(first < last){
          int mid = first + (last - first) / 2; //prevent max integer overflow of (first + last) / 2
          if(array[mid] < value) first = mid + 1;
          else last = mid;
        }
        return first;
      }


      int upperBound(int[] array, int first, int last, int value) {
        while(first < last){
          int mid = first + (last - first) / 2;
          if(array[mid] <= value) first = mid + 1;
          else last = mid;
        }
        return first;
      }
  }
