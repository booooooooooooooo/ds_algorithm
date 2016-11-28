import java.util.*;
import java.io.*;

class Poj1207 {
  static Scanner cin = new Scanner(System.in);

  public static int solve(int number) throws Exception {
    int cycle = 1;

    while (number > 1) {
      if (number % 2 == 0) {
        number = number / 2;
      } else {
        number = 3 * number + 1;
      }
      cycle++;
    }
    return cycle;
  }

  public static void main(String args[]) throws Exception {
    // T is # of trials
    while (cin.hasNextInt()) {
      int a = cin.nextInt();
      int b = cin.nextInt();
      int left = a < b ? a : b;
      int right = a < b ? b : a;
      int maxCycle = Integer.MIN_VALUE;
      int number;
      for (number = left; number <= right; number++) {
        int curCycle = solve(number);
        maxCycle = maxCycle > curCycle ? maxCycle : curCycle;
      }
      System.out.printf("%d %d %d\n", a, b, maxCycle);
    }

  } // main()
} // class