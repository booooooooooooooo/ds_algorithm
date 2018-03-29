public class Solution {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> indexStack = new Stack<Integer>();

      int[] rightpart = new int[heights.length];//include self
      for(int i = 0; i < heights.length; i++){
        while(!indexStack.isEmpty() && heights[indexStack.peek()] > heights[i]){
          int index = indexStack.pop();
          rightpart[index] = (i - index) * heights[index];
        }
        indexStack.push(i);
      }
      while(!indexStack.isEmpty()){
        int index = indexStack.pop();
        rightpart[index] = (heights.length - index) * heights[index];
      }

      int[] leftpart = new int[heights.length];//exlude self
      for(int i = heights.length - 1; i >= 0; i--){
        while(!indexStack.isEmpty() && heights[indexStack.peek()] > heights[i]){
          int index = indexStack.pop();
          leftpart[index] = (index - 1 - i ) * heights[index];
        }
        indexStack.push(i);
      }
      while(!indexStack.isEmpty()){
        int index = indexStack.pop();
        leftpart[index] = (index - 1 - (-1)) * heights[index];
      }

      int result = 0;
      for(int i = 0; i < heights.length; i++) result = Math.max(result, leftpart[i] + rightpart[i]);
      return result;
    }
}
