import java.util.*;
public class Solution {
    public int scheduleCourse(int[][] courses) {
      //sort courses by d
      Arrays.sort(courses, new Comparator<int[]>() {
          public int compare(int[] a, int[] b) {
              return Integer.compare(a[1], b[1]);
          }
      });


      int sum = 0;
      Queue<Integer> heap = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2){
          return i2 - i1;
        }
      });
      for( int[] course : courses){
        heap.add(course[0]);
        sum += course[0];
        if(sum > course[1] - 0) sum = sum - heap.poll();
      }
      return heap.size();


    }
}
