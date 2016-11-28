/*
18. 4Sum   QuestionEditorial Solution  My Submissions
Total Accepted: 93589
Total Submissions: 370341
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
import java.util.*;
public class LeetCode4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int k = 0;
        while( k <= nums.length - 1){
          int i = k + 1;
          while(i <= nums.length - 1 ){
            int twoSum = target - nums[k] - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
              if(nums[left] + nums[right] > twoSum) right--;
              else if (nums[left] + nums[right] < twoSum) left++;
              else{
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(new Integer(nums[k]));
                solution.add(new Integer(nums[i]));
                solution.add(new Integer(nums[left]));
                solution.add(new Integer(nums[right]));
                // for(int j = 0; j < solution.size(); j++){
                //   System.out.printf("%d  ", solution.get(j));
                // }
                // System.out.println();
                solutionSet.add(solution);
                left++;
                while(left < right && nums[left] == nums[left - 1]) left++;
                right--;
                while(left < right && nums[right] == nums[right + 1]) right--;
              }
            }
            i++;
            while(i <= nums.length - 1 && nums[i] == nums[i - 1]) i++;
          }
          k++;
          while(k <= nums.length - 1 && nums[k] == nums[k - 1]) k++;
        }
        return solutionSet;
    }
}
