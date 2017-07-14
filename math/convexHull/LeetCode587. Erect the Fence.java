/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public List<Point> outerTrees(Point[] points) {
      //corner: TODO
      //sort points by first order x, second order y
      Arrays.sort(points, new Comparator<Point>(){
        @Override
        public int compare(Point p1, Point p2){
          if(p1.x != p2.x) return p1.x - p2.x;
          else return p1.y - p2.y;
        }
      });


      //construct the lower part of convex hull
      List<Point> result = new ArrayList<Point>();
      int k = 0;//the left-bottom point
      for(int i = 0; i < points.length; i++){
        while( k >= 2 && (result.get(k-1).x - result.get(k-2).x) * (points[i].y - result.get(k-1).y )
                        - (result.get(k-1).y - result.get(k-2).y) * (points[i].x - result.get(k-1).x)
                        < 0 )
          k--;
        if(result.size() == k) result.add(points[i]);
        else result.set(k, points[i]);
        k++;
      }
      //co-liner case
      boolean isCoLiner = true;
      for(int i = 2; i < points.length; i++){
        if( (points[i-2].x - points[i-1].x) * (points[i-1].y - points[i].y)
            - (points[i-2].y - points[i-1].y) * (points[i-1].x - points[i].x)
            != 0){
            isCoLiner = false;
            break;
         }
      }
      if(isCoLiner) return Arrays.asList(points);
      //construct the upper part of convex hull
      int t = k - 1;//the right-up point
      for(int i = points.length - 2; i >= 0; i--){
        while( k >= t + 2 && (result.get(k-1).x - result.get(k-2).x) * (points[i].y - result.get(k-1).y )
                        - (result.get(k-1).y - result.get(k-2).y) * (points[i].x - result.get(k-1).x)
                        < 0 )
          k--;
        if(result.size() == k) result.add(points[i]);
        else result.set(k, points[i]);
        k++;
      }
      //only use [0,k). Use a set to remove duplicate
      return result.subList(0, k - 1);//do not forget to remove duplicate start point

    }
}
