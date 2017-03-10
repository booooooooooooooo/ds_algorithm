public class Solution {
    public int findMinMoves(int[] machines) {
      //exclude corner case
      if(machines.length == 0) return 0;

      //sum[], avg, is there sulution?
      int n = machines.length;
      int[] sum = new int[n];
      for(int i = 0; i < n; i++){
        if(i == 0) sum[i] = machines[i];
        else sum[i] = sum[i-1] + machines[i];
      }
      if(sum[n-1] % n != 0) return -1;
      int avg = sum[n-1] / n;

      //well...
      int result = 0;
      for(int i = 0; i < n; i++){
        int l = i == 0 ? 0 : avg * i - sum[i - 1];
        int r = i == n - 1 ? 0 : avg * (n - 1 - i) - (sum[n - 1] - sum[i]);
        if(l > 0 && r > 0) result = result < l + r ? l + r : result;
        else result = result < Math.max(Math.abs(l), Math.abs(r)) ? Math.max(Math.abs(l), Math.abs(r)) : result;
      }
      return result;
    }
}
