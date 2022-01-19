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
    
   
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0 ; i <lists.length ; i++){
            ListNode temp = lists[i] ;
            while(temp != null){
                queue.add(temp.val);
                temp=temp.next;
            }
        }
        if(queue.isEmpty())
            return null;
        ListNode ans = new ListNode();
        ListNode result = ans;
        ans.val = queue.poll();
        int size = queue.size();
        for(int i=0 ; i<size ; i++){
            ListNode t = new ListNode();
            t.val = queue.poll();
            ans.next = t ;
            ans = t ;
        }
        return result;
    }
}