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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // ListNode temp, prevHead = head, next, newHead;
        // temp = head;
        // int count;
        // while(temp != null){
        //     count = 1;
        //     while(count < k && temp != null){
        //         count++;
        //         temp = temp.next;
        //     }
        //     if(count < k-1)
        //         return newHead;
        //     next = temp.next;
        //     temp.next = null;
        //     ListNode ans = reverse(temp);
        //     if(prevhead == head){
        //         newHead = ans;
        //         prevHead = ans;
        //     }
        //     else
        //         prevHead.next = ans;
        // }
        
        ListNode temp = head, currHead=null, newHead = head, ptr=null, prevHead;
        int t=0;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(temp != null){
            t = 0;
            while(temp != null && t<k){
                stack.push(temp);
                temp = temp.next;
                stack.peek().next = null;
                t++;
            }
            if(t<k){
                temp = stack.pop();
                while(!stack.isEmpty()){
                    stack.peek().next = temp;
                    temp = stack.pop();
                }
                if(currHead != null)
                    ptr.next = temp;
                
                return newHead;
            }
            
            currHead = stack.pop();
            if(ptr != null)
                ptr.next = currHead;
            ptr = currHead;
            while(!stack.isEmpty()){
                ptr.next = stack.pop();
                ptr = ptr.next;
            }
            ptr.next = temp;
            if(ptr == head){
                newHead = currHead;
            }
        }
        return newHead;
    }
}
















