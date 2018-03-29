import java.util.*;
public class Poj1862 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    PriorityQueue<Double> heap =
        new PriorityQueue<Double>(10, new Comparator<Double>() {
          @Override
          public int compare(Double a, Double b) {
            return a < b ? 1 : -1;
          }
        });
    for (int i = 0; i < n; i++) {
      heap.add(Double.valueOf(cin.nextInt()));
    }
    while (heap.size() > 1) {
      double a = heap.poll();
      double b = heap.poll();
      double c = 2 * Math.sqrt(a * b);
      heap.add(Double.valueOf(c));
    }
    System.out.printf("%.3f\n", heap.poll());
  }
}
