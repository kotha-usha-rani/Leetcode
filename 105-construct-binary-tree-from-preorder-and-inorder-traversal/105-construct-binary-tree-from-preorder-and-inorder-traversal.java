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
    public int preIndex = 0 ;
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode solution(int[] preorder, int s, int e){
        if(s>e)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if(s==e)
            return root;
        int index = inMap.get(root.val);
        root.left = solution(preorder, s, index-1);
        root.right = solution(preorder, index+1, e);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0 ; i<inorder.length ; i++)
            inMap.put(inorder[i], i);
        return solution(preorder, 0, preorder.length-1);
    }
}