public class LeetCodeSearchinRotatedSortedArray {
  public int search(int[] nums, int target) {
    int indexOfMin = getIndexOfMin(nums);
    int l1 = lowerBound(nums, 0, indexOfMin - 1 + 1, target);
    int u1 = upperBound(nums, 0, indexOfMin - 1 + 1, target);
    int l2 = lowerBound(nums, indexOfMin, nums.length, target);
    int u2 = upperBound(nums, indexOfMin, nums.length, target);
    if (l1 < u1)
      return l1;
    else if (l2 < u2)
      return l2;
    else
      return -1;
  }
  private  int getIndexOfMin(int[] nums){
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if(nums[mid] < nums[high]){
        high = mid;
      }else{
        low = mid + 1;
      }
    }
    return low;
  }
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
}
