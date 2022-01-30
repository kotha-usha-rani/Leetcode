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
    public ListNode mergeSort(ListNode t1, ListNode t2){
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1 ;
        if(t1.val <= t2.val){
            t1.next = mergeSort(t1.next, t2);
            return t1;
        }
        else{
            t2.next = mergeSort(t1, t2.next);
            return t2 ;
        }
    }
    public ListNode findMid(ListNode start){
        ListNode slow = start;
        ListNode fast = start;
        ListNode prev = start;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null)
            return prev;
        else
            return slow;
    }
    public ListNode sort(ListNode start){
        if(start == null || start.next == null)
            return start;
        ListNode mid = findMid(start);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = sort(start);
        ListNode right = sort(midNext);
        return mergeSort(left, right);
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return sort(head);
    }
}