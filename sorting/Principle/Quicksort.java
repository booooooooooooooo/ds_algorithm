import java.util.*;


public class Quicksort {
 static int[] arr;
 static Random rnd = new Random();

 static void swap(int a, int b) {
   int temp = arr[a]; arr[a] = arr[b]; arr[b] = temp;
 }

 static int partition(int start, int end) {
   swap(start, start + rnd.nextInt(end - start));
   int div = arr[start];
   int pivot = start;
   for(int i = start + 1; i < end; i++){
     if(arr[i] < div ){
       swap(i, pivot);
       pivot++;
     }
   }
   return pivot; // start of bigger interval
 }

 static void quicksort(int start, int end) {
   if (start >= end - 1) return;
   else{
     int pivot = partition(start, end);
     quicksort(start, pivot);
     quicksort(pivot, end);
   }
 }

 public static void main(String[] args) {
   Scanner s = new Scanner(System.in);
   int n = s.nextInt();
   arr = new int[n];
   for (int i = 0; i < n; i++) arr[i] = s.nextInt();

   quicksort(0, n);

   for (int i = 0; i < n; i++) System.out.printf("%d ",arr[i]);
   System.out.println();
 }
}
