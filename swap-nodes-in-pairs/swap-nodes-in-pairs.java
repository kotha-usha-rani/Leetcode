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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        ListNode secondNode = head.next;
        if(secondNode != null){
            head.next = secondNode.next;
            secondNode.next = head;
            head.next = swapPairs(head.next);
            return secondNode;
        }
        else
            return head;
    }
}