// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static int findRootIndex(int inorder[], int s1, int e1, int rootData){
        if(s1 == e1)
            return s1;
        while(s1<=e1){
            if(inorder[s1] == rootData)
                return s1;
            s1++;
        }
        return -1;
    }
    public static Node solution(int inorder[], int s1, int e1, int preorder[], int s2, int e2){
        if(s1 > e1 || s2 > e2)
            return null;
        if(s1 == e1 && s2 == e2)
            return new Node(preorder[s2]);
        Node root = new Node(preorder[s2]);
        int index = findRootIndex(inorder, s1, e1, root.data);
        root.left = solution(inorder, s1, index-1, preorder, s2+1, s2+index-s1);
        root.right = solution(inorder, index+1, e1, preorder, s2+index-s1+1, e2);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        return solution(inorder, 0, n-1, preorder, 0, n-1);
    }
}
