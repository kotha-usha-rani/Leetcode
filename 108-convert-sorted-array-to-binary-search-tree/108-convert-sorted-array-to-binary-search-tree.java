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
        stack.push(new Data(head, 0, (nums.length-1)/2, nums.length-1));
        while(!stack.isEmpty()){
            Data top = stack.pop();
            if(top.start == top.end || top.prev == null)
                continue;
            TreeNode prev = top.prev;
            int leftIndex = top.start + (top.mid-1-top.start)/2;
            int rightIndex = top.mid+1 + (top.end-(top.mid+1))/2;
            if(leftIndex >= top.start && leftIndex <= top.mid-1) 
                prev.left = new TreeNode(nums[leftIndex]);
            if(rightIndex >= top.mid+1 && rightIndex <= top.end) 
                prev.right = new TreeNode(nums[rightIndex]);
            stack.push(new Data(prev.left, top.start, leftIndex, top.mid-1));
            stack.push(new Data(prev.right, top.mid+1, rightIndex, top.end));
        }
        return head;
    }
}
class Data{
    TreeNode prev;
    int start;
    int mid;
    int end;
    Data(){}
    Data(TreeNode prev, int start, int mid, int end){
        this.prev = prev;
        this.start= start;
        this.mid = mid;
        this.end = end;
    }
}