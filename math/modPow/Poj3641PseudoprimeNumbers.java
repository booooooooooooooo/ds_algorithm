import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      long p = cin.nextLong();
      long a = cin.nextLong();
      if(p == 0 && a == 0) return;
      System.out.println(solve(p, a));
    }
  }
  public static String solve(long p, long a){
    if(!isPrime(p) && modPow(a, p, p) == a % p) return "yes";
    else return "no";
  }
  public static boolean isPrime(long x){
    for(long i = 2; i * i <= x; i++)
      if(x % i == 0) return false;
    return true;
  }
  public static long modPow(long x, long n, long mod){
    long result = 1;
    while( n > 0){
      if((n & 1) == 1) result = modMulti(result, x, mod);
      x = modMulti(x, x, mod);
      n = n >> 1;
    }
    return result;
  }
  public static long modMulti(long a, long b, long mod){
    return (a % mod) * (b % mod) % mod;
  }
}
