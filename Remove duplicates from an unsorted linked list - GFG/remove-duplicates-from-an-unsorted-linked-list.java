// { Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}

class Remove_Duplicate_From_LL
{
    Node head;  
    Node temp;
	public void addToTheLast(Node node) 
	{

	  if (head == null) 
	  {
	    head = node;
	    temp = node;
	  }
	  else{
	      temp.next = node;
	      temp = node;
	  }
	}

      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])
    {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		  
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
		//llist.printList();	
        Solution g = new Solution();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }
}
// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
          if(head == null || head.next == null)
            return head;
            
         //Method 1 using two loops to find duplicates--->time limit exceeded
       
        //  Node temp1 = head ;
        //  Node temp2 = null ;
        //  Node prev = null ;
        //  while(temp1 != null && temp1.next != null){
        //      temp2 = temp1.next ;
        //      prev = temp1;
        //      while(temp2 != null){
        //          if(temp1.data == temp2.data){
        //              prev.next = temp2.next ;
        //              temp2 = temp2.next ;
        //          }
        //          else{
        //             prev = temp2 ;
        //             temp2 = temp2.next ;
        //          }
        //      }
        //      temp1 = temp1.next ;
        //  }
        //  return head ;
        
        //Method 2 using hashmap
        Node prev = head;
        Node temp = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(temp != null){
            if(map.containsKey(temp.data))
                prev.next = temp.next;
            else{
                map.put(temp.data, 1);
                prev = temp;
            }
            temp=temp.next ;
        }
        return head ;
    }
}






