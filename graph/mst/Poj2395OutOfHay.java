import java.util.*;

public class Main{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    while(cin.hasNext()){
      int n = cin.nextInt();
      int m = cin.nextInt();
      List<Edge> edges = new ArrayList<Edge>();
      for(int i = 0; i < m; i++){
        int start = cin.nextInt() - 1;
        int end = cin.nextInt() - 1;
        int wt = cin.nextInt();
        edges.add(new Edge(start, end, wt));
        edges.add(new Edge(end, start, wt));

      }

      System.out.println(solve(edges, n));
    }
  }
  public static int solve(List<Edge> edges, int n){
    //kruskal
    int result = 0;
    DisJointSet disJointSet = new DisJointSet(n);
    Collections.sort(edges, new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.wt - e2.wt;
      }
    });

    for(Edge e : edges){
      if(disJointSet.contains(e.start) && disJointSet.contains(e.end)){
        if(!disJointSet.hasSameRoot(e.start, e.end)){
          result = Math.max(e.wt, result);
          disJointSet.union(e.start, e.end);
        }
      }else if(!disJointSet.contains(e.start) && disJointSet.contains(e.end)){
        result = Math.max(e.wt, result);
        disJointSet.add(e.start);
        disJointSet.union(e.start, e.end);
      }else if(disJointSet.contains(e.start) && !disJointSet.contains(e.end)){
        result = Math.max(e.wt, result);
        disJointSet.add(e.end);
        disJointSet.union(e.start, e.end);
      }else{
        result = Math.max(e.wt, result);
        disJointSet.add(e.start);
        disJointSet.add(e.end);
        disJointSet.union(e.start, e.end);
      }
    }
    if(disJointSet.size() == n && disJointSet.allInOneSet()) return result;
    else return -1;
  }
}
class DisJointSet{
  private int[] dat;
  private int size;
  public DisJointSet(int n){
    this.dat = new int[n];
    for(int i = 0; i < n; i++) dat[i] = -1;
    this.size = 0;
  }
  public boolean contains(int i){
    return dat[i] != -1;
  }
  public void add(int i){
    if(!this.contains(i)){
      dat[i] = i;
      this.size += 1;
    }

  }
  public int getRoot(int i){
    while(dat[i] != i) i = dat[i];
    return i;
  }
  public boolean hasSameRoot(int i1, int i2){
    return getRoot(i1) == getRoot(i2);
  }
  public void union(int i1, int i2){
    int root1 = getRoot(i1);
    int root2 = getRoot(i2);
    dat[root1] = root2;
  }
  public int size(){
    return this.size;
  }
  public boolean allInOneSet(){
    int parent = -1;
    for(int i = 0; i < this.dat.length; i++){
      if(dat[i] != -1 && parent == -1) parent = getRoot(dat[i]);

      if(dat[i] != -1 && parent != -1 && getRoot(i) != parent) return false;
    }
    return true;
  }

}
class Edge{
  public int start;
  public int end;
  public int wt;
  public Edge(int start, int end, int wt){
    this.start = start;
    this.end = end;
    this.wt = wt;
  }
}
