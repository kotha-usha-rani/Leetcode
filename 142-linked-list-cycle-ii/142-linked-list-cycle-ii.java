/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        if(head.next == head)
            return head;
        else if(head.next == null)
            return null;
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode temp = head;
        ListNode cycleNode = null ;
        while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            else
                map.put(temp, true);
            temp = temp.next;
        }
        return null;
    }
}