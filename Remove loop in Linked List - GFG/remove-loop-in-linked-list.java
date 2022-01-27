// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if(head == null)
            return;
        if(head.next == null){
            head.next = null;
            return ;
        }
        //1. using hash map to find the loop node
        // HashMap<Node, Boolean> map = new HashMap<>();
        // Node temp = head;
        // Node cycleNode = null ;
        // Node prev = head;
        // while(temp != null){
        //     if(map.containsKey(temp)){
        //         cycleNode = prev;
        //         break;
        //     }
        //     else
        //         map.put(temp, true);
        //     prev = temp ;
        //     temp = temp.next;
        // }
        // if(cycleNode != null){
        //     temp = head;
        //     while(temp != cycleNode){
        //         temp = temp.next;
        //     }
        //     temp.next = null;
        // }
        
        //Method 2 using slow and fast pointers-->time limit exceeded
        // Node slow = head;
        // Node fast = head;
        // Node temp = head;
        // while(fast != null && fast.next != null){
        //     fast = fast.next.next;
        //     slow = slow.next;
        //     if(fast == slow)
        //         break;
        // }
        // if(fast == null || fast.next == null)
        //     return;
        // Node ptr = fast;
        // temp = head;
        // while(temp != null){
        //     while(ptr.next != fast){
        //         if(ptr == temp)
        //             break;
        //         ptr = ptr.next;
        //     }
        //     if(ptr == temp)
        //         break;
        //     temp = temp.next;
        //     ptr = fast;
        // }
        // while(temp.next != ptr){
        //     temp = temp.next;
        // }
        // temp.next = null;
        
        //Method 3 slow and fast pointer approach
        Node slow = head;
        Node fast = head;
        Node temp = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        if(fast == null || fast.next == null)
            return;
        temp = head;
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        while(temp.next != slow){
            temp = temp.next;
        }
        temp.next = null;
    }
}









