import java.util.*;

public class DFS_CF217A {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int x[] = new int[n + 5];
    int y[] = new int[n + 5];
    for (int i = 0; i < n; i++) {
      x[i] = cin.nextInt();
      y[i] = cin.nextInt();
    }

    int ans = solve(n, x, y);
    System.out.println(ans);
  }

  private static int solve(int n, int[] x, int[] y) {
    int ans = -1;
    boolean[] visited = new boolean[n + 5];
    Arrays.fill(visited, false);
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        ans++;
        dfs(n, x, y, visited, i);
      }
    }
    if (ans == -1)
      return 0;
    else
      return ans;
  }

  private static void dfs(int n, int[] x, int[] y, boolean[] visited, int i) {
    visited[i] = true;
    for (int j = 0; j < n; j++) {
      if ((x[j] == x[i] || y[j] == y[i]) && !visited[j]) {
        dfs(n, x, y, visited, j);
      }
    }
  }
}
