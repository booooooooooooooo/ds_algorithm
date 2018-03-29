/**
 This idea seems not quite under control.
 TODO: Come up with a more controllable idea.
       Add dummyHead and dummyTail, make a clean and easy reverse, then delete dummyTail?
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;

      ListNode wait = null;
      ListNode front = null;
      ListNode tail = null;
      int i = 0;
      ListNode node = dummyHead;
      while(i <= n){
        if(i == m - 1) wait = node;
        if(i == m) front = node;
        if(i == n) tail = node;
        node = node.next;
        i++;
      }

      for(int j = 0; j < n - m; j++){
        ListNode temp = front.next;
        front.next = tail.next;
        tail.next = front;
        front = temp;
      }
      wait.next = front;


      return dummyHead.next;
    }
}
