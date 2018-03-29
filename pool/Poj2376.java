import java.util.*;
import java.io.*;

public class Poj2376_1 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(new BufferedInputStream(System.in));
    while (cin.hasNext()) {
      ArrayList<Interval> cows = new ArrayList<Interval>();

      int lenCows = cin.nextInt();
      int endShift = cin.nextInt();

      for (int i = 0; i < lenCows; i++) {
        int left = cin.nextInt();
        int right = cin.nextInt();
        Interval cow = new Interval(left, right);
        cows.add(cow);
      }
      Collections.sort(cows, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
          return (a.left < b.left || (a.left == b.left && a.right > b.right))
              ? -1
              : 1;
        }
      });
      // for(int i = 0; i < lenCows; i++){
      //   System.out.println(cows.get(i).left + " " + cows.get(i).right);
      // }

      int startTail = 0;
      // Fail case 1: cows.get(startTail).left > 1
      if (cows.get(startTail).left > 1) {
        System.out.println(-1);
        continue;
      }

      int curTail = startTail;
      int numCow = 1;
      int reach = cows.get(curTail).right;
      // Construct the chain of intervals.
      // First, If reaching the end of ArrayList, ends construction.
      while (curTail < lenCows - 1) {
        // Second, If current interval hits endShift, end construction.
        if (cows.get(curTail).right >= endShift) {
          break;
        }
        int nextTail = curTail;
        for (int i = curTail; i < lenCows; i++) {
          if (cows.get(i).left <= cows.get(curTail).right + 1) {
            if (cows.get(i).right > reach) {
              nextTail = i;
              reach = cows.get(i).right;
            }
            if (reach >= endShift) {
              break;
            }
          } else {
            break;
          }
        }
        // Third, If cannot find next interval, end construction.
        if (nextTail == curTail) {
          break;
        }
        curTail = nextTail;
        numCow++;
      }

      // Fail case 2: The right boundary of Chain does not hit endShift.
      if (cows.get(curTail).right < endShift) {
        System.out.println(-1);
        continue;
      } else {
        System.out.println(numCow);
        continue;
      }
    }
  }
  public static class Interval {
    public final int left;
    public final int right;
    public Interval(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
}
