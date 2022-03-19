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
    public Triplet checkForBalance(TreeNode root){
        Triplet ans = new Triplet(0,true);
        if(root == null){
            return ans;
        }
        Triplet left = checkForBalance(root.left);
        Triplet right = checkForBalance(root.right);
        ans.h = 1 + Math.max(left.h, right.h);
        ans.isBal = left.isBal && right.isBal && Math.abs(left.h-right.h) <= 1 ;
        return ans;
    }
    
    public boolean isBalanced = true;
    public int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(Math.abs(left-right) > 1)
            isBalanced = false;
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        //using triplet class
        //return checkForBalance(root).isBal;
        
        //using public variable isBalanced
        int height = findHeight(root);
        return isBalanced;
    }
}
class Triplet{
    int h;
    boolean isBal ;
    Triplet(int h, boolean isBal){
        this.h = h ;
        this.isBal = isBal;
    }
}