/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dia = 0;
    public int finddiameter(TreeNode root) {
        if(root == null)
            return 0;
            
        int left = finddiameter(root.left);
        int right = finddiameter(root.right);
        dia = Math.max(dia, left+right+1);
        return 1 + Math.max(left, right);
    }
    
    public Pair diaUsingPair(TreeNode root){
        if(root == null)
            return new Pair(0,0);
        Pair left = diaUsingPair(root.left);
        Pair right = diaUsingPair(root.right);
        return new Pair(Math.max(left.height + right.height + 1, Math.max(left.maxDia, right.maxDia)),                              1 + Math.max(left.height, right.height));
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        //method 1 using dia as global variable
        
        // int height = finddiameter(root);
        // return dia-1;
        
        //using Pair class
        if(root == null)
            return 0;
        return diaUsingPair(root).maxDia-1;
    }
}
class Pair{
    int maxDia;
    int height;
    Pair(int maxDia, int height){
        this.maxDia = maxDia;
        this.height = height;
    }
}







