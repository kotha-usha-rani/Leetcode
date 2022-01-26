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
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode nextNode = head.next;
        ListNode current = head;
        while(temp != null){
            temp = nextNode.next ;
            nextNode.next = current ;
            current = nextNode ;
            nextNode = temp;
        }
        head.next = null;
        return current;
    }
}