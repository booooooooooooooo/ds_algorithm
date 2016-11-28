public class LeetCodeMedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if( (nums1.length + nums2.length) % 2 == 1 ){
        int k = (nums1.length + nums2.length) / 2 + 1;
        return findKthElement(nums1, 0, nums2, 0, k);
      }else{
        int k1 = (nums1.length + nums2.length) / 2 ;
        int k2 = (nums1.length + nums2.length) / 2 + 1;
        // System.out.printf("%dth: %d\n", k1, findKthElement(nums1, 0, nums2, 0, k1));
        // System.out.printf("%dth: %d\n", k2, findKthElement(nums1, 0, nums2, 0, k2));
        return (double)(findKthElement(nums1, 0, nums2, 0, k1) +  findKthElement(nums1, 0, nums2, 0, k2)) / 2;
      }
    }

    public int findKthElement(int[] nums1, int tail1, int[] nums2, int tail2, int k){
      /* Make sure nums1.length - tail1 <= nums2.length - tail2 */
      if(nums1.length - tail1 > nums2.length - tail2)
        return findKthElement(nums2, tail2, nums1, tail1, k);

      // System.out.printf("nums1 \n");
      // for(int i = tail1; i < nums1.length; i++){
      //   System.out.printf("%3d", nums2[i]);
      // }
      // System.out.println();
      // System.out.printf("nums2 \n");
      // for(int i = tail2; i < nums2.length; i++){
      //   System.out.printf("%3d", nums2[i]);
      // }
      // System.out.println();

      if(nums1.length == tail1)
        return nums2[tail2 + k - 1];
      else if(nums2.length == tail2)
        return nums1[tail1 + k - 1];
      else if(k == 1)
        return Math.min(nums1[tail1], nums2[tail2]);
      else{
        int accu1 = Math.min(k / 2 - 1, nums1.length - 1 - tail1);
        int accu2 = k / 2  - 1 + k / 2 - 1 - accu1;
        if(nums1[tail1 + accu1] <= nums2[tail2 + accu2]){
          return findKthElement(nums1, tail1 + accu1 + 1, nums2, tail2, k - accu1 - 1);
        }else{
          return findKthElement(nums1, tail1, nums2, tail2 + accu2 + 1, k - accu2 - 1);
        }
      }
    }

}
