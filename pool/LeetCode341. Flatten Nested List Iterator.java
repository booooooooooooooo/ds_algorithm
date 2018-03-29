public class NestedIterator implements Iterator<Integer>{
  private List<Integer> flatList;
  private int index;
  public NestedIterator(List<NestedInteger> nestedList) {
    flatList = new ArrayList<Integer>();
    index = 0;
    flat(nestedList);
   }
   @Override
   public Integer next() {
     index++;
     return flatList.get(index - 1);
   }
   @Override
   public boolean hasNext() {
     if(index < flatList.size()) return true;
     else return false;
   }
   private void flat(List<NestedInteger> nestedList){
     for(int i = 0; i < nestedList.size(); i++)
       solve(nestedList.get(i));
     index = 0;
   }
   private void solve(NestedInteger ni){
     if(ni.isInteger()){
       this.flatList.add(ni.getInteger());
       index++;
     }else{
       List<NestedInteger> list = ni.getList();
       for(int i = 0; i < list.size(); i++)
        solve(list.get(i));
     }
   }
 }
