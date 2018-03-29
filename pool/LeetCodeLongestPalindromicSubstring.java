

/**
O(n^2) O(n^2) DP
This program is right. But the time is long.
TODO: Manacher s Algorithm
*/
public class Solution {
  public String longestPalindrome(String s) {
    // exclude corner case
    if (s.equals(""))
      return "";

    // initialize dp array
    int n = s.length();
    List<List<Integer>> dp = new ArrayList<List<Integer>>();
    for (int i = 0; i < n; i++)
      dp.add(new ArrayList<Integer>());

    // Scan to update dp
    for (int i = 0; i < n; i++) {
      List<Integer> cur = dp.get(i);
      cur.add(0);
      cur.add(1);
      if (i != 0) {
        List<Integer> prev = dp.get(i - 1);
        for (int j = 0; j < prev.size(); j++) {
          int len = prev.get(j);
          if (i - len - 1 >= 0 && s.charAt(i) == s.charAt(i - len - 1))
            cur.add(len + 2);
        }
      }
    }

    // get result
    int left = -1;
    int right = -1; //[left, right)
    int maxLen = Integer.MIN_VALUE;
    for (int i = 0; i < dp.size(); i++) {
      for (int j = 0; j < dp.get(i).size(); j++) {
        int len = dp.get(i).get(j);
        if (len > maxLen) {
          maxLen = len;
          left = i - len + 1;
          right = i + 1;
        }
      }
    }

    // return result;
    return s.substring(left, right);
  }
}
