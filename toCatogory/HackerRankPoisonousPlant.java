import java.util.*;
public class HackerRankPoisonousPlant {
  public static void main(String args[]) {
    int maxDays = 0;
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    Stack<Integer> stack = new Stack<Integer>();
    int last = Integer.MAX_VALUE;
    int days = 0;
    for (int i = 0; i < n; i++) {
      int cur = cin.nextInt();
      if (stack.empty()) {
        stack.push(cur);
      } else if (cur > last) {
        days = 1;
      } else if (cur <= last && cur > stack.peek()) {
        days++;
      } else { // cur <= last && cur <= stack.peek()
        days = 0;
        stack.push(cur);
      }
      maxDays = Math.max(maxDays, days);
      last = cur;
    }
    System.out.println(maxDays);
  }
}
