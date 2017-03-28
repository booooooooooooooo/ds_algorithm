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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      //excluder corner case
      if(preorder.length != inorder.length) return null;
      //call solve() and return result
      return solve(preorder, inorder, 0, 0, preorder.length);//len = end - start for [start, end) interval
    }
    public TreeNode solve(int[] preorder, int[] inorder, int startPreorder, int startInorder, int len){
      if(len == 0) return null;
      else{
        TreeNode node = new TreeNode(preorder[startPreorder]);
        int leftLen = -1;
        for(int i = startInorder; i < startInorder + len; i++){
          if(inorder[i] == preorder[startPreorder]){
            leftLen = i - startInorder;
            break;
          }
        }
        node.left = solve(preorder, inorder, startPreorder + 1, startInorder, leftLen);
        node.right = solve( preorder, inorder, startPreorder + 1 + leftLen, startInorder + leftLen + 1, len - leftLen - 1);
        return node;
      }


    }

}
