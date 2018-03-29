import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      int m = cin.nextInt();
      int x = cin.nextInt() - 1;
      List<List<Pair>> adj1 = new ArrayList<List<Pair>>();
      List<List<Pair>> adj2 = new ArrayList<List<Pair>>();
      for(int i = 0; i < n; i++){
        adj1.add(new ArrayList<Pair>());
        adj2.add(new ArrayList<Pair>());
      }
      for(int i = 0; i < m; i++){
        int start = cin.nextInt() - 1;
        int end = cin.nextInt() - 1;
        int wt = cin.nextInt();
        adj1.get(start).add(new Pair(end, wt));
        adj2.get(end).add(new Pair(start, wt));
      }
      System.out.println(solve(adj1, adj2, x));
    }
  }
  public static int solve(List<List<Pair>> adj1, List<List<Pair>> adj2, int x){
    int[] shortest1 = dijkstra(adj1, x);
    int[] shortest2 = dijkstra(adj2, x);
    int result = 0;
    for(int i = 0; i < shortest1.length; i++) result = Math.max(shortest1[i] + shortest2[i], result);
    return result;
  }
  public static int[] dijkstra(List<List<Pair>> adj, int x){
    //dijkstra
    int n = adj.size();
    int[] shortest = new int[n];
    Arrays.fill(shortest, -1);
    Queue<Pair> heap = new PriorityQueue<Pair>(1, new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2){
        return p1.d - p2.d;
      }
    });
    heap.add(new Pair(x, 0));
    while(!heap.isEmpty()){
      Pair p = heap.remove();
      if(shortest[p.node] == -1){
        shortest[p.node] = p.d;
        List<Pair> edges = adj.get(p.node);
        for(Pair edge : edges){
          heap.add(new Pair(edge.node, edge.d + p.d));
        }
      }
    }
    return shortest;
  }

}
class Pair{
  public int node;
  public int d;
  public Pair(int node, int d){
    this.node = node;
    this.d = d;
  }
}
