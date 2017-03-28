public class Solution {
    public int reversePairs(int[] nums) {
        //Make candidates[] that stores unique values of nums[i]*2 in acsending order.
        //Caution: use long to avoid overflow
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int left = 0;
        int right = 0;
        while(right < temp.length){
          temp[left] = temp[right];
          left++;
          right++;
          while(right + 1 < temp.length && temp[right] == temp[right + 1]) right++;
        }
        long[] candidates = new long[left];
        for(int i = 0; i < candidates.length; i++){
          candidates[i] = 2 * (long)temp[i];
        }


        //make Segment tree of the frequency of each candidates[i]
        SegmentTree segTree = new SegmentTree(candidates.length);
        //initialize result
        int countPairs = 0;
        //Process nums[], update segTree and countPairs.
        for(int i = nums.length - 1; i >= 0; i--){
            int indexInArr =  getLowerBound(candidates, (long)nums[i]);
            int count = segTree.query(0, indexInArr);//[0, indexInArr)
            countPairs += count;
            int indexToIncrease = getLowerBound(candidates, 2 * (long)nums[i]);
            segTree.increaseByOne(indexToIncrease);
        }
        return countPairs;
    }

    public int getLowerBound(long[] candidates, long value){
      int low = 0;
      int high = candidates.length;
      while(low < high){
        int mid = low + (high - low) / 2;
        if(candidates[mid] < value) low = mid + 1;
        else high = mid;
      }
      return low;
    }

    class SegmentTree{
      int n;
      int[] dat;
      public SegmentTree(int n_){
        n = 1;
        while(n < n_) n *= 2;
        dat = new int[n * 2 - 1];
        Arrays.fill(dat, 0);
      }

      public void increaseByOne(int indexInArr){
        int valueAtIndex = dat[indexInArr + n - 1] + 1;
        update(indexInArr, valueAtIndex);
      }

      private void update(int indexInArr, int valueAtIndex){
        int indexInDat = indexInArr + n - 1;
        dat[indexInDat] = valueAtIndex;
        while(indexInDat > 0){
          indexInDat = (indexInDat - 1) / 2;
          dat[indexInDat] = dat[indexInDat * 2 + 1] + dat[indexInDat * 2 + 2];
        }
      }
      //get sum of values in [a, b) from arr[].
      public int query(int a, int b){
        return query(a, b, 0, 0, n);
      }

      private int query(int a, int b, int node, int l, int r){
        if(b <= l || r <= a) return 0;

        if(a <= l && r <= b) return dat[node];
        else return query(a, b, node*2 + 1, l, (l + r) / 2) + query(a, b, node*2 + 2, (l+r)/2, r);//TODO: check whether (;+r)/2 works

      }
    }

}
