import java.util.*;
public class HackerRankLargestRectangle {
  public static void main(String args[]) {
    int maxArea = -1;
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    Stack<Tuple> stack = new Stack<Tuple>();
    for (int i = 0; i <= n; i++) {
      int value =
          (i == n) ? 0 : cin.nextInt(); // add a dummy 0 to pop all real values
      int index = i;
      Tuple elem = new Tuple(index, value);
      while (!stack.empty() && stack.peek().value > elem.value) {
        Tuple out = stack.pop();
        int area = stack.empty()
                       ? out.value * (elem.index - (-1) - 1)
                       : out.value * (elem.index - stack.peek().index - 1);
        maxArea = Math.max(area, maxArea);
      }
      stack.push(elem);
    }
    System.out.println(maxArea);
  }
}

class Tuple {
  int index;
  int value;
  public Tuple(int index, int value) {
    this.index = index;
    this.value = value;
  }
}
