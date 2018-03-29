/**
MST
*/
import java.util.*;
public class PojAgriNet{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      if(n == 0) break;
      int[][] adjMatix = new int[n][n];
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          adjMatix[i][j] = cin.nextInt();
        }
      }
      // prim(adjMatix);
      kruskal(adjMatix);
    }
  }


  /**
  Prim
  */
  public static void prim(int[][] adjMatix){
    int result = 0;
    int n = adjMatix.length;
    boolean[] used = new boolean[n];
    Arrays.fill(used, false);
    int[] minLen = new int[n];
    Arrays.fill(minLen, Integer.MAX_VALUE);

    minLen[0] = 0;
    while(true){
      int pickedOne = -1;
      int len = Integer.MAX_VALUE;
      for(int  i= 0; i < n; i++){
        if(used[i] == false && minLen[i] < len){
          pickedOne = i;
          len = minLen[i];
        }
      }
      if(pickedOne == -1) break;//Another way is to make loop only n times. Use for instead of while.

      result += len;//If the situation need to output the tree, use other data stucture to record.

      used[pickedOne] = true;
      for(int j = 0; j < n; j++){
        minLen[j] = Math.min(minLen[j], adjMatix[pickedOne][j]);
      }
    }
    System.out.println(result);


  }

  /**
  Kruskal
  */
  public static void kruskal(int[][] adjMatix){

    int result = 0;

    int n = adjMatix.length;
    List<Edge> es = new ArrayList<Edge>();
    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        es.add( new Edge(i, j, adjMatix[i][j]) );
      }
    }
    Collections.sort(es, new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.len < e2.len ? -1 : 1;
      }
    });

    DisjointSet disjoint = new DisjointSet(n);

    for(int i = 0; i < es.size(); i++){
      Edge e = es.get(i);
      if(disjoint.find(e.start) != disjoint.find(e.end)){
        result += e.len;
        disjoint.union(e.start, e.end);
      }
    }

    System.out.println(result);
  }
}

class Edge{
  public int start;
  public int end;
  public int len;
  public Edge(int start, int end, int len){
    this.start = start;
    this.end = end;
    this.len = len;
  }
}

class DisjointSet{
  int[] parent;
  // int[] rank;
  public DisjointSet(int n){
    parent = new int[n];
    for(int i = 0; i < n; i++) parent[i] = i;
    // rank = new int[n];
    // Arrays.fill(rank, 0);
  }
  public int find(int x){
    if(parent[x] == x ) return x;
    else{
      return find(parent[x]);
    }
  }
  public void union(int x, int y){
    x = find(x);
    y = find(y);
    if(x == y) return;
    else parent[x] = y;
  }
}
