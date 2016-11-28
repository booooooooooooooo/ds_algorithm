import java.util.*;
import java.io.*;

class Poj1118 {
  static double INF = Double.MAX_VALUE;
  static Scanner cin = new Scanner(System.in);

  public static void solve(int number) throws Exception {
    int[][] pts = new int[number][2];
    for (int i = 0; i < number; i++) {
      pts[i][0] = cin.nextInt();
      pts[i][1] = cin.nextInt();
    }

    int maxP = Integer.MIN_VALUE;
    for (int i = 0; i < number; i++) {
      List<Double> slope = new ArrayList<Double>();
      for (int j = 0; j < number; j++) {
        if (i == j)
          continue;
        if (pts[i][0] == pts[j][0]) {
          slope.add(INF);
        } else {
          slope.add(((double) ((pts[i][1] - pts[j][1]))) / (pts[i][0] - pts[j][0]));
        }
      }
      Collections.sort(slope);

      int count = 2;
      for (int k = 0; k < number - 2; k++) {
        if (Math.abs((slope.get(k) - slope.get(k + 1))) < 1e-9) {
          count++;
          continue;
        }
        maxP = count > maxP ? count : maxP;
        count = 2;
      }
      maxP = count > maxP ? count : maxP;
    }
    System.out.println(maxP);
  } // solve()

  public static void main(String args[]) throws Exception {
    // T is # of trials
    while (true) {
      int number = cin.nextInt();
      if (number == 0) {
        break;
      }
      solve(number);
    }

  } // main()
} // class