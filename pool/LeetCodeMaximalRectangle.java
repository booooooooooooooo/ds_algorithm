public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0)
      return 0;

    if (matrix.length != 0 && matrix[0].length == 0)
      return 0;

    int m = matrix.length;
    int n = matrix[0].length;
    // get barMatrix
    int[][] barMatrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0)
          barMatrix[0][j] = matrix[i][j] == '1' ? 1 : 0;
        else
          barMatrix[i][j] = matrix[i][j] == '1' ? 1 + barMatrix[i - 1][j] : 0;
      }
    }
    // get result
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      int maxArea = rowMaxRectangle(barMatrix[i]);
      result = Math.max(result, maxArea);
    }
    // return result
    return result;
  }

  public int rowMaxRectangle(int[] heightArr) {
    int n = heightArr.length;

    Stack<Integer> minIndexStack;

    // Scan from left to right
    int[] leftIndexArr = new int[n];
    minIndexStack = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        leftIndexArr[0] = 0;
        minIndexStack.push(0);
      } else {
        int leftIndex = 0; // caution!
        while (!minIndexStack.isEmpty()) {
          if (heightArr[minIndexStack.peek()] >= heightArr[i]) {
            minIndexStack.pop();
          } else {
            leftIndex = minIndexStack.peek() + 1;
            break;
          }
        }
        leftIndexArr[i] = leftIndex;
        minIndexStack.push(i);
      }
    }
    // Scan from right to left
    int[] rightIndexArr = new int[n];
    minIndexStack = new Stack<Integer>();
    for (int i = n - 1; i >= 0; i--) {

      if (i == n - 1) {
        rightIndexArr[n - 1] = n - 1;
        minIndexStack.push(n - 1);
      } else {
        int rightIndex = n - 1; // caution!
        while (!minIndexStack.isEmpty()) {
          if (heightArr[minIndexStack.peek()] >= heightArr[i]) {
            minIndexStack.pop();
          } else {
            rightIndex = minIndexStack.peek() - 1;
            break;
          }
        }
        rightIndexArr[i] = rightIndex;
        minIndexStack.push(i);
      }
    }

    // get maxArea
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int tempArea = (rightIndexArr[i] - leftIndexArr[i] + 1) * heightArr[i];
      maxArea = Math.max(maxArea, tempArea);
    }
    // return result
    return maxArea;
  }
}
