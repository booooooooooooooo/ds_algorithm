/*
15. 3Sum   QuestionEditorial Solution  My Submissions
Total Accepted: 159267
Total Submissions: 779062
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
import java.util.*;
public class LeetCode3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutionSet = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int i = 0;
        while(i <= nums.length - 1 ){
          int twoSum = 0 - nums[i];
          int left = i + 1;
          int right = nums.length - 1;
          while(left < right){
            if(nums[left] + nums[right] > twoSum) right--;
            else if (nums[left] + nums[right] < twoSum) left++;
            else{
              List<Integer> solution = new ArrayList<Integer>();
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
        return solutionSet;
    }
}
