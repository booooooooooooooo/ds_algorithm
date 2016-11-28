/**
 Have improved on time.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      //exclude head == null
      if(head == null) return head;

      //get length of linkeList
      int len = 1;
      ListNode cur = head;
      while( cur.next != null ){
        len++;
        cur = cur.next;
      }
      //trun list to circle
      cur.next = head;

      //module k
      k = k % len;

      //find newHead
      ListNode newHead = head;
      for(int i = 0; i < len - k; i++) newHead = newHead.next;

      //break the rope before newHead
      cur = newHead;
      for(int i = 0; i < len - 1; i++) cur = cur.next;
      cur.next = null;

      //return newHead
      return newHead;
    }
}
