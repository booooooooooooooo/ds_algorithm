public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
      map = new HashMap<Integer, Integer>();
      list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if(!map.containsKey(val)){
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
      }else return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if(map.containsKey(val)){
        //get index
        int index = map.get(val);
        //adjust
        if(index == list.size() - 1){
          map.remove(val);
          list.remove(list.size() - 1);
        }else{
          map.remove(val);
          map.put(list.get(list.size() - 1), index);
          list.set(index, list.get(list.size() - 1));
          list.remove(list.size() - 1);
        }
        //return
        return true;
      }else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      Random rd = new Random();
      return list.get(rd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
