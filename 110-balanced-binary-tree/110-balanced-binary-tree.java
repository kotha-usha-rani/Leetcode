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
    public boolean isBalanced(TreeNode root) {
        return checkForBalance(root).isBal;
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