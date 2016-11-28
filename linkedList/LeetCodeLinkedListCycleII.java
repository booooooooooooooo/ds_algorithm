/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
  * Use hash table. Do not modify linkedlist
  */

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//       //exclude empty List
//       if(head == null) return null;;
//
//       //Create hashSet
//       HashSet<ListNode> nodeSet = new HashSet<ListNode>();
//
//       //Scan linkedlist.
//       //If there is cycle, at n + 1 moves, the current node should be in nodeSet. Then return the current node..
//       //If there is not cycle, while loop will terminates in n moves.
//       ListNode tail = head;
//       while(tail != null){
//         if(nodeSet.contains(tail)) return tail;
//         else{
//           nodeSet.add(tail);
//           tail = tail.next;
//         }
//       }
//
//       //no cycle, return null;
//       return null;
//     }
// }


/**
 * Use two pointers. Do not modify linkedlist
 */

public class Solution {
   public ListNode detectCycle(ListNode head) {
     //exclude empty List
     if(head == null) return null;


     //Use a fast pointer and a slow pointer  to detect the node they met.
     //Fast pointer goes two steps per move.
     //SLow pointer goes one step per move.
     //If they meet, continue program; Otherwise, return null.
     ListNode meet = null;
     ListNode fast = head;
     ListNode slow = head;
     while(fast != null && fast.next != null){
       ListNode tempFast = fast.next.next;
       ListNode tempSlow = slow.next;
       if(tempFast == tempSlow){
         meet = tempFast;
         break;
       }else{
         fast = tempFast;
         slow = tempSlow;
       }
     }
     if(meet == null) return null;


     //From the node they met goes one slow pointer. From head goes another pointer.
     //They all go one step per one move.
     //When they are in same node, the node is the soluton.
     ListNode slow1 = head;
     ListNode slow2 = meet;
     while(true){
       if(slow1 == slow2) return slow1;
       else{
         slow1 = slow1.next;
         slow2 = slow2.next;
       }
     }
   }
}
