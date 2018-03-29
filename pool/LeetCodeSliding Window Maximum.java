public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if(nums.length == 0) return new int[0];
      int[] maxOfWindow = new int[nums.length - (k - 1)];
      Deque<Integer> dq = new ArrayDeque<Integer>();
      for(int i = 0;i < nums.length; i++){
        while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.removeLast();
        dq.addLast(i);
        if(!dq.isEmpty() && dq.peekFirst() < i - (k - 1)) dq.removeFirst();
        if(i >= k - 1) maxOfWindow[i- (k - 1)] = nums[dq.peekFirst()];
      }
      return maxOfWindow;
    }
}
