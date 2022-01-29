/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head.next == null)
            return head;
        //Method 1 count the number of nodes in the list, return the middle node
        // ListNode temp = head;
        // int count = 0;
        // while(temp != null){
        //     count++;
        //     temp = temp.next;
        // }
        // count = count/2+1;
        // temp = head;
        // while(count > 1){
        //     temp = temp.next;
        //     count--;
        // }
        // return temp;
        
        //Method 2 using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next ;
        }
        return slow;
    }
}