class Solution {
    
    public int findIndex(int[] nums, int start, int end, int target, boolean isFirst){
        if(start > end)
            return -1;
        int mid, ans = -1 ;
        while(start <= end){
           mid = start + (end-start)/2;
            if(nums[mid] == target){
                ans = mid ;
                if(isFirst)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        arr[0] = findIndex(nums, 0, nums.length-1, target, true);
        if(arr[0] != -1)
            arr[1] = findIndex(nums, arr[0], nums.length-1, target, false);
        return arr;
    }
}