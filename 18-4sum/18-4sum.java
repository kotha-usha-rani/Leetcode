class Solution {
    public List<List<Integer>> helper(int[] nums, int target, int index, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if(index >= nums.length)
            return ans;
        if(k==2){
            int i=index, j=nums.length-1;
            while(i<j){
                if(nums[i]+nums[j] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[j]);
                    ans.add(list);
                    i++;j--;
                    while(i<j && nums[i] == nums[i-1])
                        i++;
                    while(i<j && nums[j] == nums[j+1])
                        j--;
                }
                else if(nums[i] + nums[j] < target)
                    i++;
                else
                    j--;
            }
        }
        else{
            for(int i=index ; i<nums.length-k+1 ; i++){
                List<List<Integer>> sm = helper(nums, target-nums[i], i+1, k-1);
                if(sm != null){
                    for(List<Integer> list : sm)
                        list.add(0, nums[i]);
                    ans.addAll(sm);
                }
                while(i+1<nums.length && nums[i] == nums[i+1])
                    i++;
            }
        }
        return ans;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, 0, 4);
    }
}