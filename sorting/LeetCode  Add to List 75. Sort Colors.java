public class Solution {
    public void sortColors(int[] nums) {
      //corner case: None

      //initialize postion to put 0 and position to put 2
      int tail0 = 0;
      int tail2 = nums.length - 1;
      //sort
      int i = tail0;
      while(i <= tail2){
        if(nums[i] == 0){
          swap(nums, tail0, i);
          tail0++;
          i++;
        }else if(nums[i] == 2){
          swap(nums, tail2, i);
          tail2--;
        }else{
          i++;
        }
      }
    }
    public void swap(int[] nums, int index1, int index2){
      int temp = nums[index1];
      nums[index1] = nums[index2];
      nums[index2] = temp;
    }
}
