import java.math.BigInteger;
public class LeetCodeUniquePaths {


    public int uniquePaths(int m, int n) {
      BigInteger count = BigInteger.valueOf(1);;
      for(int i = n - 1 + 1; i <= n - 1 + m - 1; i++ ) count = count.multiply(BigInteger.valueOf(i));
      // System.out.println(count);
      for(int i = 1; i <= m - 1; i++) count = count.divide(BigInteger.valueOf(i));
      // System.out.println(count);
      return Integer.parseInt( count.toString() );
    }

}
