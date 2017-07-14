import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int N = cin.nextInt();
      int M = cin.nextInt();
      int[][] dp = new int[N][N];
      for(int i = 0; i < N; i++){
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[i][i] = 0;
      }
      for(int i = 0; i < M; i++){
        int size = cin.nextInt();
        int[] group = new int[size];
        for(int j = 0; j < size; j++) group[j] = cin.nextInt();
        for(int j = 0; j < size; j++){
          for(int k = 0; k < size; k++)
            if(j != k)
              dp[group[j] - 1][group[k] - 1] = 1;
        }
      }
      //call solve()
      solve(dp);
    }
  }
  public static void solve(int[][] dp){
    //use Floyd-Warshall to update dp[][]
    int N = dp.length;
    for(int node = 0; node < N; node++){
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          if(dp[i][node] != Integer.MAX_VALUE && dp[node][j] != Integer.MAX_VALUE)
            dp[i][j] = Math.min(dp[i][j], dp[i][node] + dp[node][j] );
        }
      }
    }
    //get result from dp[][]
    int result = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++){
      int temp = 0;
      int count = 0;
      for(int j = 0; j < N; j++){
        if(dp[i][j] != 0 && dp[i][j] != Integer.MAX_VALUE){
          count++;
          temp += dp[i][j];
        }
      }
      result = Math.min(result, 100 * temp / count);
    }
    //output result
    System.out.println(result);
  }
}
