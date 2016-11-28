import java.util.Arrays;

public class Mergesort {

    public static int[] mergesort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        // Sort left half.
        int[] leftHalf = mergesort(Arrays.copyOfRange(array, 0, array.length / 2));

        // Sort right half.
        int[] rightHalf = mergesort(Arrays.copyOfRange(array, array.length / 2, array.length));

        // Merge the sorted halves.
        return merge(leftHalf, rightHalf);
    }


    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[leftHalf.length + rightHalf.length];


        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {// Keep stable
                mergedArray[k] = leftHalf[i];
                i++;
            } else {
                mergedArray[k] = rightHalf[j];
                j++;
            }

            k++;
        }

        // copy rest
        for (; i < leftHalf.length; i++, k++) {
            mergedArray[k] = leftHalf[i];
        }
        for (; j < rightHalf.length; j++, k++) {
            mergedArray[k] = rightHalf[j];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = s.nextInt();

      int[] result = mergesort(arr);

      for (int i = 0; i < n; i++) System.out.printf("%d ",result[i]);
      System.out.println();
    }
}
