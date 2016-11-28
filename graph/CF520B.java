/*
Vasya has found a strange device. On the front panel of a device there are: a red button, a blue button and a display showing some positive integer. After clicking the red button, device multiplies the displayed number by two. After clicking the blue button, device subtracts one from the number on the display. If at some point the number stops being positive, the device breaks down. The display can show arbitrarily large numbers. Initially, the display shows number n.

Bob wants to get number m on the display. What minimum number of clicks he has to make in order to achieve this result?

Input
The first and the only line of the input contains two distinct integers n and m (1 ≤ n, m ≤ 104), separated by a space .

Output
Print a single number — the minimum number of times one needs to push the button required to get the number m out of number n.
*/
import java.util.*;
import java.util.concurrent.*;
import java.util.Scanner;

public class CF520B {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int n, m;
    n = cin.nextInt();
    m = cin.nextInt();
    LinkedBlockingQueue<Integer> numQ = new LinkedBlockingQueue<Integer>();
    LinkedBlockingQueue<Integer> countQ = new LinkedBlockingQueue<Integer>();
    numQ.add(n);
    int step[] = new int[m * 2 + n * 2];
    Arrays.fill(step, -1);
    step[n] = 0;

    while (!numQ.isEmpty()) {
      int res = numQ.remove();
      if (res == m) {
        break;
      } else {
        if (res > 0 && step[res - 1] == -1) {
          numQ.add(res - 1);
          step[res - 1] = step[res] + 1;
        }
        if (res > 0 && res < m && step[res * 2] == -1) {
          numQ.add(res * 2);
          step[res * 2] = step[res] + 1;
        }
      }
    }
    System.out.println(step[m]);
  }
}
