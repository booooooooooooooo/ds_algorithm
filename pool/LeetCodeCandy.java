public class Solution {
    public int candy(int[] ratings) {
      int[] candyArr = new int[ratings.length];

      Arrays.fill(candyArr, 1);
      for(int i = 0; i < ratings.length - 1; i++){
        if(ratings[i + 1] > ratings[i]) candyArr[i + 1] = candyArr[i] + 1;
      }
      for(int i = ratings.length - 1; i > 0; i--){
        if(ratings[i - 1] > ratings[i]) candyArr[i - 1] = Math.max(candyArr[i - 1], candyArr[i] + 1);
      }

      int total = 0;
      for(int c : candyArr) total += c;

      return total;
    }

}
