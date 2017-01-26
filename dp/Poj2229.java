import java.util.*;
public class Poj2229 {
  private static int[] dp;
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    dp = new int[n + 1];
    solve(n);
    System.out.println(dp[n]);
  }
  private static void solve(int n) {
    for (int i = 1; i <= n; i++) {
      if (i == 1)
        dp[1] = 1;
      else if (i % 2 == 0)
        dp[i] = (dp[i - 1] + dp[i / 2]) % 1000000000;
      else
        dp[i] = dp[i - 1];
    }
  }
}
