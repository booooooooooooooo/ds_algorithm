import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNextInt()){
      int N = cin.nextInt();
      int C = cin.nextInt();
      int[] stalls = new int[N];
      for(int i = 0; i < stalls.length; i++){
        stalls[i] = cin.nextInt();
      }
      //exclude corner cases None

      System.out.println(solve(C, stalls));
    }

  }
  public static int solve(int C, int[] stalls){
    int n = stalls.length;
    Arrays.sort(stalls);
    //[first, end) covers all possible solutions
    int end = stalls[n - 1] - stalls[0] + 1;
    int first = 0;
    //Get upperBound of solution
    while(first < end){
      int mid = first + (end - first) / 2;
      if(isValid(mid, C, stalls)) first = mid + 1;
      else end = mid;
    }
    return first - 1;
  }

  public static boolean isValid(int d, int C, int[] stalls){
    int count = 1;
    int index = 0;
    int i = 1;
    while(i < stalls.length){
      if(stalls[i] - stalls[index] >= d){
        count++;
        index = i;
      }
      i++;
    }
    if(count >= C) return true;
    else return false;
  }
}
