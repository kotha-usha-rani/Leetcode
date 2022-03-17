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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        // iterative
        // Stack<TreeNode> stack = new Stack<>();
        // List<Integer> ans = new ArrayList<>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     TreeNode temp = stack.peek();
        //     while(temp.left != null){
        //         stack.push(temp.left);
        //         temp = temp.left;
        //     }
        //     while(!stack.isEmpty()){
        //         ans.add(stack.peek().val);
        //         if(stack.peek().right != null){
        //             stack.push(stack.pop().right);
        //             break;
        //         }
        //         stack.pop();
        //     }
        // }
        // return ans;
        
        //recursive
        // List<Integer> ans = inorderTraversal(root.left);
        // ans.add(root.val);
        // ans.addAll(inorderTraversal(root.right));
        // return ans;
        
        
        //iteratice better code
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}