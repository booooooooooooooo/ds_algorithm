/**
 This idea is fine.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
      //add dummy head
      ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
      dummyHead.next = head;

      //find the div node, which is the first node whose value>= x, and the node before div node
      ListNode prevDiv = null;
      ListNode div = null;
      ListNode tail = dummyHead;
      while( !(tail.next == null) ){
        if(tail.next.val >= x){
          prevDiv = tail;
          div = tail.next;
          break;
        }
        tail = tail.next;
      }


      //If div == null, all values of list < x. Return head right now.
      if(div == null) return dummyHead.next;

      //If list is not ordered, insert each node after div whose value < 3 right before div
      tail = div;
      while( tail.next != null ){
        if(tail.next.val < x){
          //cut tail.next out
          ListNode temp = tail.next;
          tail.next = tail.next.next;
          //insert it right before div
          temp.next = div;
          prevDiv.next = temp;
          //update prevDiv
          prevDiv = temp;
        }else
          tail = tail.next;
      }
      return dummyHead.next;

    }
}
