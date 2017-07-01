public class Solution {
    public void wiggleSort(int[] nums) {

      int n = nums.length;
      int median = (new Helper()).findKthLargest(nums, (nums.length + 1) / 2 );//TODO: L never goes to S row??
      int left = n % 2 == 0 ? n - 2 : n - 1;
      int i = left;
      int right = 1;
      while(0 <= i && i < n && compare(i, right) <= 0){
        if(nums[i] > median){
          swap(nums, i, right);
          right = decrease(n, right);
        }else if(nums[i] < median){
          //!!!!!!!all values  in [left, i) =  median
          swap(nums, i, left);
          left = increase(n, left);
          i = increase(n, i);
        }else i = increase(n, i);
      }
    }
    private int increase(int n, int i){


      if(i % 2 == 0 && i - 2 >= 0) return i - 2;
      else if(i % 2 == 0 && i - 2 < 0) return n % 2 == 0 ? n - 1 : n - 2;
      else return i - 2;

    }
    private int decrease(int n, int i){
      if(i % 2 == 1 && i + 2 <= (n % 2 == 0 ? n - 1 : n - 2)) return i + 2;
      else if(i % 2 == 1 && i + 2 > (n % 2 == 0 ? n - 1 : n - 2)) return 0;
      else  return i + 2;
    }
    private int compare(int i1, int i2){
      if(i1 % 2 == 0 && i2 % 2 == 1) return -1;
      else if(i1 % 2 == 1 && i2 %2 == 0) return 1;
      else return -(i1 - i2);//!!!!!
    }
    private void swap(int[] nums, int i1, int i2){
      int temp = nums[i1];
      nums[i1] = nums[i2];
      nums[i2] = temp;
    }
}

class Helper {
    public int findKthLargest(int[] nums, int k) {
      //corner
      if(k > nums.length) return Integer.MIN_VALUE;//throw error since invalid input

      return solve(nums, 0, nums.length, k);
    }
    //[left, right)
    private int solve(int[] nums, int left, int right, int k){
      int pivot = (new Random()).nextInt(right - left) + left;
      int parti = partition(nums, left, right, pivot);
      if(right - parti == k) return nums[parti];
      else if(right - parti > k) return solve(nums, parti + 1, right, k);
      else return solve(nums, left, parti, k - (right - parti));
    }
    private int partition(int[] nums, int left, int right, int pivot){
      int valueAtPivot = nums[pivot];
      swap(nums, left, pivot);
      int parti = left + 1;
      for(int i = left + 1; i < right; i++){
        if(nums[i] < valueAtPivot){
          swap(nums, parti, i);
          parti++;
        }
      }
      parti--;
      swap(nums, left, parti);
      int index = parti;
      while(index < right && nums[index] == nums[parti]) index++;
      return (new Random()).nextInt(index - parti) + parti;
    }

    private void swap(int[] nums, int i, int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
}
