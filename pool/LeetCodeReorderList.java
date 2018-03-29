/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
      //Exclude emtyp List
      if(head == null) return ;


      //Get length of linkedList
      int length = 0;
      ListNode tail = head;
      while(tail != null){
        length++;
        tail = tail.next;
      }


      //Get the end of first half.
      ListNode end = head;
      int count = 0;
      while(count < length / 2){
        end = end.next;
        count++;
      }

      //Cut off the second half and reverse it
      ListNode dummyHeadReversed = new ListNode(0);
      tail = dummyHeadReversed;
      while(end.next != null){
        ListNode dangling = end.next;
        end.next = dangling.next;
        dangling.next = tail.next;
        tail.next = dangling;
      }



      //Combine the first half the reverse of second half together
      tail = head;
      while(tail != null && dummyHeadReversed.next != null){
        ListNode dangling = dummyHeadReversed.next;
        dummyHeadReversed.next = dangling.next;
        dangling.next = tail.next;
        tail.next = dangling;
        tail = tail.next.next;
      }


    }
}
