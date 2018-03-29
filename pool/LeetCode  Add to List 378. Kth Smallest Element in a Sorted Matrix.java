public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      int m = matrix.length;
      int n = matrix[0].length;

      Queue<Point> heap = new PriorityQueue<Point>(1, new Comparator<Point>(){
        @Override
        public int compare(Point p1, Point p2){
          return p1.val - p2.val;
        }
      });

      heap.add(new Point(0, 0, matrix[0][0]));
      for(int i = 2; i <= k; i++){
        Point p = heap.remove();
        if(p.j < n - 1)
          heap.add(new Point(p.i, p.j + 1, matrix[p.i][p.j + 1]));
        if(p.j == 0 && p.i < m - 1)
          heap.add(new Point(p.i + 1, 0, matrix[p.i + 1][0]));

      }
      return heap.remove().val;
    }
}

class Point{
  public int i;
  public int j;
  public int val;
  public Point(int i, int j, int val){
    this.i = i;
    this.j = j;
    this.val = val;
  }
}
