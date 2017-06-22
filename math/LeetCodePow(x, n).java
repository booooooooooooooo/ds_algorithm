public class Solution {
    public double myPow(double x, int n) {
      if(n < 0) return 1.0 / solve(x, -n);
      else return solve(x, n);
    }

    public double solve(double x, int n){
      if(n == 0) return 1;
      else{
        double part = solve(x, n / 2);
        if(n % 2 == 0) return part * part;
        else return part * part * x;
      }
    }
}
