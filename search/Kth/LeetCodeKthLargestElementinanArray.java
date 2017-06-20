import java.util.*;
public class Solution {
    public int findKthLargest(int[] nums, int k) {
      //corner
      if(k > nums.length) return Integer.MIN_VALUE;//throw error since invalid input

      return solve(0, nums.length, nums.length + 1 - k, nums);
    }
    //[left, right)
    private int solve(int left, int right, int k, int[] nums){
      int pivot = getPivot( left,  right,  nums);
      // System.out.printf("Povit Value: %d\n", nums[pivot]);
      int parti = partition( left,  right,  pivot, nums);
      // System.out.printf("left: %d\n", left);
      // System.out.printf("right: %d\n", right);
      // System.out.printf("k: %d\n", k);
      // System.out.printf("parti: %d\n", parti);
      // System.out.println(Arrays.toString(nums));
      if(parti - left + 1 == k) return nums[parti];
      else if(parti - left + 1 > k) return solve(left, parti, k, nums);
      else return solve(parti + 1, right, k - (parti + 1 - left), nums);
    }

    private int getPivot(int left, int right, int[] nums){
      int[] indexes = new int[right - left];
      for(int i = 0; i < indexes.length; i++){
        indexes[i] = i + left;
      }
      return getPivotDo(indexes, nums);
    }

    private int getPivotDo(int[] indexes, int[] nums){
      if(indexes.length <= 2) return indexes[0] ;

      int len = indexes.length;
      int nextLen = len % 5 == 0 ? len / 5 : len / 5 + 1;
      int[] nextindexes = new int[nextLen];
      for(int i = 0; i < nextLen; i++){
        sortNums(indexes, i*5, Math.min(i*5+5, len), nums );
        nextindexes[i] = indexes[Math.min(i * 5 + 2, len-1)];
      }
      return getPivotDo(nextindexes, nums);
    }
    private void sortNums(int[] indexes, int left, int right, int[] nums){
      for(int i = left; i < right; i++){
        for(int j = left; j > 0; j--){
          if(nums[indexes[j]] < nums[indexes[j-1]]) swap(indexes[j], indexes[j-1], nums);
        }
      }
    }


    //left of pivot <= pivot, right of pivot >= pivot!!!
    private int partition(int left, int right, int pivot, int[] nums){
      int div = nums[pivot];
      swap(left, pivot, nums);
      pivot = left + 1;
      for(int i = left + 1; i < right; i++){
        if(nums[i] < div){
          swap(pivot, i, nums);
          pivot++;
        }
      }
      pivot--;
      swap(left, pivot, nums);
      return pivot;
    }

    private void swap(int i, int j, int[] nums){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
}
