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
 * Modify original linkedlist
 */

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//       //exclude empty List
//       if(head == null) return false;;
//
//
//       //create indicator node
//       ListNode indicatorNode = new ListNode(0);
//
//       //Scan and return false if anynode.next == indicator node
//       ListNode tail = head;
//       while(tail != null){
//         if(tail.next == indicatorNode) return true;
//         ListNode temp = tail.next;
//         tail.next = indicatorNode;
//         tail = temp;
//       }
//
//       //No problem then return true;
//       return false;
//     }
// }


/**
 * Use two pointers. Do not modify linkedlist
 */

// public class Solution {
//    public boolean hasCycle(ListNode head) {
//      //exclude empty List
//      if(head == null) return false;
//
//
//      //create two pointers.
//      ListNode tail1 = head;
//      ListNode tail2 = head;
//
//      //One pointer goes one step, the other pointere goes two steps.
//      //If there is cycle, they will met in <= n moves. Then return true.
//      //If there is not cycle, while loop will terminates in <= moves.
//
//      while(tail1 != null && tail1.next != null){
//        tail1 = tail1.next.next;
//        tail2 = tail2.next;
//        if(tail1 == tail2) return true;
//      }
//
//      // no cycle then return true;
//      return false;
//    }
// }


/**
 * Use hash table. Do not modify linkedlist
 */
 import java.util.HashSet;

 public class Solution {
     public boolean hasCycle(ListNode head) {
       //exclude empty list
       if(head == null) return false;

       //Create hashSet
       HashSet<ListNode> nodeSet = new HashSet<ListNode>();

       //Scan linkedlist.
       //If there is cycle, at n + 1 moves, the current node should be in nodeSet. Then return true.
       //If there is not cycle, while loop will terminates in n moves.
       ListNode tail = head;
       while(tail != null){
         if(nodeSet.contains(tail)) return true;
         else{
           nodeSet.add(tail);
           tail = tail.next;
         }
       }

       //no cycle, return false;
       return false;

     }
 }
