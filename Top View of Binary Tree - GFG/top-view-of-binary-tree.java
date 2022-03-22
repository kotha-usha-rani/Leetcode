// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static void solution(Node root, int dist, int level, Map<Integer, Pair> map){
        if(root == null)
           return ;
        if(!map.containsKey(dist) || map.get(dist).level > level)
            map.put(dist, new Pair(root.data, level));
        solution(root.left, dist-1, level+1, map);
        solution(root.right, dist+1, level+1, map);
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        if(root == null)
            return new ArrayList<>();
        // Map<Integer, Pair> map = new TreeMap<>();
        // solution(root, 0, 0, map);
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer, Pair> mapEle : map.entrySet())
        //     ans.add(mapEle.getValue().nodeData);
        // return ans;
        
        Queue<Pairr> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int low = Integer.MAX_VALUE;
        int high = 0;
        queue.add(new Pairr(root, 0));
        while(!queue.isEmpty()){
            Pairr temp = queue.remove();
            if(temp.dist < low){
                ans.add(0,temp.node.data);
                low = temp.dist;
            }
            else if(temp.dist > high){
                ans.add(temp.node.data);
                high = temp.dist;
            }
            if(temp.node.left != null)
                queue.add(new Pairr(temp.node.left, temp.dist-1));
            if(temp.node.right != null)
                queue.add(new Pairr(temp.node.right, temp.dist+1));
        }
        return ans;
    }
}
class Pair{
    int nodeData;
    int level;
    Pair(int nodeData, int level){
        this.nodeData = nodeData;
        this.level = level;
    }
}

class Pairr{
    Node node;
    int dist;
    Pairr(Node node, int dist){
        this.node = node;
        this.dist = dist;
    }
}