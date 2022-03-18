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
    
    public void getView(TreeNode root, int level, List<Integer> ans){
        if(root == null)
            return;
        if(ans.size() > 0){
            if(level > ans.size()-1)
                ans.add(root.val);
        }
        else
            ans.add(root.val);
        getView(root.right, level+1, ans);
        getView(root.left, level+1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        getView(root, 0, ans);
        return ans;
    }
}