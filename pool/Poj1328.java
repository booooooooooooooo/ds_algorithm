import java.util.*;
public class Poj1328 {

  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    int cas = 0;
    while (cin.hasNext()) {
      int n = cin.nextInt();
      int d = cin.nextInt();
      if (n == 0 && d == 0) {
        break;
      }
      cas++;
      List<Interval> itvList = new ArrayList<Interval>();
      for (int i = 0; i < n; i++) {
        int x = cin.nextInt();
        int y = cin.nextInt();
        Interval interval = makeInterval(x, y, d);
        itvList.add(interval);
      }
      Collections.sort(itvList, new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
          return a.left > b.left ? 1 : -1;
        }
      });
      if (d < 0) {
        System.out.printf("Case %d: %d\n", cas, -1);
      } else {
        System.out.printf("Case %d: %d\n", cas, solve(itvList));
      } //!!!THE TEST CASE IS RIDICULOURS! How could d be negative????????
    }
  }

  static int solve(List<Interval> sortItvList) {
    double boundary = Double.NEGATIVE_INFINITY;
    int curIndex = 0;
    int count = 0;
    while (curIndex < sortItvList.size()) {
      if (sortItvList.get(curIndex).right == Double.NEGATIVE_INFINITY) {
        count = -1;
        break;
      } else if (sortItvList.get(curIndex).right < boundary) {
        boundary = sortItvList.get(curIndex).right;
        curIndex++;
      } else if (sortItvList.get(curIndex).left <= boundary) {
        curIndex++;
      } else {
        boundary = sortItvList.get(curIndex).right;
        curIndex++;
        count++;
      }
    }
    return count;
  }

  static Interval makeInterval(int x, int y, int d) {
    if (d * d - y * y < 0)
      return new Interval(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    else {
      double left = x - Math.sqrt(d * d - y * y);
      double right = x + Math.sqrt(d * d - y * y);
      return new Interval(left, right);
    }
  }
}

class Interval {
  double left;
  double right;
  Interval(double left, double right) {
    this.left = left;
    this.right = right;
  }
}
