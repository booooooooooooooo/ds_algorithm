/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
      //add dummy head
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;


      //set pointer
      ListNode tail = dummyHead;

      //scan
      while(tail.next != null && tail.next.next != null){
        ListNode temp = tail.next;
        tail.next = tail.next.next;
        temp.next = temp.next.next;
        tail.next.next = temp;

        tail = tail.next.next;
      }
      //return
      return dummyHead.next;
    }
}
