/*
31. Next Permutation   QuestionEditorial Solution  My Submissions
Total Accepted: 87079
Total Submissions: 312361
Difficulty: Medium
Contributors: Admin
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
public class LeetCodeNextPermutation {
    public void nextPermutation(int[] nums) {
        int curMax = Integer.MIN_VALUE;
        int i;
        for(i = nums.length -1; i >=0; i--){
            if(nums[i] < curMax) break;
            else curMax = nums[i];
        }
        if(i < 0) reverse(nums, 0, nums.length - 1);
        else{
            switchWithFollowingClosestBiggerOne(nums, i);
            reverse(nums, i + 1, nums.length - 1);
        }
    }
    public void reverse(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void switchWithFollowingClosestBiggerOne(int[] nums, int i){
        int j = i + 1;
        while( j <= nums.length - 1){
            if(nums[j] > nums[i]) j++;
            else break;
        }
        j--;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
