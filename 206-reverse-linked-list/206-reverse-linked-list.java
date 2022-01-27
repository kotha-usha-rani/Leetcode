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
     //Method 2 recursion
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head ;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        //head.next = null;
        return newHead;
    }
    
    //Method 3 resusive just like iteratie approach
    public ListNode reverse2(ListNode current, ListNode prev, ListNode next){
        if(current == null)
            return current;
        if(current.next == null){
            current.next = prev ;
            return current;
            
        }
        next = current.next;
        current.next = prev ;
        return reverse2(next, current, next);
        
    }
    public ListNode reverseList(ListNode head) {
        //Method 1 change the links TC=O(n), SC=O(1)
        // if(head == null || head.next == null)
        //     return head;
        // ListNode prev = null;
        // ListNode nextNode = null;
        // ListNode current = head;
        // while(current != null){
        //     nextNode = current.next;
        //     current.next = prev ;
        //     prev = current;
        //     current = nextNode;
        // }
        // return prev;
        
        //Method 2 recursion
        // ListNode newHead = reverse(head);
        // if(head != null)
        //     head.next = null;
        // return newHead;
        
        //Method 3 resusive just like iteratie approach
        
        return  reverse2(head, null, null);       
    }
}






