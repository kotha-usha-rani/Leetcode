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
    public int diameterOfBinaryTree(TreeNode root) {
        int height = finddiameter(root);
        return dia-1;
    }
}