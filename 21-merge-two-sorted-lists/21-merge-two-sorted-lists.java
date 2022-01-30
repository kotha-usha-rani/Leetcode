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
    public ListNode recursive(ListNode t1, ListNode t2){
        if(t1 == null)
            return t2 ;
        if(t2 == null)
            return t1 ;
        if(t1.val <= t2.val){
            t1.next = recursive(t1.next, t2);
            return t1;
        }
        else{
            t2.next= recursive(t1, t2.next);
            return t2;
        }
            
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Method 1 iterative
        // if(list1 == null && list2 == null)
        //     return null;
        // if(list1 == null)
        //     return list2;
        // if(list2 == null)
        //     return list1;
        // ListNode t1 =null , t2 = null;
        // if(list1.val <= list2.val){
        //     t1 = list1; t2 = list2;
        // }
        // else{
        //     t1 = list2; t2 = list1 ;
        // }
        // ListNode prev = t1, newHead = t1 ;
        // while(t1 != null && t2 != null){
        //     if(t1.val <= t2.val){
        //         prev = t1 ;
        //         t1 = t1.next;
        //     }
        //     else{
        //         ListNode temp = t2;
        //         t2 = t2.next;
        //         temp.next = t1;
        //         prev.next = temp;
        //         prev = temp;
        //     }
        // }
        // if(t2 != null){
        //     prev.next = t2;
        // }
        // return newHead;
        
        //Method 2 recursive
        
        return recursive(list1, list2);
    }
}








