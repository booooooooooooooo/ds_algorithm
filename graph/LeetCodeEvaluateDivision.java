import java.util.*;

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      //make adjList using equations and values
      HashMap<String, HashMap<String, Double>> adjList = new HashMap<String, HashMap<String, Double>>();
      for(int i = 0; i < values.length; i++){
        String start = equations[i][0];
        String end = equations[i][1];
        Double v = values[i];
        adjList.putIfAbsent(start, new HashMap<String, Double>());
        adjList.get(start).put(end, v);
        adjList.putIfAbsent(end, new HashMap<String, Double>());
        adjList.get(end).put(start, 1.0 / v);
      }

      //iterate queries, call gao() to get answer and append answer to result.
      double[] results = new double[queries.length];
      for(int i = 0; i < queries.length; i++){
        String[] query = queries[i];
        double result = gao(adjList, query);
        results[i] = result;
      }
      //return results
      return results;
    }
    public double gao(HashMap<String, HashMap<String, Double>> adjList, String[] query){
      HashMap<String, String> markedEdge = new HashMap<String, String>();
      boolean exists = dfs(adjList, query[0], query[1], markedEdge);
      if(exists){
        double result = 1;
        for(String start : markedEdge.keySet()){
          String end = markedEdge.get(start);
          double factor = adjList.get(start).get(end);
          result *= factor;
        }
        return result;
      }
      //no solution.
      return -1;

    }

    public boolean dfs(HashMap<String, HashMap<String, Double>> adjList, String start, String finalEnd, HashMap<String, String> markedEdge){
      if(!adjList.containsKey(start)) return false;
      else{
          for(String end : adjList.get(start).keySet()){
            if(!markedEdge.containsKey(start)){
              markedEdge.put(start, end);
              if(end.equals(finalEnd) || dfs(adjList, end, finalEnd, markedEdge)) return true;
              markedEdge.remove(start);
            }
          }
          return false;
      }
    }
}
