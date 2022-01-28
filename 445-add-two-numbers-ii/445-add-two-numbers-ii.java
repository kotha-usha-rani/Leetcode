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
    public int addCarry(ListNode temp){
        if(temp == null)
            return 1;
        int rem = addCarry(temp.next);
        int data = temp.val + rem ;
        temp.val = data%10;
        return data/10;
    }
    public int add(ListNode temp, ListNode l2){
        if(temp == null)
            return 0;
        int rem = add(temp.next, l2.next);
        int data = temp.val + l2.val + rem ;
        temp.val = data%10;
        return data/10;
    }
    public ListNode copyElements(ListNode l1, ListNode end){
        ListNode newList = new ListNode(l1.val);
        ListNode temp = newList;
        l1 = l1.next;
        while(l1 != end){
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        return newList;
    }
    public ListNode addTwoLists(ListNode l1, ListNode l2){
        ListNode temp = copyElements(l1, null);
        int carry = add(temp, l2);
        if(carry != 0){
            ListNode extra = new ListNode(carry);
            extra.next = temp;
            temp = extra;
        }
        return temp;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2 ;
        int c1 = 0;
        int c2 = 0;
        while(t1 != null){
            c1++;
            t1 = t1.next;
        }
        while(t2 != null){
            c2++;
            t2 = t2.next;
        }
        if(c1 == c2){
            return addTwoLists(l1, l2);
        }
        int diff = Math.abs(c1-c2);
        if(c1>c2){
            t1 = l1; t2 = l2;
        }
        else{
            t1 = l2; t2 = l1;
        }
        ListNode headLargest = t1 ;
        while(t1 != null && diff > 0){
            t1 = t1.next;
            diff--;
        }
        ListNode breakLargest = t1;
        ListNode addedList = copyElements(t1, null);
        int carry = add(addedList, t2);
        ListNode firstPart = copyElements(headLargest, breakLargest);
        int additionalCarry = 0;
        if(carry != 0)
            additionalCarry = addCarry(firstPart);
        if(additionalCarry != 0){
            ListNode extra = new ListNode(carry);
            extra.next = firstPart;
            firstPart = extra;
        }
        ListNode newHead = firstPart;
        while(firstPart.next != null){
            firstPart = firstPart.next;
        }
        firstPart.next = addedList ;
        return newHead;        
    }
}







