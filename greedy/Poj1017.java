import java.util.*;
public class Poj1017 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNext()) {
      int[] order = new int[6];
      boolean stop = true;
      for (int i = 0; i <= 5; i++) {
        order[i] = cin.nextInt();
        if (order[i] != 0) {
          stop = false;
        }
      }
      if (stop)
        break;
      System.out.println(solve(order));
    }
  }

  public static int solve(int[] order) {
    int p6 = order[5];
    int p5 = order[4];
    int p4 = order[3];
    int p3 = order[2] % 4 == 0 ? order[2] / 4
                               : order[2] / 4 + 1; //!!!Pay attention!!!
    int p2;
    int p1;

    int restFor2;
    if (order[2] % 4 == 0) {
      restFor2 = p4 * 5;
    } else if (order[2] % 4 == 1) {
      restFor2 = p4 * 5 + 5;
    } else if (order[2] % 4 == 2) {
      restFor2 = p4 * 5 + 3;
    } else {
      restFor2 = p4 * 5 + 1;
    }

    if (order[1] - restFor2 > 0) {
      p2 = (order[1] - restFor2) % 9 == 0 ? (order[1] - restFor2) / 9
                                          : (order[1] - restFor2) / 9 + 1;
    } else {
      p2 = 0;
    }

    int restFor1 = p6 * 0 + p5 * 11 + p4 * 20 + (p3 * 36 - order[2] * 9) +
                   (p2 * 36 - order[1] * 4);
    if (order[0] - restFor1 > 0) {
      p1 = (order[0] - restFor1) % 36 == 0 ? (order[0] - restFor1) / 36
                                           : (order[0] - restFor1) / 36 + 1;
    } else {
      p1 = 0;
    }
    return p1 + p2 + p3 + p4 + p5 + p6;
  }
}
