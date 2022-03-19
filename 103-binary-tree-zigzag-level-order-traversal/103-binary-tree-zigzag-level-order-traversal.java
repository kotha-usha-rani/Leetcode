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
    
    public void getZigZag(TreeNode root, int level, List<List<Integer>> ans){
        if(root == null)
            return;
        if(ans.size()-1 < level){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            ans.add(temp);
        }
        else{
            if(level%2 != 0)
                ans.get(level).add(0,root.val);
            else
                ans.get(level).add(root.val);
        }            
        getZigZag(root.left, level+1, ans);
        getZigZag(root.right, level+1, ans);
    }
    
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
        
        // Stack<TreeNode> st1 = new Stack<>();
        // Stack<TreeNode> st2 = new Stack<>();
        // ArrayList<Integer> temp = new ArrayList<>();
        // st2.push(root);
        // int flag = 0;
        // while(!st1.isEmpty() || !st2.isEmpty()){
        //     TreeNode curr;
        //     if(flag == 0){
        //         while(!st2.isEmpty()){
        //             curr = st2.pop();
        //             temp.add(curr.val);
        //             if(curr.left != null)
        //                 st1.push(curr.left);
        //             if(curr.right != null)
        //                 st1.push(curr.right);
        //         }
        //         flag = 1;
        //     }
        //     else if(flag == 1){
        //         while(!st1.isEmpty()){
        //             curr = st1.pop();
        //             temp.add(curr.val);
        //             if(curr.right != null)
        //                 st2.push(curr.right);
        //             if(curr.left != null)
        //                 st2.push(curr.left);
        //         }
        //         flag = 0;
        //     }
        //     ans.add(temp);
        //     temp = new ArrayList<>();
        // }
        // return ans;
        
        //preorder recursive
        
        // getZigZag(root, 0, ans);
        // return ans;
        
        //iterative level order
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> temp ;
        Boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            temp = new ArrayList<>();
            for(int i=0 ; i<size ; i++){
                TreeNode curr = queue.remove();
                if(!flag)
                    temp.add(curr.val);
                else
                    temp.add(0, curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            ans.add(temp);
            flag = !flag;
        }
        return ans;
    }
}






