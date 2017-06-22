/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
      if(root == null) return;

      solve(root);
    }
    //node is never null.
    private void solve(TreeLinkNode node){
      if(node.left == null && node.right == null) return;
      else{
        node.left.next = node.right;
        if(node.next != null)
          node.right.next = node.next.left;
        solve(node.left);
        solve(node.right);
      }
    }
}
