public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
      //exclude corner cases
      if(matrix.length == 0) return 0;

      //make graph of increasing edges from matrix. The graph is acyclic by nature.
      List<List<Integer>> adjList  = new ArrayList<List<Integer>>();
      int numRow = matrix.length;
      int numCol = matrix[0].length;
      for(int i = 0; i < numRow * numCol; i++) adjList.add(new ArrayList<Integer>());
      for(int i = 0; i < numRow; i++){
        for(int j = 0; j < numCol; j++){
          int index = i * numCol + j;
          if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) adjList.get(index).add(index - 1);
          if(j + 1 < numCol && matrix[i][j + 1] > matrix[i][j]) adjList.get(index).add(index + 1);
          if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) adjList.get(index).add(index - numCol);
          if( i + 1 < numRow && matrix[i + 1][j] > matrix[i][j]) adjList.get(index).add(index + numCol);
        }
      }

      /**Then Find the longest path of DAG*/
      //initialize dp[]
      int[] dp = new int[adjList.size()];
      Arrays.fill(dp, 1);
      //get tpSort[]
      int[] tpSort = getTpSort(adjList);
      //scan and update dp[]
      for(int start : tpSort){
        List<Integer> endList = adjList.get(start);
        for(Integer end: endList)
          if(dp[end] < dp[start] + 1) dp[end] = dp[start] + 1;
      }
      //return maximun value of dp[]
      int result = 0;
      for(int len : dp) result = result < len ? len : result;
      return result;
    }

    public int[] getTpSort(List<List<Integer>> adjList){
      //get array of input degree
      int[] inputDegree = new int[adjList.size()];
      Arrays.fill(inputDegree, 0);
      for(List<Integer> endList : adjList){
        for(Integer end : endList) inputDegree[end]++;
      }
      //initialize queue with zero input degree node
      Queue<Integer> queue = new LinkedList<Integer>();
      for(int i = 0; i < adjList.size(); i++){
        if(inputDegree[i] == 0) queue.add(i);
      }

      //initialize result[], index
      int[] result = new int[adjList.size()];
      int index = 0;

      //Scan and update result
      while(!queue.isEmpty()){
        int node = queue.remove();
        result[index] = node;
        index++;
        List<Integer> endList = adjList.get(node);
        for(Integer end : endList){
          inputDegree[end]--;
          if(inputDegree[end] == 0) queue.add(end);
        }
      }
      //return result.
      return index == adjList.size() ? result : new int[0];
    }
}
