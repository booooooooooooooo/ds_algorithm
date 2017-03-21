public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
      int[] result = new int[k];
      Arrays.fill(result, 0);
      for(int i = 0; i <= k; i++){
        if(i > nums1.length || (k - i) > nums2.length){
          continue;
        }
        int[] sub1 = getMaxSubSequence(nums1, i);
        int[] sub2 = getMaxSubSequence(nums2, k - i);
        int[] current = mergeToMaxSumSequence(sub1, sub2);
        if(isLarger(current, 0,result, 0)) result = current;
      }
      return result;
    }

    //len <= nums.length
    public int[] getMaxSubSequence(int[] nums, int len){
      int[] sub = new int[len];
      int pre = -1;
      int restLen = len;
      for(int i = 0; i < len; i++){
        pre = greedyPick(nums, pre, restLen);
        sub[i] = nums[pre];
        restLen--;
      }
      return sub;
    }
    public int greedyPick(int[] nums, int pre, int restLen){
      for(int i = 9; i >= 0; i--){
        for(int j = pre + 1; j <= nums.length - restLen; j++){
          if(nums[j] == i){
            return j;
          }
        }
      }
      return -1;//will not execute
    }

    public int[] mergeToMaxSumSequence(int[] sub1, int[] sub2){

      int n1 = sub1.length;
      int n2 = sub2.length;
      int i1 = 0;
      int i2 = 0;

      int[] result = new int[n1 + n2];
      int i = 0;
      while(i1 < n1 && i2 < n2){
        if(isLarger(sub1, i1, sub2, i2)){
          result[i1 + i2] = sub1[i1];
          i1++;
          i++;
        }else{
          result[i1 + i2] = sub2[i2];
          i2++;
          i++;
        }
      }
      while(i1 < n1){
        result[i] = sub1[i1];
        i1++;
        i++;
      }
      while(i2 < n2){
        result[i] = sub2[i2];
        i2++;
        i++;
      }

      return result;
    }

    public boolean isLarger(int[] sub1, int i1, int[] sub2, int i2){
      while(i1 < sub1.length && i2 < sub2.length){
        if(sub1[i1] < sub2[i2]) return false;
        if(sub1[i1] > sub2[i2]) return true;
        i1++;
        i2++;
      }
      if(i1 < sub1.length) return true;
      return false;
    }
}
