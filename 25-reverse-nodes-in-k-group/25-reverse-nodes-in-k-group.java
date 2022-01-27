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
    public ListNode reverse(ListNode head, ListNode end){
        if(head == end)
            return head;
        ListNode ans = reverse(head.next, end);
        head.next.next = head;
        head.next = null;
        return ans;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k==1)
            return head;
        
        //Method 1 iterative, reverse k nodes at a time
        ListNode prev = head;
        ListNode temp = head;
        ListNode temp2 = head;
        ListNode t = null;
        ListNode revHead = null;
        int count = 0;
        while(temp != null){
            count = 1;
            temp2 = temp;
            while(temp2.next != null && count < k){
                count++;
                temp2 = temp2.next;                
            }
            if(temp2.next == null && count < k)
                return head;
            t = temp2.next ;
            revHead = reverse(temp, temp2);
            if(temp == head)
               head = revHead;
            else
                prev.next = revHead ;
            temp.next = t ;
            prev = temp;
            temp = t;            
        }
        return head;
    }
}


