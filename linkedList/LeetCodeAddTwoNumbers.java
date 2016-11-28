/**
The idea is fair.
 TODO: Use less and more clear codet.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // get l1_length, l2_length
      int l1_length = 0;
      int l2_length = 0;
      ListNode t1 = l1;
      ListNode t2 = l2;
      while(t1 != null){
        l1_length++;
        t1 = t1.next;
      }
      while(t2 != null){
        l2_length++;
        t2 = t2.next;
      }

      //assign bigger length to m, shorter length to n
      // exchanges l1 and l2 is length of l1 < length of l2
      int m = Math.max(l1_length, l2_length);
      int n = Math.min(l1_length, l2_length);
      if(l1_length < l2_length){
        ListNode temp = l1;
        l1 = l2;
        l2 = temp;
      }



      //change l1 and return l1 as result. If cannot change input data, copy l1 to l3.
      t1 = l1;
      t2 = l2;
      int acc = 0;
      for(int i = 0; i < n; i++){
        int v1 = t1.val;
        int v2 = t2.val;
        t1.val = (v1 + v2 + acc) % 10;
        acc = (v1 + v2 + acc) / 10;
        t1 = t1.next;
        t2 = t2.next;
      }

      for(int i = 0; i < m - n; i++){
        int v1 = t1.val;
        t1.val = (v1 + acc) % 10;
        acc = (v1 + acc) / 10;
        t1 = t1.next;
      }
      if(acc > 0){
        t1 = l1;
        while(t1.next != null) t1 = t1.next;
        t1.next = new ListNode(acc);
      }
      return l1;
    }

}
