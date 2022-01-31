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
    
    //Method 2 
    public ListNode sortUsingBubbleSort(ListNode head){
        if(head.next == null)
            return head;
        head.next = sortUsingBubbleSort(head.next);
        ListNode tempHead = head;
        while(head.next != null){
            if(head.val > head.next.val){
                int temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
            }
            else
                break;
            head = head.next;
        }
        return tempHead ;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //Method 1 merge sort just like arrays
        //return sort(head);
        
        //Method 2 bubble sort using recursion 
        return sortUsingBubbleSort(head);
    }
}