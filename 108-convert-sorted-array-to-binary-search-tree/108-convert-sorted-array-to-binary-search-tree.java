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
    public TreeNode sortedArrayToBST(int[] nums) {
        Stack<Data> stack = new Stack<>();
        TreeNode head = new TreeNode(nums[(nums.length-1)/2]);
        stack.push(new Data(head, 0, nums.length-1));
        while(!stack.isEmpty()){
            Data top = stack.pop();
            if(top.start == top.end || top.prev == null)
                continue;
            TreeNode prev = top.prev;
            int mid = top.start + (top.end-top.start)/2;
            int leftNodeIndex = top.start + (mid-1-top.start)/2;
            int rightNodeIndex = mid+1 + (top.end-(mid+1))/2;
            if(leftNodeIndex >= top.start && leftNodeIndex <= mid-1) 
                prev.left = new TreeNode(nums[leftNodeIndex]);
            else 
                prev.left = null;
            if(rightNodeIndex >= mid+1 && rightNodeIndex <= top.end) 
                prev.right = new TreeNode(nums[rightNodeIndex]);
            else 
                prev.right = null;
            stack.push(new Data(prev.left, top.start, mid-1));
            stack.push(new Data(prev.right, mid+1, top.end));
        }
        return head;
    }
}
class Data{
    TreeNode prev;
    int start;
    int end;
    Data(){}
    Data(TreeNode prev, int start, int end){
        this.prev = prev;
        this.start= start;
        this.end = end;
    }
}