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
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            while(temp.left != null){
                stack.push(temp.left);
                temp = temp.left;
            }
            while(!stack.isEmpty()){
                if(stack.peek().right == null)
                    ans.add(stack.pop().val);
                else{
                    ans.add(stack.peek().val);
                    stack.push(stack.pop().right);
                    break;
                }                    
            }
        }
        return ans;
    }
}