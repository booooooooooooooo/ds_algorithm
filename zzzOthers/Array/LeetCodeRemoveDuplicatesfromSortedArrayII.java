// public class Solution {
//     public int removeDuplicates(int[] nums) {
//       int t1 = 0, t2 = 0;
//       while(t2 < nums.length){
//         int temp = nums[t2];
//         int count = 0;
//         while(t2 < nums.length && nums[t2] == temp){
//           count++;
//           t2++;
//         }
//         if(count == 1){
//           nums[t1] = temp;
//           t1++;
//         }else{
//           nums[t1] = temp;
//           nums[t1 + 1] = temp;
//           t1 += 2;
//         }
//       }
//       return t1;
//     }
// }

public class Solution {
    public int removeDuplicates(int[] nums) {
      int index = 0;
      boolean isDuplicate = false;
      for(int i = 1; i < nums.length; i++){
        if(nums[index] != nums[i]){
          index++;
          nums[index] = nums[i];
          isDuplicate = false;
        }else if(!isDuplicate){
          index++;
          nums[index] = nums[i];
          isDuplicate = true;
        }else ;
      }
      return index + 1;
    }
}
