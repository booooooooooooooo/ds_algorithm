/**
k belongs to [1, nums1.length + nums2.length]
*/

/**
TOOD: When any array's
*/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if( (nums1.length + nums2.length) % 2 == 1 ){
        int k = (nums1.length + nums2.length) / 2 + 1;
        return findKthElement(nums1, 0, nums2, 0, k);
      }else{
        int k1 = (nums1.length + nums2.length) / 2 ;
        int k2 = (nums1.length + nums2.length) / 2 + 1;
        return (double)(findKthElement(nums1, 0, nums2, 0, k1) +  findKthElement(nums1, 0, nums2, 0, k2)) / 2;
      }
    }

    public int findKthElement(int[] nums1, int t1, int[] nums2, int t2, int k){
      //exlude empty lists case
      if(nums1.length == 0 && nums2.length == 0) ;//throews error
      if(nums1.length == 0) return  nums2[t2 + k - 1];
      if(nums2.length == 0) return nums1[t1 + k - 1];
      //Make sure nums1.length - t1 <= nums2.length - t2
      if(nums1.length - t1 > nums2.length - t2)
        return findKthElement(nums2, t2, nums1, t1, k);
      //base case
      if(nums1.length == t1)
        return nums2[t2 + k - 1];
      if(k == 1)
        return Math.min(nums1[t1], nums2[t2]);


      //recursive to base cases
      int newT1 = Math.min(t1 + k / 2 - 1, nums1.length - 1);// - 1 to prevent index out of range
      int newT2 = t2 + (k - k / 2 - 1);// - 1 to prevent index out of range
      if(nums1[newT1] < nums2[newT2])
        return findKthElement( nums1, newT1 + 1, nums2, t2, k - (newT1 + 1 - t1) );//+1 to make sure moving forword
      else
        return findKthElement( nums1, t1, nums2, newT2 + 1, k - (newT2 + 1 - t2) );//+1 to make sure moving forword


    }
}
