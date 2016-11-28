/**
Everything In place
heap is min heap.
Arr is sorted in decending order.
*/
import java.util.*;

public class HeapSort {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = s.nextInt();

    heapsort(arr);

    for (int i = 0; i < n; i++) System.out.printf("%d ",arr[i]);
    System.out.println();
  }

  public static void heapsort(int[] arr) {
  	//Build heap in bottom-up way and in place.
    for(int i = arr.length - 1; i >= 0; i--) reHeap(arr, arr.length - 1, i);

    //Build sorted array using heap in place.
    int tail = arr.length - 1;
    while(tail > 0){
      int temp = arr[0];
      arr[0] = arr[tail];
      arr[tail] = temp;
      reHeap(arr, tail - 1,  0);
      tail--;
    }
  }

  public static void reHeap(int[] arr, int maxIndex, int i){
    int j = i;
    if(2 * i + 1 <= maxIndex && arr[2 * i + 1] < arr[j]) j = 2 * i + 1;
    if(2 * i + 2 <= maxIndex && arr[2 * i + 2] < arr[j]) j = 2 * i + 2;

    if(i != j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      reHeap(arr, maxIndex,j);
    }
  }


}
