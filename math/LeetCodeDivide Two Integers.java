public class Solution {
    public int divide(int dividend, int divisor) {
      //exclude meaningless case
      if(divisor == 0) return Integer.MAX_VALUE;

      //get sign of result
      boolean isPositive = true;
      if((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0))
        isPositive = false;

      //get absolute long result
      long result = dividePositiveLong( Math.abs((long) dividend), Math.abs( (long)divisor));

      //get real result and return
      if(isPositive){
        if(result > Integer.MAX_VALUE)
          return Integer.MAX_VALUE;
        else
          return (int)result;
      }else{
        if(result - 1 > Integer.MAX_VALUE)
          return Integer.MAX_VALUE;
        else if(result - 1 == Integer.MAX_VALUE)
          return (int)result;
        else
          return (int)(0 - result);
      }

    }

    public long dividePositiveLong(long dividend, long divisor){
      if(divisor > dividend) return 0;

      long count = 0;
      while(divisor <= dividend){
        divisor = divisor << 1;
        count++;
      }
      divisor = divisor >> 1;
      count--;

      long result = 0;
      while(count >= 0){
        result = divisor <= dividend ? (result << 1) + 1 : (result << 1) + 0;
        dividend = divisor <= dividend ? dividend - divisor : dividend;
        divisor = divisor >> 1;
        count--;
      }

      return result;

    }

}
