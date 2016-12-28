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
    public List<TreeNode> generateTrees(int n) {
      //exclude corner case
      if(n == 0) return new ArrayList<TreeNode>();
      //return normal Solution
      return dfs(1, n);
    }

    public List<TreeNode> dfs(int left, int right){
      List<TreeNode> result = new ArrayList<TreeNode>();
      if(left > right) result.add(null);
      else{
        for(int i = left; i <= right; i++){
          TreeNode root = new TreeNode(i);
          List<TreeNode> childrenLeft = dfs(left, i - 1);
          List<TreeNode> childrenRight = dfs(i + 1, right);
          for(int j = 0; j < childrenLeft.size(); j++){
            for(int k = 0; k < childrenRight.size(); k++){
              root.left = childrenLeft.get(j);
              root.right = childrenRight.get(k);
              result.add(copyTree(root));
            }
          }
        }
      }
      return result;
    }

    public TreeNode copyTree(TreeNode root){
      if(root == null)
        return null;
      else{
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
      }
    }
}
