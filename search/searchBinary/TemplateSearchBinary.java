/**
All ranges are [   ) intervals.
lowerBound: index of first element who >= value or array.length
upperBound: index of first element who > value or array.length
*/

public class TemplateSearchBinary {
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

  public int[] searchRange(int[] nums, int value) {
    int l = lowerBound(nums, 0, nums.length, value);
    int h = upperBound(nums, 0, nums.length, value);
    if (l == h) {
      return new int[] {-1, -1};
    }
    return new int[] {l, h - 1};
  }
}
