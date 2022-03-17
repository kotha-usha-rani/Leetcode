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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root, prev = null;
        while(!stack.isEmpty() || curr != null){
            if(curr != null && curr != prev){
                while(curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.peek().right;
            }
            else{ 
                prev = stack.pop();
                ans.add(prev.val);
                if(!stack.isEmpty())
                   curr = stack.peek().right;
                else
                    break;
            }
        }
        return ans;
    }
}