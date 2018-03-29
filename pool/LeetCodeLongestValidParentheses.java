public class Solution {
  public int longestValidParentheses(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    else if (n == 1)
      return 0;
    else if (n == 2) {
      return (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
    } else {
      int[] dp = new int[n];
      dp[0] = 0;
      dp[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
      for (int i = 2; i < n; i++) {
        if (s.charAt(i) == '(')
          dp[i] = 0;
        else {
          if (s.charAt(i - 1) == '(')
            dp[i] = dp[i - 2] + 2;
          else {
            int index = i - 1 - dp[i - 1];
            if (index >= 0 && s.charAt(index) == '(') {
              if (index - 1 >= 0)
                dp[i] = dp[i - 1] + 2 + dp[index - 1];
              else
                dp[i] = dp[i - 1] + 2;
            } else
              dp[i] = 0;
          }
        }
      }
      int result = 0;
      for (int i = 0; i < n; i++)
        result = dp[i] > result ? dp[i] : result;
      return result;
    }
  }
}
