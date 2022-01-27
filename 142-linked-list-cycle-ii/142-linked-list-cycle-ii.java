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
    public ListNode detectCycle(ListNode head) {
        if(head == null ||head.next == null)
            return null;
        if(head.next == head)
            return head;
        
        //Method 1 Using Hashmap
        // HashMap<ListNode, Boolean> map = new HashMap<>();
        // ListNode temp = head;
        // ListNode cycleNode = null ;
        // while(temp != null){
        //     if(map.containsKey(temp)){
        //         return temp;
        //     }
        //     else
        //         map.put(temp, true);
        //     temp = temp.next;
        // }
        // return null;
        
        //Method 2 using slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        ListNode temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }
}









