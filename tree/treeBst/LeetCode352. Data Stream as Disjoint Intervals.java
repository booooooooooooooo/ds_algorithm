/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> tm;

    /** Initialize your data structure here. */
    public SummaryRanges() {
      tm = new TreeMap<Integer, Interval>();
    }

    public void addNum(int val) {
      Integer floor = tm.floorKey(val);
      if(floor != null && tm.get(floor).start <= val && val <= tm.get(floor).end) return;

      Integer lk = tm.lowerKey(val);
      Integer hk = tm.higherKey(val);
      if(lk == null && hk == null){
        tm.put(val, new Interval(val, val));
      }else if(lk == null && hk != null){
        if(val == tm.get(hk).start - 1){
          tm.put(val, new Interval(val, tm.get(hk).end));
          tm.remove(hk);
        }
        else tm.put(val, new Interval(val, val));
      }else if(lk != null && hk == null){
        if(val == tm.get(lk).end + 1) tm.get(lk).end++;
        else tm.put(val, new Interval(val, val));
      }else{
        if(val == tm.get(lk).end + 1 && val == tm.get(hk).start - 1){
          tm.get(lk).end = tm.get(hk).end;
          tm.remove(hk);
        }else if(val == tm.get(lk).end + 1 && val != tm.get(hk).start - 1){
          tm.get(lk).end++;
        }else if(val != tm.get(lk).end + 1 && val == tm.get(hk).start - 1){
          tm.put(val, new Interval(val, tm.get(hk).end));
          tm.remove(hk);
        }else{
          tm.put(val, new Interval(val, val));
        }
      }
    }

    public List<Interval> getIntervals() {
      return new ArrayList<Interval>(tm.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
