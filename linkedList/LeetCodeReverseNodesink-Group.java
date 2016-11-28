/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      //exclude empty list
      if(head == null) return null;



      //add dummy head
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;

      //set prevs
      ListNode prev = dummyHead;


      //while loop to scan
      while( isValidInterval(prev, k) ){
        reverseK(prev, k);
        prev = getKthNode(prev, k);
      }

      //return dummy next
      return dummyHead.next;
    }

    public boolean isValidInterval(ListNode prev, int k){
      ListNode node = prev;
      for(int i = 0; i < k; i++){
        if(node.next == null) return false;
        else node = node.next;

      }
      return true;
    }

    public void reverseK(ListNode prev, int k){
      ListNode front = prev.next;
      ListNode tail = getKthNode(prev, k + 1);
      for(int i = 0; i < k; i++){
        ListNode temp = front.next;
        front.next = tail;
        tail = front;
        front = temp;
      }
      prev.next = tail;
    }

    public ListNode getKthNode(ListNode prev, int k){
      ListNode node = prev;
      for(int i = 0; i < k; i++) node = node.next;
      return node;
    }
}
