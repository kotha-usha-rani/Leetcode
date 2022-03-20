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
     int solution(TreeNode root, int level, int currLevel, List<Integer> ans){
        if(root == null)
            return currLevel;
        if(currLevel < level){
            ans.add(root.val);
            currLevel = level;
        }
        currLevel = solution(root.right, level+1, currLevel, ans);
        currLevel = solution(root.left, level+1, currLevel, ans);
        return currLevel;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int currlevel = solution(root, 1, 0, ans);
        return ans;
    }
}