import java.util.*;
public class Poj2718{
  static int minSub;

  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    int loop = Integer.parseInt( cin.nextLine() );
    while(loop-- > 0){
      String line = cin.nextLine();
      String[] arrStr = line.split(" ");
      int n = arrStr.length;
      int[] arr = new int[n];
      for(int i = 0; i < n; i++){
        // System.out.println(arrStr[i]);
        arr[i] = Integer.parseInt(arrStr[i]);
      }
      boolean[] used = new boolean[n];  Arrays.fill(used, false);
      int[] perm = new int[n];
      minSub = 10000000;
      permutation(0, n, arr, perm, used);
      System.out.println(minSub);
    }

  }

  static void permutation(int pos, int n, int[] arr, int[] perm, boolean[] used){
    if(pos == n){
      if(n == 2) minSub = Math.abs(arr[0] - arr[1]);//Keng keng keng keng
      else if(arr[perm[0]] == 0 || arr[perm[n/2]] == 0) return;
      else{
        int left = toDecimal(0, n/2, perm, arr);
        int right = toDecimal(n/2, n, perm, arr);
        minSub = Math.min(minSub, Math.abs(left - right));
        // System.out.println(minSub);

      }
    }else{
      for(int i = 0; i < n; i++ ){
        if(!used[i]){
          perm[pos] = i;
          used[i] = true;
          permutation(pos + 1, n, arr, perm, used);
          used[i] = false;
        }
      }
    }
  }

  static int toDecimal(int start, int end, int[] perm, int[] arr){
    int dec = 0;
    for(int i = start; i < end; i++){
      dec = dec * 10 + arr[perm[i]];
    }
    return dec;
  }
}
