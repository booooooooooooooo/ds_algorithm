import java.util.*;
public class Poj1852{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int loop = cin.nextInt();
    while((loop--) > 0){
      int l = cin.nextInt(), n = cin.nextInt();
      int x[] = new int[n];
      for(int i = 0; i < n; i++){
        x[i] = cin.nextInt();
      }
      int minT = 0, maxT = 0;
      for(int i = 0; i < n; i++){
        minT = Math.max(Math.min(x[i],l - x[i]) , minT);
        maxT = Math.max(Math.max(x[i],l - x[i]) , maxT);
      }
      System.out.printf("%d %d\n", minT, maxT);
    }
  }
}
