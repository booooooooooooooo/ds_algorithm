public class LeetCodeSpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int filler = 1;
        int x = 0;
        int y = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0;

        int leftBound = 0;
        int rightBound = n - 1;
        int upBound = 1;
        int downBound = n - 1;
        while(filler <= n * n){
          matrix[y][x] = filler;
          if(direction == 0 && x == rightBound){
            direction = (direction + 1) % 4;
            rightBound--;
          }else if(direction == 1 && y == downBound){
            direction = (direction + 1) % 4;
            downBound--;
          }else if(direction == 2 && x == leftBound){
            direction = (direction + 1) % 4;
            leftBound++;
          }else if(direction == 3 && y == upBound){
            direction = (direction + 1) % 4;
            upBound++;
          }else{
            ;
          }
          x += dx[direction];
          y += dy[direction];
          filler++;
        }
        return matrix;
    }
}
