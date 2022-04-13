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
    public boolean checkIfMath(TreeNode root, TreeNode subRoot){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root); s2.push(subRoot);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode currRoot = s1.pop();
            TreeNode currSubRoot = s2.pop();
            if(currRoot != null && currSubRoot != null && currRoot.val != currSubRoot.val)
                return false;
            if(currRoot == null && currSubRoot != null || currRoot != null && currSubRoot == null)
                return false;
            if(currRoot != null){
                s1.push(currRoot.left);
                s1.push(currRoot.right);
            }
            if(currSubRoot != null){
                s2.push(currSubRoot.left);
                s2.push(currSubRoot.right);
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null)
            return root == subRoot;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.val == subRoot.val && checkIfMath(curr, subRoot))
                return true;
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
        }
        return false;
    }
}