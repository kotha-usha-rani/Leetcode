class Solution {
    public List<List<Integer>> helper(int[] nums, int index, List<Integer> subset){
        List<List<Integer>> ans = new ArrayList<>();
        if(index >= nums.length){
            ans.add(new ArrayList<>(subset));
            return ans;
        }
        subset.add(nums[index]);
        ans.addAll(helper(nums, index+1, subset));
        subset.remove(subset.size()-1);
        ans.addAll(helper(nums, index+1, subset));
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0, new ArrayList<>());
    }
}