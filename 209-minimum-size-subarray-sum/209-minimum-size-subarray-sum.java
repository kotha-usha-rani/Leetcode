class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0, i=0, j=0, min = Integer.MAX_VALUE;
        while(i<nums.length || j<nums.length){
            if(nums[i] >= target)
                return 1;
            if(sum >= target){
                min = Math.min(min, j-i);
                sum -= nums[i];
                i++;
            }
            else{
                if(j < nums.length){
                    sum += nums[j];
                    j++;
                }
                else
                    break;
            }
        }
        if(min == Integer.MAX_VALUE)
            return 0;
        return min;
    }
}