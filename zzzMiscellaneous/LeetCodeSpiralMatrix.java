import java.util.*;
public class LeetCodeSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<Integer>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int direction = 0;
        int row_lowBound = 1;
        int row_highBound = matrix.length - 1;
        int col_lowBound = 0;
        int col_highBound = matrix.length == 0 ? 0 : matrix[0].length -1;
        int i = 0;
        int j = 0;

        int count = matrix.length == 0 ? 0 : matrix.length * matrix[0].length;
        while(count > 0){
          result.add(Integer.valueOf(matrix[i][j]));
          if(direction == 0 && j == col_highBound){
            direction = 1;
            col_highBound--;
          }
          if(direction == 1 && i == row_highBound){
            direction = 2;
            row_highBound--;
          }
          if(direction == 2 && j == col_lowBound){
            direction = 3;
            col_lowBound++;
          }
          if(direction == 3 && i == row_lowBound){
            direction = 0;
            row_lowBound++;
          }
          i += dx[direction];
          j += dy[direction];
          count--;
        }
        return result;
    }
}
