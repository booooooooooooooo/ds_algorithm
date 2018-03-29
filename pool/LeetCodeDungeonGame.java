public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
      if(dungeon.length == 0) return -1;//exclude corner case
      if(dungeon[0].length == 0) return -1; //exclude corner case

      int m = dungeon.length;
      int n = dungeon[0].length;
      int[][] dp = new int[m][n];
      for(int i = m - 1; i >= 0; i--){
        for(int j = n-1; j >= 0; j--){
          if(i == m - 1 && j == n - 1){
            dp[m-1][n-1] = 1 - dungeon[m-1][n-1] > 0? 1 - dungeon[m-1][n-1] : 1;
          }else if(i == m - 1){
            dp[m-1][j] = dp[m-1][j + 1] - dungeon[m-1][j] > 0 ? dp[m-1][j + 1] - dungeon[m-1][j] : 1;
          }else if(j == n - 1){
            dp[i][n-1] = dp[i+1][n-1] - dungeon[i][n-1] > 0 ? dp[i+1][n-1] - dungeon[i][n-1] : 1;
          }else{
            int choice1 = dp[i][j+1] - dungeon[i][j];
            int choice2 = dp[i+1][j] - dungeon[i][j];
            dp[i][j] = Math.min(choice1, choice2) > 0 ? Math.min(choice1, choice2) : 1;
          }
        }
      }
      return dp[0][0];
    }
}
