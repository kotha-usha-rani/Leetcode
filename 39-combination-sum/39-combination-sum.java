class Solution {
    public List<List<Integer>> helper(int[] candidates, int index, int target, List<Integer> smallAns){
        List<List<Integer>> ans = new ArrayList<>();
        if(target == 0){
            ans.add(smallAns);
            return ans;
        }
        if(index >= candidates.length || candidates[index] > target)
            return ans;
        List<Integer> temp1 = new ArrayList<>(smallAns);
        List<Integer> temp2 = new ArrayList<>(smallAns);
        temp2.add(candidates[index]);
        List<List<Integer>> sm1 = helper(candidates, index+1, target, temp1);
        List<List<Integer>> sm2 = helper(candidates, index, target-candidates[index], temp2);
        ans.addAll(sm1);
        ans.addAll(sm2);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates, 0, target, new ArrayList<>());
    }
}