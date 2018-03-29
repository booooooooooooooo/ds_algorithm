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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      //corner
      if(root == null) return new ArrayList<List<Integer>>();

      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> curList = new ArrayList<Integer>();
      int curSum = 0;
      solve(sum, result, curList, curSum, root);
      return result;
    }
    //TIP: do not make base case as null. Such base case will make every path duplicated
    //node can never be null
    private void solve(int sum, List<List<Integer>> result, List<Integer> curList, int curSum, TreeNode node){
      curSum += node.val;
      curList.add(node.val);
      if(node.left == null && node.right == null){
        if(curSum == sum) result.add(makecopy(curList));
      }else if(node.left == null){
        solve(sum, result, curList, curSum, node.right);
      }else if(node.right == null){
        solve(sum, result, curList, curSum, node.left);
      }else{
        solve(sum, result, curList, curSum, node.left);
        solve(sum, result, curList, curSum, node.right);
      }
      curList.remove(curList.size() - 1);
    }
    private List<Integer> makecopy(List<Integer> curList){
      List<Integer> result = new ArrayList<Integer>();
      for(int i = 0; i < curList.size(); i++){
        result.add(curList.get(i));
      }
      return result;
    }
}
