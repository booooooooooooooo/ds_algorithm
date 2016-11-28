public class LeetCodeSearchforaRange {
  // input [first, last)
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

  // input [first, last)
  int upperBound(int[] array, int first, int last, int value) {
    int count = last - first;
    while (count > 0) {
      int step = count / 2;
      int mid = first + step;
      if (!(value < array[mid])) {
        first = mid + 1;
        count -= step + 1;
      } else {
        count = step;
      }
    }
    return first;
  }

  public int[] searchRange(int[] nums, int target) {
    int l = lowerBound(nums, 0, nums.length, target);
    int h = upperBound(nums, 0, nums.length, target);
    if (l == h) {
      return new int[] {-1, -1};
    }
    return new int[] {l, h - 1};
  }
}
