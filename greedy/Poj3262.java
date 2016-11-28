import java.util.*;
import java.math.BigInteger;
public class Poj3262 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int totalD = 0;
    BigInteger flower = BigInteger.valueOf(0);
    PriorityQueue<Cow> heap = new PriorityQueue<Cow>(10, new Comparator<Cow>() {
      @Override
      public int compare(Cow a, Cow b) {
        return a.t * b.d > b.t * a.d ? 1 : -1;
      }
    });
    for (int i = 0; i < n; i++) {
      int t = cin.nextInt();
      int d = cin.nextInt();
      heap.add(new Cow(t, d));
      totalD += d;
    }
    while (heap.size() != 0) {
      Cow curCow = heap.poll();
      totalD -= curCow.d;
      flower = flower.add(BigInteger.valueOf(totalD * 2 * curCow.t));
    }
    System.out.println(flower);
  }
}

class Cow {
  int t, d;
  Cow(int t, int d) {
    this.t = t;
    this.d = d;
  }
}
