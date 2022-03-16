class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.push(0);
        for(int i=1 ; i<nums2.length ; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            map.put(nums2[stack.pop()], -1);
        }
        int[] ans = new int[nums1.length];
        int k=0;
        for(int i=0 ; i<nums1.length ; i++){
            ans[k++] = map.get(nums1[i]);
        }
        return ans;
    }
}