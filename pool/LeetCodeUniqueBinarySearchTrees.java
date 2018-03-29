public class Solution {
  public int numTrees(int n) {
    // exclude corner case
    if (n == 0)
      return 0; // also make sense to return 1
    // get dp array
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) { // i := use i nodes to make bst
      int way = 0;
      for (int j = 1; j <= i; j++) {
        way = way + dp[j - 1] * dp[i - j]; // caution:  node j is used as root
      }
      dp[i] = way;
    }
    // return result;
    return dp[n];
  }
}
