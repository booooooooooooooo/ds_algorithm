public class Solution {
    public int maxProfit(int k, int[] prices) {
			//exclude corner case
			if(prices.length == 0 || k < 0) return 0;

			//process large k
			if(k > prices.length / 2){
				int result = 0;
				for(int i = 1; i < prices.length; i++){
					if(prices[i] - prices[i-1] > 0){
						result += prices[i] - prices[i-1];
					}
				}
				return result;
			}
			//process small k
			int n = prices.length;
			//dp[i][j] = max profit if do at most i transactions using [prices[0], prices[j]]
			//dp[i][j] = max(dp[i][j-1], max(dp[i-1][div] + prices[j] - prices[div]))
			int[][] dp = new int[n][n];
			for(int i = 0; i < n; i++){
				dp[i][0] = 0;
				dp[0][i] = 0;
			}
			for(int i = 1; i <= k; i++){
				int localMax = dp[i-1][0] - prices[0];
				for(int j = 1; j < n; j++){
					dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMax) ;
					localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
					// for(int div = 0; div < j; div++){
					// 	dp[i][j] = Math.max(dp[i][j], dp[i-1][div] + prices[j] - prices[div]);
					// }

				}
			}
			return dp[k][n-1];
		}
}
