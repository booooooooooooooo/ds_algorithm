/*

*/

//
// public class LeetCodeRemoveDuplicatesfromSortedArray {
//     public int removeDuplicates(int[] nums) {
//        int tail = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(tail == 0 || nums[i] != nums[tail - 1]){
//                nums[tail] = nums[i];
//                tail++;
//            }
//        }
//        return tail;
//     }
// }


public class Solution {
    public int removeDuplicates(int[] nums) {
       int index = 0;
       for(int i = 1; i < nums.length; i++){ //!!!! int i = 1
         if(nums[index] != nums[i]){
           index++;
           nums[index] = nums[i];
         }
       }
     return index + 1;
   }
}
