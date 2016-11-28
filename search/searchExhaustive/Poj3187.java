import java.util.*;

public class Poj3187{
  static int[] output;
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int sum = cin.nextInt();

    boolean[] used = new boolean[n];
    Arrays.fill(used, false);

    int[] perm = new int[n];
    Arrays.fill(perm, 555);

    int[] factor = new int[n];
    for(int i = 0; i <= n/2; i++){
      factor[i] = factor[n - 1 - i] = c(n - 1, i);
    }

    output = new int[n];
    Arrays.fill(output, n);

    permutation(0, sum, n, used, perm, factor);
    
    for(int i = 0; i < n; i++){
      if(i != n - 1){
        System.out.printf("%d ", output[i]);
      }else{
        System.out.printf("%d\n", output[i]);
      }

    }

  }

  static void permutation(int m, int sum, int n, boolean[] used, int[] perm, int[] factor){
    if(m == n){
      int result = 0;
      for(int i = 0; i < n; i++){
        result += factor[i] * perm[i];
      }
      if(result == sum && arrCmp(output, perm)){
        for(int i = 0; i < n; i++){
          output[i] = perm[i];
        }
      }
    }else{
      for(int i = 0; i < n; i++){
        if(!used[i]){
          perm[m] = i + 1;
          used[i] = true;
          permutation(m + 1, sum, n, used, perm, factor);
          used[i] = false;
        }
      }
    }
  }

  static int c(int n, int k){
    int combination = 1;
    for(int i = n;i > n - k; i--){
      combination = combination * i;
    }
    for(int i = 1; i <= k; i++){
      combination = combination / i;
    }
    return combination;
  }

  static boolean arrCmp(int[] arr1, int[] arr2){
    for(int i = 0; i < arr1.length; i++){
      if(arr1[i] == arr2[i]) continue;
      else if(arr1[i] > arr2[i]) return true;
      else return false;
    }
    return false;
  }
}
