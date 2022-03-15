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
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
        //Method 1 recursive
        // if(list1.val <= list2.val){
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // }
        // else{
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }
        
        
        
        //Method 2 iterative
        // ListNode head = null, prev = null, l1=list1, l2=list2;
        // if(l1.val <= l2.val){
        //     head = l1;
        //     prev = l1;
        //     l1 = l1.next;
        // }
        // else{
        //     head = l2;
        //     prev = l2;
        //     l2 = l2.next;
        // }
        // while(l1 != null && l2 != null){
        //     if(l1.val <= l2.val){
        //         prev.next = l1;
        //         prev = l1;
        //         l1 = l1.next;
        //     }
        //     else{
        //         prev.next = l2;
        //         prev = l2;
        //         l2 = l2.next;
        //     }
        // }
        // if(l1 != null)
        //     prev.next = l1;
        // if(l2 != null)
        //     prev.next = l2;
        // return head;
        
        //better code
        ListNode l1 = list1, l2 = list2, temp = null, prev;
        if(l1.val > l2.val){
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head = l1;
        while(l1 != null && l2 != null){
            prev = null;
            while(l1 != null && l1.val <= l2.val){
                prev = l1; 
                l1 = l1.next;
            }
            prev.next = l2;
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return head;
    }
}