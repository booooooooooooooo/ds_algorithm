public class LeetCodeSearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
      return lowerBound(nums, 0, nums.length, target);
    }
    int lowerBound(int[] array, int first, int last, int value) {
      int count = last - first;
      while (count > 0) {
        int step = count / 2;
        int mid = first + step;
        if (array[mid] < value) {
          first = mid + 1;
          count -= step + 1;
        } else
          count = step;
      }
      return first;
    }
}
