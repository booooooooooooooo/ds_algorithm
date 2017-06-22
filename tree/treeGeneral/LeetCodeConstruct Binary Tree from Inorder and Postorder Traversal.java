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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      //corner: I assume inputs are valid

      return solve(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode solve(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
      if(inend == instart) return null;
      else{
        TreeNode node = new TreeNode(postorder[postend - 1]);
        int index = -1;
        for(int i = instart; i < inend; i++){
          if(inorder[i] == postorder[postend - 1]){
            index = i;
            break;
          }
        }
        node.left = solve(inorder, instart, index, postorder, poststart, poststart + (index - instart));
        node.right = solve(inorder, index + 1, inend, postorder, poststart + (index - instart), postend - 1);
        return node;
      }
    }
}
