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
    public static int solution(Node head){
        if(head == null){
            return 1;
        }
        int rem = solution(head.next);
        int data = head.data+rem;
        head.data = data%10;
        if(data == 10)
            return 1;
        return 0;
    }
    
    public static Node addOne(Node head) 
    { 
        if(head == null)
            return null;
        if(head.next == null){
            head.data = head.data+1;
            return head;
        }
        //Method 1 recursive
        //   int temp = head.data;
        //   int ans = solution(head);
        //   if(ans != 0)
        //     head.data = temp+ans;
        //   return head;
    
        //Method 2 using arraylist to store data
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next ;
        }
        int rem = 1;
        for(int i=arr.size()-1 ; i>=0 ; i--){
            int data = arr.get(i)+rem;
            arr.set(i, data%10);
            if(data != 10)
                rem=0;
        }
        if(rem == 1){
            arr.set(0, head.data+rem);
        }
        temp = head;
        int i=0;
        while(temp != null){
            temp.data = arr.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}










