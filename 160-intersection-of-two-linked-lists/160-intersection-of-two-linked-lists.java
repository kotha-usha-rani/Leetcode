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
    public ListNode intersection(ListNode headA, ListNode headB){
        while(headA != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Method 1 using two loops
        // ListNode temp1 = headA;
        // ListNode temp2 = headB;
        // ListNode ans = null;
        // while(temp1 != null){
        //     while(temp2 != null){
        //         if(temp1 == temp2){
        //             return temp2;
        //         }
        //         temp2 = temp2.next;
        //     }
        //     temp1 = temp1.next;
        //     temp2 = headB;
        // }
        // return ans;
        
        //Method 2 using count of nodes
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int c1 = 0; int c2 = 0;
        while(temp1 != null){
            c1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            c2++;
            temp2 = temp2.next;
        }
        if(c1 == c2)
            return intersection(headA, headB);
        if(c1 > c2){
            temp1 = headA; temp2 = headB;
        }
        else{
            temp1 = headB; temp2 = headA;
        }
        int diff = Math.abs(c1-c2);
        while(temp1 != null && diff > 0){
            diff--;
            temp1 = temp1.next;
        }
        return intersection(temp1, temp2);
        
    }
}






