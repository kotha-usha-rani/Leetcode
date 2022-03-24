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
    int preIndex = 0 ;
    public int greaterIndex(int[] preorder, int s, int e, int ele){
        if(s > e)
            return -1;
        while(s<=e){
            if(preorder[s] > ele)
                return s-1;
            s++;
        }
        return e;
    }
    public TreeNode sol(int[] preorder, int s, int e){
        if(s > e)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int index = greaterIndex(preorder, s+1, e, root.val);
        if(index != -1){
            root.left = sol(preorder, s+1, index);
            root.right = sol(preorder, index+1, e);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return sol(preorder, 0, preorder.length-1);
    }
}