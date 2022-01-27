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
    public ListNode reverseList(ListNode head) {
        //Method 1 change the links TC=O(n), SC=O(1)
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode nextNode = null;
        ListNode current = head;
        while(current != null){
            nextNode = current.next;
            current.next = prev ;
            prev = current;
            current = nextNode;
        }
        return prev;
        
        //Method 2 recursion
        
        
    }
}