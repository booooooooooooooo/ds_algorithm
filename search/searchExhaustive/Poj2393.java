import java.util.*;
import java.math.BigInteger;

public class Poj2393{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int s = cin.nextInt();
    int minC = Integer.MAX_VALUE - s;
    BigInteger totalC = BigInteger.valueOf(0);
    int curC, curY;
    while(n-- > 0){
      curC = cin.nextInt();
      curY = cin.nextInt();
      minC = Math.min(curC, minC + s);
      totalC = totalC.add( BigInteger.valueOf(minC * curY) ) ;
    }
    System.out.println(totalC);

  }
}
