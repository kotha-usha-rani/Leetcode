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
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        //Method 1 Using fast and slow pointers
       //  if(head == null)
       //      return false;
       //  ListNode slow = head;
       //  ListNode fast = head;
       //  while(fast != null && fast.next != null){
       //      fast = fast.next.next;
       //      slow = slow.next;
       //      if(fast == slow)
       //          return true;
       //  }
       // return false;
        
        //Using hashmaps
        if(head == null)
            return false;
        HashMap<ListNode, Boolean> map = new HashMap<>();
        while(head.next != null){
            if(map.containsKey(head))
                return true;
            else
                map.put(head, true);
            head = head.next;
        }
        return false;
    }
}



