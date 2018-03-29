/*
Bellman-Ford
Dijkstra
Floyd-Warshall
**/
import java.util.*;

public class PojStockbrokerGrapevine{

  public static void main(String[] args){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      if(n == 0) break;
      HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<Integer, HashMap<Integer, Integer>>();
      for(int i = 1; i <= n; i++){
        int k = cin.nextInt();
        for(int j = 0; j < k; j++){
          int end = cin.nextInt();
          int weight = cin.nextInt();
          if(adjList.get(i) == null) adjList.put(i, new HashMap<Integer, Integer>());
          adjList.get(i).put(end, weight);
        }
      }

      // bellmanFord(adjList, n);
      // dijkstra(adjList, n);
      floydWarshall(adjList, n);

    }
  }


  /*
  Bellman-Ford
  **/
  public static void bellmanFord(HashMap<Integer, HashMap<Integer, Integer>> adjList, int n){
    int person = -1;
    int minT = Integer.MAX_VALUE;
    for(Integer start : adjList.keySet()){
      int time = doBellmanFord(start, adjList, n);
      if(minT > time){
        minT = time;
        person = start;
      }
    }
    System.out.printf("%d %d\n", person, minT);
  }
  public static int doBellmanFord(int start, HashMap<Integer, HashMap<Integer, Integer>> adjList, int n){
    int[] minTime = new int[n + 1];
    Arrays.fill(minTime, Integer.MAX_VALUE / 2);
    minTime[start] = 0;
    while(true){
      boolean update = false;
      for(Integer edgeStart : adjList.keySet()){
        if(adjList.get(edgeStart) == null) continue;
        for(Integer edgeEnd : adjList.get(edgeStart).keySet()){
          int edgeLen = adjList.get(edgeStart).get(edgeEnd);
          if(minTime[edgeEnd] - edgeLen > minTime[edgeStart]){
            minTime[edgeEnd] = minTime[edgeStart] + edgeLen;
            update = true;
          }
        }
      }
      if(!update) break;
    }
    int time = Integer.MIN_VALUE;

    // System.out.println(Arrays.toString(minTime));
    for(int i = 1; i < minTime.length; i++){
      if(minTime[i] > time){
        time = minTime[i];
      }
    }
    return time;
  }

  /*
  Dijkstra
  **/
  public static void dijkstra(HashMap<Integer, HashMap<Integer, Integer>> adjList, int n){
    int person = -1;
    int minT = Integer.MAX_VALUE;
    for(Integer start : adjList.keySet()){
      int time = doDijkstra(start, adjList, n);
      if(minT > time){
        minT = time;
        person = start;
      }
    }
    System.out.printf("%d %d\n", person, minT);
  }
  public static int doDijkstra(int start, HashMap<Integer, HashMap<Integer, Integer>> adjList, int n){
    int[] minTime = new int[n + 1];
    Arrays.fill(minTime, Integer.MAX_VALUE);
    minTime[start] = 0;
    Queue<Pair> que = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2){
        return p1.d < p2.d ? -1 : 1;
      }
    });
    que.add(new Pair(start, 0));
    while(!que.isEmpty()){
      Pair pair = que.remove();
      int edgeStart = pair.person;
      int d = pair.d;
      if(d > minTime[edgeStart]) continue;
      HashMap<Integer, Integer> edges = adjList.get(edgeStart);
      if(edges == null) continue;
      for(Integer edgeEnd : edges.keySet()){
        if(minTime[edgeStart] + edges.get(edgeEnd) < minTime[edgeEnd]){
          minTime[edgeEnd] = minTime[edgeStart] + edges.get(edgeEnd);
          que.add(new Pair(edgeEnd, minTime[edgeEnd]));
        }
      }
    }

    int time = Integer.MIN_VALUE;
    for(int i = 1; i < minTime.length; i++){
      if(minTime[i] > time){
        time = minTime[i];
      }
    }
    return time;
  }


  /*
  Floyd-Warshall
  **/
  public static void floydWarshall(HashMap<Integer, HashMap<Integer, Integer>> adjList, int n){
    int[][] minTime = new int[n + 1][n + 1];
    for(int[] t : minTime) Arrays.fill(t, Integer.MAX_VALUE / 2);
    for(Integer edgeStart : adjList.keySet()){
      if(adjList.get(edgeStart) == null) continue;
      for(Integer edgeEnd : adjList.get(edgeStart).keySet()){
        minTime[edgeStart][edgeEnd] = adjList.get(edgeStart).get(edgeEnd);
      }
    }
    for(int i = 1; i <= n; i++) minTime[i][i] = 0;//!!!!!!!!!!!
    for(int i = 1; i <= n; i++){
      for(int j = 1; j <= n; j++){
        for(int k = 1; k <= n; k++){
          minTime[j][k] = Math.min(minTime[j][k], minTime[j][i] + minTime[i][k]);
        }
      }
    }
    int person = -1;
    int minT = Integer.MAX_VALUE;
    for(int i = 1; i <= n; i++){
      // System.out.println(Arrays.toString(minTime[i]));
      int time = Integer.MIN_VALUE;
      for(int j = 1; j <= n; j++){
        if(minTime[i][j] > time) time = minTime[i][j];
      }
      if(time < minT){
        minT = time;
        person = i;
      }
    }
    System.out.printf("%d %d\n", person, minT);
  }
}




class Pair{
  public int person;
  public int d;
  public Pair(int person, int d){
    this.person = person;
    this.d = d;
  }
}
