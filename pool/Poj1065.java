import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int t = cin.nextInt();
    while(t-- > 0){
      int n = cin.nextInt();
      List<Stick> sticks = new ArrayList<Stick>();
      for(int i = 0; i < n; i++) sticks.add(new Stick(cin.nextInt(), cin.nextInt()));
      System.out.println(solve(sticks));
    }
  }
  private static int solve(List<Stick> sticks){
    //sort by l
    Collections.sort(sticks, new Comparator<Stick>(){
      @Override
      public int compare(Stick s1, Stick s2){
        if(s1.l != s2.l) return s1.l - s2.l;
        else return s1.w - s2.w;
      }
    });
    //find LDS by w
    int[] dp = new int[sticks.size()];
    int next = 0;//next position to use
    for(int i = 0; i < sticks.size(); i++){
      int w = sticks.get(i).w;
      int index = lowerBoundOfDecending(dp, 0, next, w);
      dp[index] = w;
      if(index == next) next++;
    }
    return next;

  }
  private static int lowerBoundOfDecending(int[] arr, int start, int end, int target){
    while(start < end){
      int mid = start + (end - start) / 2;
      if(arr[mid] > target){
        start = mid + 1;
      }else{
        end = mid;
      }
    }
    return start;
  }
}

class Stick{
  public int l;
  public int w;
  public Stick(int l, int w){
    this.l = l;
    this.w = w;
  }
}
