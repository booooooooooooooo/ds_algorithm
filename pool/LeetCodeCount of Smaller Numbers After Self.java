public class Solution {
    public List<Integer> countSmaller(int[] nums) {
      //get map. map maps num to index in unique and sortted array
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0; i < nums.length; i++) map.put(nums[i], 0);
      int unique[] = new int[map.size()];
      int j = 0;
      for(Integer num : map.keySet()){
        unique[j] = num;
        j++;
      }
      Arrays.sort(unique);
      for(int i = 0; i < unique.length; i++) map.put(unique[i], i);
      //use BIT to update count and get sum.
      int[] count = new int[nums.length];
      BIT bit = new BIT(map.size());
      for(int i = nums.length - 1; i >= 0; i--){
        int index = map.get(nums[i]);
        bit.add(index + 1, 1);
        count[i] = bit.getSum(index);
      }
      //convert to required format and return
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < count.length; i++) result.add(count[i]);
      return result;
    }
}

class BIT{
  private int n_;
  private int[] dat;
  public BIT(int n){
    n_ = 1;
    while(n_ < n) n_ *= 2;
    dat = new int[n_ + 1];
    Arrays.fill(dat, 0);
  }
  //get sum of [0, k) in initial array
  public int getSum(int k){
    int s = 0;
    while(k >= 1){
      s += dat[k];
      k = k - ( k&(-k) );
    }
    return s;
  }
  //add x to arr[k - 1]
  public void add(int k, int x){
    while(k <= n_){
      dat[k] += x;
      k = k + ( k&(-k) );
    }
  }
}








public class Solution {
    public List<Integer> countSmaller(int[] nums) {
      //get map. map maps num to index in unique and sortted array
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0; i < nums.length; i++) map.put(nums[i], 0);
      int unique[] = new int[map.size()];
      int j = 0;
      for(Integer num : map.keySet()){
        unique[j] = num;
        j++;
      }
      Arrays.sort(unique);
      for(int i = 0; i < unique.length; i++) map.put(unique[i], i);
      //use SumSegmentTree to update count and get sum.
      int[] count = new int[nums.length];
      SumSegmentTree segTree = new SumSegmentTree(map.size());
      for(int i = nums.length - 1; i >= 0; i--){
        int index = map.get(nums[i]);
        segTree.add(index, 1);
        count[i] = segTree.querySum(0,index);
      }
      //convert to required format and return
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < count.length; i++) result.add(count[i]);
      return result;

    }
}

class SumSegmentTree{
  private int n_;
  private int[] dat;
  //n = length of initial array
  public SumSegmentTree(int n){
    n_ = 1;
    while(n_ < n) n_ *= 2;
    dat = new int[2 * n_ - 1];
    Arrays.fill(dat, 0);
  }
  //k is index in initial array. a is amount to add to value at index k.
  public void add(int k, int a){
    k += n_ - 1;
    dat[k] += a;
    while(k > 0){
      k = (k - 1) / 2;
      dat[k] += a;
    }
  }
  public int querySum(int start, int end){
    return query(start, end, 0, 0, n_);
  }
  //[start, end) is sum interval in initial array.
  //k_ is the index in segment tree.
  //[l, r) is the inteval in initial array that k_ corresponds to
  private int query(int start, int end, int k_, int l, int r){
    if(r <= start || end <= l) return 0;
    else if(start <= l && r <= end) return dat[k_];
    else{
      return query(start, end, k_ * 2 + 1, l, (l + r) / 2)
              + query(start, end, k_ * 2 + 2, (l + r) / 2, r);
    }
  }
}
