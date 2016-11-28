public class DP_MaxSumOfSubArray{
  public static void main(String args[]){
    int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
    System.out.println( maxSumOfAllSubArrays(arr) );
  }

  public static int maxSumOfAllSubArrays(int[] arr){
    /* Get dp array */
    int n = arr.length;
    int[] dp = new int[n + 1];
    dp[n] = -1;//dummy
    for(int i = n - 1; i >= 0; i--){
      if(dp[i + 1] >= 0) dp[i] = dp[i + 1] + arr[i];
      else dp[i] = arr[i];
    }
    /* Get result */
    int maxSum = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
      maxSum = Math.max(maxSum, dp[i]);
    }
    return maxSum;
  }
}
