public class LeetCodeJumpGame {
  public boolean canJump(int[] nums) {
    /* (l, r]*/
    int l = -1;
    int r = 0;
    while (r < nums.length - 1) {
      if (l == r)
        return false;
      int nextR = r;
      for (int i = l + 1; i <= r; i++) {
        nextR = Math.max(nextR, i + nums[i]);
      }
      l = r;
      r = nextR;
    }
    return true;
  }
}
