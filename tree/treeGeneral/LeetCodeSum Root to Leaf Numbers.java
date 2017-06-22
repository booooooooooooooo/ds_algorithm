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
  private int sum;
    public int sumNumbers(TreeNode root) {
      if(root == null) return 0;

      sum = 0;
      solve(0, root);
      return sum;
    }
    private void solve(int cur, TreeNode node){
      cur = cur* 10 + node.val;
      if(node.left == null && node.right == null)
        sum += cur;
      else if(node.left == null && node.right != null)
        solve(cur, node.right);
      else if(node.left != null && node.right == null)
        solve(cur, node.left);
      else{
        solve(cur, node.left);
        solve(cur, node.right);
      }
    }
}
