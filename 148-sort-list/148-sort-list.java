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
    public ListNode sort(ListNode start, ListNode end, int count){
        if(start == null || start.next == null)
            return start;
        int mid = count/2;
        ListNode temp = start ;
        int i=mid;
        while(i>0){
            temp = temp.next;
            i--;
        }
        ListNode midNext = temp.next;
        temp.next = null;
        ListNode left = sort(start, temp, mid);
        ListNode right = sort(midNext, end, count-mid-1);
        return mergeSort(left, right);
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return sort(head, null, count);
    }
}