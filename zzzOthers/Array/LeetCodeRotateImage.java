public class LeetCodeRotateImage {
    public void rotate(int[][] matrix) {
        int low_i = 0;
        int high_i = matrix.length - 2;
        int j = 0;

        while(low_i <= high_i){
          for(int i = low_i; i <= high_i; i++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[matrix.length - 1 - j][i];
            matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
            matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
            matrix[j][matrix.length - 1 - i] = temp;
          }
          low_i++;
          high_i--;
          j++;
        }
    }
}
