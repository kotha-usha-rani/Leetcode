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
     
    public List<TreeNode> solution(int i, int n){
        List<TreeNode> ans = new ArrayList<>();
        if(i>n){
            ans.add(null);
            return ans;
        }
        if(i==n){
            ans.add(new TreeNode(i));
            return ans;
        }
        int k=i;
        while(k<=n){
            List<TreeNode> lAns = solution(i,k-1);
            List<TreeNode> rAns = solution(k+1,n);
            for(TreeNode left : lAns){
                for(TreeNode right : rAns){
                    ans.add(new TreeNode(k, left, right));
                }
            }
            k++;
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return solution(1, n);
    }
}










