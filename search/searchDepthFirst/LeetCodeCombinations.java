public class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Integer[] combination = new Integer[k];
      int prevNum = 0;
      int count = 0;
      dfs(n, k, count, prevNum, combination, result);
      return result;
    }

    public void dfs(int n, int k, int count, int prevNum, Integer[] combination, List<List<Integer>> result){
      if(count == k){
        result.add(new ArrayList<Integer>( Arrays.asList(combination) ) );//Caution: must new instance!!
      }else{
        for(int i = prevNum + 1; i <= n; i++){
          combination[count] = i;
          dfs(n, k, count + 1, i, combination, result);
        }
      }
    }
}
