class Solution {
    public int findEndBS(int[] sum, int start, int target){
        int pSum = 0 ;
        if(start > 0)
            pSum = sum[start-1]; 
        int i=start, j=sum.length-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(sum[mid]-pSum >= target)
                j=mid-1;
            else
                i=mid+1;
        }
        return i;
    }
    public int minSubArrayLen(int target, int[] nums) {
        //int sum=0, i=0, j=0, min = Integer.MAX_VALUE;
        // while(i<nums.length || j<nums.length){
        //     if(nums[i] >= target)
        //         return 1;
        //     if(sum >= target){
        //         min = Math.min(min, j-i);
        //         sum -= nums[i];
        //         i++;
        //     }
        //     else{
        //         if(j < nums.length){
        //             sum += nums[j];
        //             j++;
        //         }
        //         else
        //             break;
        //     }
        // }
        
        //better code
        // while(j<nums.length){
        //     sum += nums[j];
        //     j++;
        //     while(sum >= target){
        //         min = Math.min(min, j-i);
        //         sum -= nums[i];
        //         i++;
        //     }
        // }
        // if(min == Integer.MAX_VALUE)
        //     return 0;
        // return min;
        
        //binary search O(nlogn)
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int min = Integer.MAX_VALUE;
        for(int i=1 ; i<nums.length ; i++)
            sum[i] = sum[i-1] + nums[i];
        for(int i=0 ; i<nums.length ; i++){
            int end = findEndBS(sum ,i, target);
            if(end < nums.length)
                min = Math.min(min, end-i+1);
            else
                break;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}