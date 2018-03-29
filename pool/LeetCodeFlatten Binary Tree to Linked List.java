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
    public void flatten(TreeNode root) {
      //corner
      if(root == null) return;

      solve(root);
    }
    //TIP: write out all == != to avoid logic trap
    //parameter node cannot be null
    private TreeNode solve(TreeNode node){
      TreeNode left = node.left;
      TreeNode right = node.right;
      if(left != null && right != null){
        node.left = null;
        node.right = left;
        TreeNode endLeft = solve(left);
        endLeft.right = right;
        TreeNode endRight = solve(right);
        return endRight;
      }else if(left != null && right == null){
        node.left = null;
        node.right = left;
        TreeNode endRight = solve(left);
        return endRight;
      }else if(left == null && right != null ){
        TreeNode endRight = solve(right);
        return endRight;
      }else{
        return node;
      }
    }
}
