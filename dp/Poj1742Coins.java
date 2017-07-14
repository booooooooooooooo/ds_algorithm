import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      int m = cin.nextInt();
      if(n == 0 && m == 0) return;
      int[] a = new int[n + 1];
      int[] c = new int[n + 1];
      for(int i = 1; i <= n; i++) a[i] = cin.nextInt();
      for(int i = 1; i <= n; i++) c[i] = cin.nextInt();
      System.out.println(solve(a, c, n, m));
    }
  }
  public static int solve(int[] a, int[] c, int n, int m){
    int[] dp = new int[m + 1];
    for(int i = 1; i <= n; i++){
      // dp[0] = c[i];//do not use dp[0] to achieve robust
      for(int j = 1; j <= m; j++){
        if(i >= 2 && dp[j] != -1) dp[j] = c[i];//construct j with out a[i]
        else if( j < a[i]) dp[j] = -1;
        else if( j == a[i]) dp[j] = c[i] - 1; // not necessay, but more controlable
        else if(dp[j - a[i]] == -1) dp[j] = -1;
        else dp[j] = dp[j-a[i]] - 1;
      }
    }
    int count = 0;
    for(int i = 1; i <= m; i++)
      if(dp[i] != -1) count++;
    return count;
  }
}
