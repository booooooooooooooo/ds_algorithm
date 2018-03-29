/**
DFS
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      //make a adjacency list
      List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
      for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<Integer>());
      for(int i = 0; i < prerequisites.length; i++){
        int start = prerequisites[i][0];
        int end = prerequisites[i][1];
        adjacency.get(start).add(end);
      }
      //initialize marked and isTmpMarked
      Set<Integer> unMarked = new HashSet<Integer>();
      for(int i = 0; i < numCourses; i++) unMarked.add(i);
      boolean[] isTmpMarked = new boolean[numCourses];
      Arrays.fill(isTmpMarked, false);
      //Scan
      while( !unMarked.isEmpty()){
        int node = -1;
        for(Integer i : unMarked){
          node = i;
          break;
        }
        boolean isADG = visit(node, unMarked, isTmpMarked, adjacency);
        if( !isADG ) return false;
      }
      return true;
    }

    public boolean visit(int node, Set<Integer> unMarked, boolean[] isTmpMarked, List<List<Integer>> adjacency ){
      if(isTmpMarked[node]) return false;
      if(unMarked.contains(node)){
        isTmpMarked[node] = true;
        List<Integer> nextNodes = adjacency.get(node);
        for(Integer next : nextNodes){
          if(visit(next, unMarked, isTmpMarked, adjacency) == false) return false;
        }
        unMarked.remove(node);
        isTmpMarked[node] = false;
      }
      return true;
    }
}

/**
Kahn's algorithm
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      //make a adjacency list
      List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
      for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<Integer>());
      for(int i = 0; i < prerequisites.length; i++){
        int start = prerequisites[i][0];
        int end = prerequisites[i][1];
        adjacency.get(start).add(end);
      }
      //initialize a inputDegreeArr[]
      int inputDegreeArr[] = new int[numCourses];
      Arrays.fill(inputDegreeArr, 0);
      for(int i = 0; i < prerequisites.length; i++){
        int end = prerequisites[i][1];
        inputDegreeArr[end]++;
      }

      // initialize queue to process graph
      Queue<Integer> queue = new LinkedList<Integer>();
      for(int i = 0; i < numCourses; i++){
        if(inputDegreeArr[i] == 0) queue.add(i);
      }

      //Scan while queue is not empty
      while(! queue.isEmpty()){
        int startNode = queue.remove();
        List<Integer> endNodes = adjacency.get(startNode);
        for(int i = 0; i < endNodes.size(); i++){
          int endNode = endNodes.get(i);
          inputDegreeArr[endNode]--;
          if(inputDegreeArr[endNode] == 0) queue.add(endNode);
        }

      }

      //If all nodes has zero input degree, return true; otherwise, return false.
      for(int i = 0; i < numCourses; i++){
        if(inputDegreeArr[i] != 0) return false;
      }
      return true;

    }
}
