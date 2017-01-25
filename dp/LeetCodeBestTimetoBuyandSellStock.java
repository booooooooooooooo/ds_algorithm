public class Solution {
    public int maxProfit(int[] prices) {
      int[] minBuyPriceArr = new int[prices.length];
      int minBuyPrice = Integer.MAX_VALUE;
      for(int i = 0; i < prices.length; i++){
        minBuyPrice = Math.min(minBuyPrice, prices[i]);
        minBuyPriceArr[i] = minBuyPrice;
      }

      int[] profitArr = new int[prices.length];
      for(int i = 0; i < prices.length; i++){
        profitArr[i] = prices[i] - minBuyPriceArr[i];
      }

      int result = 0;
      for(int i = 0; i < prices.length; i++){
        result = Math.max(result, profitArr[i]);
      }

      return result;
    }
}
