import java.util.*;
public class Poj3190 {
  public static void main(String args[]) {
    Scanner cin = new Scanner(System.in);
    List<Interval> itvList = new ArrayList<Interval>();
    int n = cin.nextInt();
    for (int i = 0; i < n; i++) {
      int left = cin.nextInt();
      int right = cin.nextInt();
      int inputOrder = i;
      itvList.add(new Interval(left, right, inputOrder));
    }

    solve(itvList);
  }

  static void solve(List<Interval> itvList) {
    PriorityQueue<Stall> stallHeap =
        new PriorityQueue<Stall>(10, new Comparator<Stall>() {
          @Override
          public int compare(Stall a, Stall b) {
            return a.boundary > b.boundary ? 1 : -1;
          }
        });
    int curIndex = 0;
    int count = 0;
    int number = 0;

    Collections.sort(itvList, new Comparator<Interval>() {
      @Override
      public int compare(Interval a, Interval b) {
        return a.left > b.left ? 1 : -1;
      }
    });
    while (curIndex < itvList.size()) {
      // System.out.println(stallHeap.peek());
      if (stallHeap.size() == 0 ||
          stallHeap.peek().boundary >= itvList.get(curIndex).left) {
        number++;
        Stall tmp = new Stall(itvList.get(curIndex), number);
        itvList.get(curIndex).stallNumber = tmp.number;
        stallHeap.add(tmp);
        curIndex++;
        count++;
      } else {
        Stall tmp = stallHeap.poll();
        tmp.add(itvList.get(curIndex));
        stallHeap.add(tmp);
        itvList.get(curIndex).stallNumber = tmp.number;
        curIndex++;
      }
    }
    Collections.sort(itvList, new Comparator<Interval>() {
      @Override
      public int compare(Interval a, Interval b) {
        return a.inputOrder > b.inputOrder ? 1 : -1;
      }
    });
    System.out.println(count);
    for (int i = 0; i < itvList.size(); i++) {
      System.out.println(itvList.get(i).stallNumber);
    }
  }
}

class Stall {
  List<Interval> itvListInStall;
  int boundary;
  int number;
  Stall(Interval firstItv, int number) {
    itvListInStall = new ArrayList<Interval>();
    itvListInStall.add(firstItv);
    boundary = firstItv.right;
    this.number = number;
  }
  public void add(Interval newItv) {
    if (newItv.left > boundary) {
      itvListInStall.add(newItv);
      boundary = newItv.right;
    } else {
      System.out.println(
          "Left of new interval is less than the boundary of stall!");
    }
  }
  @Override
  public String toString() {
    String result = "=======Stall ";
    result = result.concat(number + "\n");
    for (int i = 0; i < itvListInStall.size(); i++) {
      result = result.concat(itvListInStall.get(i).toString());
    }
    return result;
  }
}

class Interval {
  int left;
  int right;
  int inputOrder;
  int stallNumber;
  Interval(int left, int right, int inputOrder) {
    this.left = left;
    this.right = right;
    this.inputOrder = inputOrder;
  }
  @Override
  public String toString() {
    return "left " + String.valueOf(left) + ", right " + String.valueOf(right);
  }
}
