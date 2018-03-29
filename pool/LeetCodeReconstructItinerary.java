public class Solution {
    public List<String> findItinerary(String[][] tickets) {
      LinkedList<String> eulerPath = new LinkedList<String>();
      HashMap<String, PriorityQueue<String>> directedGraph = new HashMap<String, PriorityQueue<String>>();
      for(String[] t : tickets){
        directedGraph.putIfAbsent(t[0], new PriorityQueue<String>());
        directedGraph.get(t[0]).add(t[1]);
      }
      dfs(directedGraph, "JFK", eulerPath);
      return eulerPath;
    }
    public void dfs(HashMap<String, PriorityQueue<String>> directedGraph, String depart, LinkedList<String> eulerPath){
      PriorityQueue<String> arrives = directedGraph.get(depart);
      while( arrives != null && ! arrives.isEmpty()){
        String arrive = arrives.poll();
        dfs(directedGraph, arrive, eulerPath);
      }
      eulerPath.addFirst(depart);
    }
}
