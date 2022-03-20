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
    
    public void solution(TreeNode root, int level, List<List<Integer>> ans){
        if(root == null)
            return;
        if(ans.size() <= level)
            ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        solution(root.left, level+1, ans);
        solution(root.right, level+1, ans);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        // List<List<Integer>> ans = new ArrayList<>();
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // queue.add(null);
        // ans.add(new ArrayList<>());
        // while(!queue.isEmpty()){
        //     TreeNode temp = queue.remove();
        //     if(temp != null){
        //         ans.get(0).add(temp.val);
        //         if(temp.left != null)
        //             queue.add(temp.left);
        //         if(temp.right != null)
        //             queue.add(temp.right);
        //     }
        //     else{
        //         if(queue.isEmpty())
        //             break;
        //         queue.add(null);
        //         ans.add(0, new ArrayList<>());
        //     }
        // }
        // return ans;
        
        //dfs
        List<List<Integer>> ans= new ArrayList<>();
        solution(root, 0, ans);
        List<List<Integer>> fans= new ArrayList<>();
        for(int i=ans.size()-1 ; i>=0 ; i--){
            fans.add(ans.get(i));
        }
        return fans;
    }
}








