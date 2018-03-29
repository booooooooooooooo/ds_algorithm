/**
The actual implementation is similar to the BFS topological sort.
Remove the leaves, update the degrees of inner vertexes.
Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left.
What's left is our answer!
This comment is copied from https://discuss.leetcode.com/topic/30572/share-some-thoughts
*/

//TODO: rewrite without queue. Just as https://discuss.leetcode.com/topic/30572/share-some-thoughts/2 explains
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      //exclude corner cases
      if(n == 0) return new ArrayList<Integer>();
      if(n == 1){
        List<Integer> cornerResult = new ArrayList<Integer>();
        cornerResult.add(0);
        return cornerResult;
      }
      //Make adjaciency list of undirected graph
      List<List<Integer>> adjList = new ArrayList<List<Integer>>();
      for(int i = 0; i < n; i++){
        adjList.add(new ArrayList<Integer>());
      }
      for(int i = 0; i < edges.length; i++){
        adjList.get(edges[i][0]).add(edges[i][1]);
        adjList.get(edges[i][1]).add(edges[i][0]);
      }
      //Initialize array of degree
      int[] degreeArr = new int[adjList.size()];
      Arrays.fill(degreeArr, 0);
      for(List<Integer> neighbourList : adjList)
        for(Integer neighbour : neighbourList) degreeArr[neighbour]++;


      //Initialize queue.
      Queue<Integer> nodeQueue = new LinkedList<Integer>();
      Queue<Integer> heightQueue = new LinkedList<Integer>();
      for(int i = 0; i < degreeArr.length; i++)
        if(degreeArr[i] == 1){
           nodeQueue.add(i);
           heightQueue.add(0);
        }


      //Scan.
      for(int i = 0; i <= n - 3; i++){
        int node = nodeQueue.remove();
        int height = heightQueue.remove();
        List<Integer> neighbourList = adjList.get(node);
        for(Integer neighbour : neighbourList){
          if(degreeArr[neighbour] != 1){
            degreeArr[neighbour]--;
            if(degreeArr[neighbour] == 1){
              nodeQueue.add(neighbour);
              heightQueue.add(height + 1);
            }
          }
        }
      }

      //Process last two nodes and get result
      int n1 = nodeQueue.remove();
      int h1 = heightQueue.remove();
      int n2 = nodeQueue.remove();
      int h2 = heightQueue.remove();
      List<Integer> result = new ArrayList<Integer>();
      result.add(n2);
      if(h2 == h1) result.add(n1);
      return result;
    }
}
