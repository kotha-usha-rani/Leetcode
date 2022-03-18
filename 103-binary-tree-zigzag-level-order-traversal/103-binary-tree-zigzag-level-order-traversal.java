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
    
    public void reverse(ArrayList<Integer> arr){
        int i=0, j=arr.size()-1;
        while(i<j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;j--;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        //Queue, arraylists
        
        // Queue<TreeNode> queue = new LinkedList<>();
        // ArrayList<Integer> temp = new ArrayList<>();
        // int flag = 0 ;
        // queue.add(root);
        // queue.add(null);
        // while(!queue.isEmpty()){
        //     TreeNode curr = queue.remove();
        //     if(curr != null){
        //         temp.add(curr.val);
        //         if(curr.left != null)
        //             queue.add(curr.left);
        //         if(curr.right != null)
        //             queue.add(curr.right);
        //     }
        //     else{
        //         if(flag == 0){
        //             ans.add(temp);
        //             flag = 1; 
        //         }
        //         else{
        //             reverse(temp);
        //             ans.add(temp);
        //             flag = 0;
        //         }
        //         temp = new ArrayList<>(); 
        //         if(queue.isEmpty())
        //            break;
        //         queue.add(null);
        //     }
        // }
        // return ans;
        
        //two stacks
        
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        st2.push(root);
        int flag = 0;
        while(!st1.isEmpty() || !st2.isEmpty()){
            TreeNode curr;
            if(flag == 0){
                while(!st2.isEmpty()){
                    curr = st2.pop();
                    temp.add(curr.val);
                    if(curr.left != null)
                        st1.push(curr.left);
                    if(curr.right != null)
                        st1.push(curr.right);
                }
                flag = 1;
            }
            else if(flag == 1){
                while(!st1.isEmpty()){
                    curr = st1.pop();
                    temp.add(curr.val);
                    if(curr.right != null)
                        st2.push(curr.right);
                    if(curr.left != null)
                        st2.push(curr.left);
                }
                flag = 0;
            }
            ans.add(temp);
            temp = new ArrayList<>();
        }
        return ans;
    }
}