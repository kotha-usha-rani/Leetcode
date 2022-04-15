class Solution {
    public List<List<Integer>> helper(int[] candidates, int target, int index, List<Integer> smallAns){
        List<List<Integer>> ans = new ArrayList<>();
        if(target == 0){
            ans.add(new ArrayList<>(smallAns));
            return ans;
        }
        if(target < 0 || index >= candidates.length || candidates[index] > target)
            return ans;
        
        ans.addAll(helper(candidates, target, index+1, smallAns));
        smallAns.add(candidates[index]);
        ans.addAll(helper(candidates, target-candidates[index], index, smallAns));
        smallAns.remove(smallAns.size()-1);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, target, 0, new ArrayList<>());
    }
}