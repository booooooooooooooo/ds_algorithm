/**
Use two dimensional dp array and record path.
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      List<List<Pair>> dp = new ArrayList<List<Pair>>();
      for(int i = 0; i < n; i++){
        dp.add(new ArrayList<Pair>());
        for(int j = 0; j <= i; j++){
          if(i == 0) dp.get(0).add(new Pair(triangle.get(0).get(0) + 0, -1));
          else{
            if(j >= 1 && j <= i - 1){
              int left = dp.get(i - 1).get(j - 1).cost;
              int right = dp.get(i - 1).get(j).cost;
              int cur = triangle.get(i).get(j);
              if(left < right) dp.get(i).add(new Pair(left + cur, j - 1));
              else dp.get(i).add(new Pair(right + cur, j));
            }else if(j == 0){
              int right = dp.get(i - 1).get(j).cost;
              int cur = triangle.get(i).get(j);
              dp.get(i).add(new Pair(right + cur, j));
            }else{
              int left = dp.get(i - 1).get(j - 1).cost;
              int cur = triangle.get(i).get(j);
              dp.get(i).add(new Pair(left + cur, j - 1));
            }
          }
        }
      }
      int minTotal = Integer.MAX_VALUE;
      for(int j = 0; j < n; j++)
        if(dp.get(n - 1).get(j).cost < minTotal) minTotal = dp.get(n - 1).get(j).cost;

      return minTotal;
    }
}

class Pair{
  public int cost;
  public int prev;
  public Pair(int cost, int prev){
    this.cost = cost;
    this.prev = prev;
  }
}


/**
Use one dimensional dp array.
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int n = triangle.size();
      int[] dp = new int[n];
      for(int i = 0; i < n; i++){
        for(int j = i; j >= 0; j--){
          int cur = triangle.get(i).get(j);
          if(i == 0 && j == 0) dp[j] = cur;
          else{
            if(j == 0) dp[j] = dp[j] + cur;
            else if(j == i) dp[j] = dp[j - 1] + cur;
            else dp[j] = dp[j] < dp[j - 1] ? dp[j] + cur : dp[j - 1] + cur;
          }
        }
      }
      int result = Integer.MAX_VALUE;
      for(int v : dp)
        result = result < v ? result : v;
      return result;
    }
}
