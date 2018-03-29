/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      solve(map, root);
      int mostFreq = 0;
      for(Integer key : map.keySet()){
        mostFreq = Math.max(mostFreq, map.get(key));
      }
      List<Integer> midResult = new ArrayList<Integer>();
      for(Integer key : map.keySet()){
        if(map.get(key) == mostFreq) midResult.add(key);
      }
      int[] result = new int[midResult.size()];
      for(int i = 0; i < midResult.size(); i++){
        result[i] = midResult.get(i);
      }
      return result;

    }

    public int solve(Map<Integer, Integer> map, TreeNode root){
      if(root == null) return 0;
      else{
        int leftSub = solve(map, root.left);
        int rightSub = solve(map, root.right);
        int sum = leftSub + rightSub + root.val;
        if(!map.containsKey(sum))  map.put(sum, 0);
        map.put(sum, map.get(sum) + 1);
        return sum;
      }
    }
}
