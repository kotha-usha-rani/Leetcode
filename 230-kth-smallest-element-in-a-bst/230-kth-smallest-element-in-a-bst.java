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
    public int count = 0 ;
    public int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        //left root right
        if(root == null)
            return -1;
        int left = kthSmallest(root.left, k);
        count++;
        if(count == k){
            ans = root.val;
            return ans;
        }
        int right = kthSmallest(root.right, k);
        return ans;
    }
}