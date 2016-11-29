import java.util.Arrays;
public class LeetCodePermutationSequence {
    public String getPermutation(int n, int k) {
      int[] arr = new int[n];
      for(int i = 0; i < n; i++)
        arr[i] = i + 1;
      solveGetPermutation(arr, 0, k);

      String res = "";
      for(int i = 0; i < n; i++){
        res = res + arr[i];
      }

      return res;
    }
    public void solveGetPermutation(int[] arr, int tail, int k){
      int quotient = k / getFactorial(arr.length - tail - 1);
      int r = k % getFactorial(arr.length - tail - 1);
      if(r == 0){
        int temp = arr[tail + quotient - 1];
        for(int i = tail + quotient - 1; i > tail; i--){
          arr[i] = arr[i - 1];
        }
        arr[tail] = temp;
        reverse(arr, tail + 1, arr.length);
        return;
      }else{
        int temp = arr[tail + quotient];
        for(int i = tail + quotient; i > tail; i--){
          arr[i] = arr[i - 1];
        }
        arr[tail] = temp;
        solveGetPermutation(arr, tail + 1, r);
      }
    }

    public int getFactorial(int a){
      int factorial = 1;
      for(int i = 1; i <= a; i++){
        factorial *= i;
      }
      return factorial;
    }
    /* [a, b) */
    public void reverse(int[] arr, int a, int b){
      for(int i = a, j = b - 1; i < j; i++, j--){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }


}
