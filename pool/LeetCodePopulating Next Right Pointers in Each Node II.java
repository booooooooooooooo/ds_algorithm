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
      solve(root);
    }
    private void solve(TreeLinkNode head){
      if(head == null) return;
      else{
        TreeLinkNode childHead = null;
        TreeLinkNode tail = null;
        while(head != null){
          if(head.left != null){
            if(childHead == null){
              childHead = head.left;
              tail = head.left;
            }else{
              tail.next = head.left;
              tail = tail.next;
            }
          }
          if(head.right != null){
            if(childHead == null){
              childHead = head.right;
              tail = head.right;
            }else{
              tail.next = head.right;
              tail = tail.next;
            }
          }
          head = head.next;
        }
        solve(childHead);
      }
    }
}
