import java.util.Arrays;
public class Hanoi {
  public static void main(String args[]) {
    int[] origin= {1, 2, 3, 4, 5};
    int[] buffer = new int[5];
    int[] destination = new int[5];
    solve(5, origin, buffer, destination);
    System.out.println(Arrays.toString(origin));
    System.out.println(Arrays.toString(destination));
  }

  public static void solve(int len, int[] origin, int[] buffer, int[] destination){
    if(len == 0) return;
    solve(len - 1, origin, destination, buffer);
    destination[len - 1] = origin[len - 1];
    solve(len - 1, buffer, origin, destination);
  }
}
//Q: why after moving origin is still [1,2,3,4,5]
