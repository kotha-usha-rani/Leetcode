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
    
    public ListNode sort(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode head, temp, t;
        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }
        else{
            head = l2 ;
            l2 = l2.next;
        }
        temp = head ;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                t = l1.next;
                temp.next = l1 ;
                l1 = t ;
            }
            else{
                t = l2.next;
                temp.next = l2 ;
                l2 = t ;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1 ;
        }
        if(l2 != null){
            temp.next = l2 ;
        }
        return head;
        
    }
    
    public ListNode merge(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start+1 == end)
            return sort(lists[start], lists[end]);
        int mid = start + (end-start)/2;
        ListNode firstHalf = merge(lists, start, mid);
        ListNode secondHalf = merge(lists, mid+1, end);
        return sort(firstHalf, secondHalf);
    }
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        //Method 1: merge sort
        //return merge(lists, 0, lists.length-1);
        
        //method 2: heap
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        
        for(int i=0 ; i<lists.length ; i++){
            if(lists[i] != null)
                heap.add(lists[i]);
        }
        ListNode head = new ListNode(), temp;
        temp = head;
        while(!heap.isEmpty()){
            ListNode t = heap.poll();
            temp.next = t ;
            temp = temp.next;
            if(t.next != null){
                heap.add(t.next);
            }
            t = t.next;            
        }
        return head.next;
    }
}