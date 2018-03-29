import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int f = cin.nextInt();
    while(f-- > 0){
      int n = cin.nextInt();
      int m = cin.nextInt();
      int w = cin.nextInt();
      int[][] edges = new int[m * 2 + w][3];

      for(int i = 0; i < m; i++){
        int start = cin.nextInt() - 1;
        int end = cin.nextInt() - 1;
        int weight = cin.nextInt();
        edges[i * 2][0] = start;
        edges[i * 2][1] = end;
        edges[i * 2][2] = weight;
        edges[i * 2 + 1][0] = end;
        edges[i * 2 + 1][1] = start;
        edges[i * 2 + 1][2] = weight;
      }
      for(int i = m * 2; i < m * 2 + w; i++){
        int start = cin.nextInt() - 1;
        int end = cin.nextInt() - 1;
        int weight = cin.nextInt();
        edges[i][0] = start;
        edges[i][1] = end;
        edges[i][2] = -weight;
      }

      //call solve()
      solve(edges, n);
    }
  }
  public static void solve(int[][] edges, int n){
    //bellman-ford
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < edges.length; j++){
        int start = edges[j][0];
        int end = edges[j][1];
        int weight = edges[j][2];
        if(dp[start] != Integer.MAX_VALUE && dp[end] > dp[start] + weight)
          dp[end] = dp[start] + weight;
      }
    }
    //check negative cycle : if there is update in nth iteration
    for(int j = 0; j < edges.length; j++){
      int start = edges[j][0];
      int end = edges[j][1];
      int weight = edges[j][2];
      if(dp[start] != Integer.MAX_VALUE && dp[end] > dp[start] + weight){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
