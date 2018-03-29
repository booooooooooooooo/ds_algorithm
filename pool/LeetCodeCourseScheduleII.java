public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      //Make adjaciency list
      List<List<Integer>> adjList= new ArrayList<List<Integer>>();
      for(int i = 0; i < numCourses; i++){
        adjList.add(new ArrayList<Integer>());
      }
      for(int[] edge : prerequisites) adjList.get(edge[1]).add(edge[0]);
      //initialize reverseResult
      List<Integer> reverseResult = new ArrayList<Integer>();
      //initialize unMarked set
      Set<Integer> unMarked = new HashSet<Integer>();
      for(int i = 0; i < numCourses; i++) unMarked.add(i);
      //initialize isTempMarked array
      boolean[] isTempMarked = new boolean[numCourses];
      Arrays.fill(isTempMarked, false);

      //scan. If detecting circle, return empty array.
      while( ! unMarked.isEmpty()){
        int node = -1;
        for(Integer i : unMarked){
          node = i;
          break;
        }
        if( dfs(node, unMarked, isTempMarked, reverseResult, adjList) == false ) return new int[0];
      }

      //No circle if program goes here. revere reverseResult and convert it to int[]
      int[] result = new int[numCourses];
      for(int i = 0; i < numCourses; i++) result[i] = reverseResult.get(numCourses - 1 - i);
      return result;
    }

    public boolean dfs(int node, Set<Integer> unMarked, boolean[] isTempMarked, List<Integer> reverseResult, List<List<Integer>> adjList){
      if(isTempMarked[node] == true) return false;//there is cycle, return false
      else{
        if( ! unMarked.contains(node)) return true;
        else{
          isTempMarked[node] = true;
          List<Integer> endNodes = adjList.get(node);
          for(Integer end : endNodes){
            if(dfs(end, unMarked, isTempMarked, reverseResult, adjList) == false) return false;
          }
          isTempMarked[node] = false;
          unMarked.remove(node);
          reverseResult.add(node);
          return true;
        }
      }
    }
}



public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      //Make adjaciency list
      List<List<Integer>> adjList= new ArrayList<List<Integer>>();
      for(int i = 0; i < numCourses; i++){
        adjList.add(new ArrayList<Integer>());
      }
      for(int[] edge : prerequisites) adjList.get(edge[1]).add(edge[0]);

      //get array of input degree
      int[] inputDegree = new int[numCourses];
      Arrays.fill(inputDegree, 0);
      for(List<Integer> endList : adjList){
        for(Integer end : endList) inputDegree[end]++;
      }

      //initialize queue with zero input degree node
      Queue<Integer> queue = new LinkedList<Integer>();
      for(int i = 0; i < numCourses; i++){
        if(inputDegree[i] == 0) queue.add(i);
      }

      //initialize result[], index
      int[] result = new int[numCourses];
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
      return index == numCourses ? result : new int[0];
    }
}
