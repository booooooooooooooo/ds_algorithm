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
    public int maxPoints(Point[] points) {
      int count = 0;
      for(int i = 0; i < points.length; i++){
        count = Math.max(count, localMax(points, i));
      }
      return count;
    }
    public int localMax(Point[] points, int i){
      List<Slope> slopes = new ArrayList<Slope>();
      int overlapWithI = 1;//overlap points can take any slope
      int verticalPoints = 0;//pi / 2 angle
      for(int j = 0; j < points.length; j++){
        if(j != i){
          long deno = (long)points[j].x - points[i].x;
          long nomi = (long)points[j].y - points[i].y;
          if(deno < 0){
            deno = -deno;
            nomi = -nomi;
          }
          if(deno == 0 && nomi == 0) overlapWithI++;
          else if(deno == 0) verticalPoints++;
          else slopes.add(new Slope(nomi, deno));
        }
      }
      //sort -a ~ 0~ b
      Collections.sort(slopes, new Comparator<Slope>(){
        @Override
        public int compare(Slope s1, Slope s2){
          // if((float)s1.nomi / s1.deno - (float)s2.nomi / s2.deno < 0) return -1;
          // else if((float)s1.nomi / s1.deno - (float)s2.nomi / s2.deno > 0) return 1;
          // else return 0;
          if(s2.deno * s1.nomi - s1.deno * s2.nomi < 0) return -1;
          else if(s2.deno * s1.nomi - s1.deno * s2.nomi > 0) return 1;
          else return 0;
        }
      });
      //count
      int maxCount;
      if(slopes.size() == 0){
        maxCount = 0;
      }else if(slopes.size() == 1){
        maxCount = 1;
      }else{
        maxCount = 1;
        int tempCount = 1;
        for(int j = 1; j < slopes.size(); j++){
          if(slopes.get(j).equals(slopes.get(j-1)) ){
            tempCount++;
            maxCount = Math.max(maxCount, tempCount);
          }else{
            tempCount = 1;
          }
        }
      }
      return Math.max(maxCount,verticalPoints) + overlapWithI;

    }

    class Slope{
      public long nomi;
      public long deno;//deno > 0
      public Slope(long nomi, long deno){
        this.nomi = nomi;
        this.deno = deno;
      }
      public boolean equals(Slope s){
        return s.nomi * this.deno == this.nomi * s.deno;//caution: overflow!!!
      }
    }
}
