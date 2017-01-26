public class Solution {
  public int minCut(String s) {
    // get isPalindrome array
    boolean[][] isPalindrome = getIsPalindorme(s);
    // get dp array
    int n = s.length();
    int[] dp = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      if (isPalindrome[i][n - 1])
        dp[i] = 0;
      else {
        int temp = Integer.MAX_VALUE;
        for (int j = i; j < n - 1; j++) {
          if (isPalindrome[i][j])
            temp = Math.min(temp, dp[j + 1] + 1);
        }
        dp[i] = temp;
      }
    }
    // return result
    return dp[0];
  }

  public boolean[][] getIsPalindorme(String s) {
    int n = s.length();
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = 0; i <= n - 1; i++) {
      updateCenter(s, i, isPalindrome);
      updateCenterLeft(s, i, isPalindrome);
    }
    return isPalindrome;
  }
  public void updateCenter(String s, int index, boolean[][] isPalindrome) {
    int n = s.length();
    int left = index;
    int right = index;
    boolean isValid = true;
    while (left >= 0 && right <= n - 1) {
      if (s.charAt(left) != s.charAt(right))
        isValid = false;
      isPalindrome[left][right] = isValid;
      left--;
      right++;
    }
  }
  public void updateCenterLeft(String s, int index, boolean[][] isPalindrome) {
    int n = s.length();
    int left = index;
    int right = index + 1;
    boolean isValid = true;
    while (left >= 0 && right <= n - 1) {
      if (s.charAt(left) != s.charAt(right))
        isValid = false;
      isPalindrome[left][right] = isValid;
      left--;
      right++;
    }
  }
}

/**
n^3 TLE
*/
public class Solution {
  public int minCut(String s) {
    // get isPalindrome array
    boolean[][] isPalindrome = getIsPalindorme(s);
    // get dp array
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j <= n - 1; j++) {
        if (isPalindrome[i][j])
          dp[i][j] = 0;
        else {
          int temp = Integer.MAX_VALUE;
          for (int k = i; k < j; k++)
            temp = Math.min(temp, dp[i][k] + dp[k + 1][j] + 1);
          dp[i][j] = temp;
        }
      }
    }
    // return result;
    return dp[0][n - 1];
  }
}
