/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
      //len <= 1
      if(head == null || head.next == null) return head;
      //len >=2
      ListNode head2 = head.next;
      ListNode tail = head;
      ListNode tail2 = head2;
      while(tail.next != null && tail.next.next != null){
        tail.next = tail.next.next;
        tail = tail.next;
        tail2.next = tail2.next.next;
        tail2 = tail2.next;
      }
      tail.next = head2;
      return head;
    }
}
