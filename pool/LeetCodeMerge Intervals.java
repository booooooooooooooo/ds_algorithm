/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
      //corner case?

      //sort intervals
      Collections.sort(intervals, new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2){
          return i1.start - i2.start;
        }
      });
      //scan and update result
      List<Interval> result = new ArrayList<Interval>();
      Interval temp = null;
      int i = 0;
      while(true){
        if(temp == null){
          if(i >= intervals.size())
            break;
          else{
            temp = new Interval(intervals.get(i).start, intervals.get(i).end);
            i++;
          }
        }else{
          if(i >= intervals.size()){
            result.add(temp);
            break;
          }
          else{
            if(isOverlap(temp, intervals.get(i))){
              temp = union(temp, intervals.get(i));
              i++;
            }else{
              result.add(temp);
              temp = null;
            }
          }
        }
      }
      //return result
      return result;
    }
    private boolean isOverlap(Interval i1, Interval i2){
      if(i2.start < i1.start){
        Interval temp = i1;
        i1 = i2;
        i2 = temp;
      }

      if(i2.start <= i1.end) return true;
      else return false;
    }
    private Interval union(Interval i1, Interval i2){
      if(i2.start < i1.start){
        Interval temp = i1;
        i1 = i2;
        i2 = temp;
      }
      return new Interval(i1.start, Math.max(i1.end, i2.end));
    }
}
