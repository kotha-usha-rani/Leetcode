/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Method 1 using two loops
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        ListNode ans = null;
        while(temp1 != null){
            while(temp2 != null){
                if(temp1 == temp2){
                    return temp2;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
            temp2 = headB;
        }
        return ans;
        
        //Method 2
    }
}