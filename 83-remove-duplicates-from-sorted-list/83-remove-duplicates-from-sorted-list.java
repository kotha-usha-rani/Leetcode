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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next ;
        ListNode prev = head;
        while(temp.next != null){
            if(temp.val != prev.val){
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        if(prev.val == temp.val)
            prev.next = null;
        else
            prev.next = temp;
        return head;
    }
}