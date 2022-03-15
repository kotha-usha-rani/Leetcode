// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head){
        if(head == null || head.next == null)
            return head;
        Node ans = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
    public static int addRem(Node head){
        if(head == null)
            return 1;
        int rem = addRem(head.next);
        int sum =  (head.data + rem);
        head.data = sum%10;
        return sum/10;
    }
    public static Node addOne(Node head) 
    { 
    //     if(head == null)
    //         return null;
    //     int rem = addRem(head);
    //     if(rem > 0){
    //         Node newNode = new Node(rem);
    //         newNode.next = head;
    //         head = newNode;
    //     }
    //     return head;
    
    //reverse the list
        head = reverse(head);
        Node temp = head;
        int rem = 1, data = 0;
        while(temp != null){
            data = (temp.data+rem);
            temp.data = data%10;
            rem = data/10;
            temp = temp.next;
        }
        head = reverse(head);
        if(rem != 0){
            Node newNode = new Node(rem);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
