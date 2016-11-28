/**
 This idea looks quite fragmented.
 TODO: improve.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      //exclude empty linked List
      if(head == null) return head;


      //make dummy head
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;

      //create prev and cur
      ListNode prev = dummyHead;
      ListNode cur = head;
      //create indicator of whether delete cur node
      boolean del = false;

      //scan
      while( !(cur.next == null) ){
        if(cur.val == cur.next.val){
          cur = cur.next;
          del = true;
        }else{
          if(del){
            cur = cur.next;
            prev.next = cur;
          }else{
            prev = cur;
            cur = cur.next;
          }
          del = false;
        }
      }

      // process last step
      if(del) prev.next = null;

      //return dummyHead.next
      return dummyHead.next;
    }
}
