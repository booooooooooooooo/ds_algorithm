public class Solution {
    public int maxProfit(int[] prices) {
      //exclude corner cases
      if(prices.length == 0) return 0;

      int n = prices.length;
      //get prevMinPrice and postMaxPrice
      int[] prevMinPrice = new int[n];
      for(int i = 0; i < n; i++){
        if(i == 0) prevMinPrice[i] = prices[i];
        else prevMinPrice[i] = Math.min(prevMinPrice[i - 1], prices[i]);
      }
      int[] postMaxPrice = new int[n];
      for(int i = n - 1; i >= 0; i--){
        if(i == n - 1) postMaxPrice[n - 1] = prices[n - 1];
        else postMaxPrice[i] = Math.max(postMaxPrice[i + 1], prices[i]);
      }
      //get maxProfitSoldHere and maxProfitBoughtHere
      int[] maxProfitSoldHere = new int[n];
      for(int i = 0; i < n; i ++)
        maxProfitSoldHere[i] = prices[i] - prevMinPrice[i];
      int[] maxProfitBoughtHere = new int[n];
      for(int i = 0; i < n; i++)
        maxProfitBoughtHere[i] = postMaxPrice[i] - prices[i];
      //get prevMaxProfit and postMaxProfit
      int[] prevMaxProfit = new int[n];
      for(int i = 0; i < n; i++){
        if(i == 0)
          prevMaxProfit[0] = maxProfitSoldHere[0];
        else
          prevMaxProfit[i] = Math.max(prevMaxProfit[i - 1], maxProfitSoldHere[i]);
      }
      int[] postMaxProfit = new int[n];
      for(int i = n - 1; i >= 0; i--){
        if(i == n - 1) postMaxProfit[n - 1] = maxProfitBoughtHere[n - 1];
        else
          postMaxProfit[i] = Math.max(postMaxProfit[i + 1], maxProfitBoughtHere[i]);
      }
      //update  result

      int result = 0;
      for(int i = 0; i < n - 1; i++){
        result = Math.max(result, prevMaxProfit[i] + postMaxProfit[i + 1]);//two transactions
      }
      result = Math.max(result, prevMaxProfit[n - 1]);//one transactions
      //return result
      return result;
    }
}

/**
As many transactions as you want. NOT this problem asks about.
*/
public class Solution {
    public int maxProfit(int[] prices) {
      int n = prices.length;
      int result = 0;
      for(int i = 1; i < n; i++){
        if(prices[i] > prices[i - 1])
          result += prices[i] - prices[i - 1];
      }
      return result;
    }
}
