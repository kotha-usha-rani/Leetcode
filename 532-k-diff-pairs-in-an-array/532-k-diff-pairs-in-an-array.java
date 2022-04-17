class Solution {
    public int findPairs(int[] nums, int k) {
       Arrays.sort(nums);
        int i=nums.length-1, j=nums.length-2, count = 0;
        while(j>-1 && i>-1){
            if(i != j && nums[j] == nums[i]-k){
                i--;j--;
                while(i>=0 && nums[i] == nums[i+1]) i--;
                while(j>=0 && nums[j] == nums[j+1]) j--;
                count++;
            }
            else if(nums[j] > nums[i]-k)
                j--;
            else
                i--;
        }
        return count;
    }
}