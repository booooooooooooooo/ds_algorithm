public class Solution {
    public void setZeroes(int[][] matrix) {
      int x = -1;
      int y = -1;
      for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
          if(matrix[i][j] == 0){
            x = i;
            y = j;
            break;
          }
        }
      }

      if(x == -1 && y == -1) return;

      for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
          if(matrix[i][j] == 0){
            matrix[x][j] = 0;
            matrix[i][y] = 0;
          }
        }
      }
      for(int i = 0; i < matrix.length; i++){
        if(matrix[i][y] == 0 && i != x){
          for(int k = 0; k < matrix[0].length; k++) matrix[i][k] = 0;
        }
      }
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[x][j] == 0 && y != j){
          for(int m = 0; m < matrix.length; m++) matrix[m][j] = 0;
        }
      }
      for(int i = 0; i < matrix.length; i++) matrix[i][y] = 0;
      for(int j = 0; j < matrix[0].length; j++) matrix[x][j] = 0;

    }
}
