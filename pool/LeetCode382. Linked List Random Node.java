/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode head;
    private Random rd;
    public Solution(ListNode head) {
      this.head = head;
      this.rd = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
      ListNode node = head;
      int val = head.val;
      for(int i = 0; node != null; i++,node = node.next){
        if(rd.nextInt(i + 1) == i) val = node.val;
      }
      return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
