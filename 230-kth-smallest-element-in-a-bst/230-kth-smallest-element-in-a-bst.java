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
    
    public void findLar(TreeNode root, int k, int[] ans){
        if(root == null)
            return;
        findLar(root.left, k, ans);
        ans[0]++;
        if(ans[0] == k){
            ans[1] = root.val;
            return;
        }
        findLar(root.right, k, ans);
            
    }
    public int kthSmallest(TreeNode root, int k) {
        //left root right
        // if(root == null)
        //     return -1;
        // int left = kthSmallest(root.left, k);
        // count++;
        // if(count == k){
        //     ans = root.val;
        //     return ans;
        // }
        // int right = kthSmallest(root.right, k);
        // return ans;
        
        //temp array to store count and root value
        int[] ans = new int[2];
        findLar(root, k, ans);
        return ans[1];
    }
}