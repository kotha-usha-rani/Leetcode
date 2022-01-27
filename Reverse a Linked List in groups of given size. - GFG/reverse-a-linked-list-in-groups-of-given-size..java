// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
     public static Node reverse(Node head, Node end){
        if(head == end)
            return head;
        Node ans = reverse(head.next, end);
        head.next.next = head;
        head.next = null;
        return ans;
    }
    public static Node reverse(Node head, int k)
    {
        //Your code here
         if(head == null || head.next == null || k==1)
            return head;
        
        //Method 1 iterative, reverse k nodes at a time
        Node prev = head;
        Node temp = head;
        Node temp2 = head;
        Node t = null;
        Node revHead = null;
        int count = 0;
        while(temp != null){
            count = 1;
            temp2 = temp;
            while(temp2.next != null && count < k){
                count++;
                temp2 = temp2.next;                
            }
            t = temp2.next ;
            revHead = reverse(temp, temp2);
            if(temp == head)
               head = revHead;
            else
                prev.next = revHead ;
            temp.next = t ;
            prev = temp;
            temp = t;            
        }
        return head;
    }
}

