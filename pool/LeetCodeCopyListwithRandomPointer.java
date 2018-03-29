/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      //exclude null list
      if(head == null) return null;



      // Duplicate each node with same value
      // Insert new node right after its prototype by updating next.
      RandomListNode tail1 = head;
      while(tail1 != null){
        RandomListNode temp = new RandomListNode(tail1.label);
        temp.next = tail1.next;
        tail1.next = temp;
        tail1 = tail1.next.next;
      }


      //Update  random of new nodes
      tail1 = head;
      while(tail1 != null){
        tail1.next.random = (tail1.random != null) ? tail1.random.next : null;
        tail1 = tail1.next.next;
      }

      //Get copyHead
      RandomListNode copyHead = head.next;

      //Cut new nodes to recover given list and get a deep copy of given list.
      tail1 = head;
      RandomListNode tail2 = copyHead;
      while(tail1 != null){
        RandomListNode temp1 = (tail2.next != null) ? tail1.next.next : null;
        RandomListNode temp2 = (tail2.next != null) ? tail2.next.next : null;

        tail1.next = temp1;
        tail2.next = temp2;

        tail1 = temp1;
        tail2 = temp2;
      }

      //return head of new list
      return copyHead;

    }
}
