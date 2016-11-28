/**
 Two pointers.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      //exclude empty linkedlist
      if(head == null) return null;

      //create dummy head
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;

      //set two pointers
      ListNode front = dummyHead;
      ListNode tail = dummyHead;
      for(int i = 0; i < n; i++) tail = tail.next;

      //move two pointers together to end
      while( !(tail.next == null) ){
        front = front.next;
        tail = tail.next;
      }

      //delete target
      front.next = front.next.next;

      //return next of dummy
      return dummyHead.next;

    }
}
