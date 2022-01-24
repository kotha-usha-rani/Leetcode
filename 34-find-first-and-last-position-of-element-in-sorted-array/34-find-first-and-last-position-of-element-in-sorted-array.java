class Solution {
    
    public int binarySearch(int[] arr, int start, int end, int target, boolean flag){
        if(start > end)
            return -1;
        int mid = start + (end-start)/2;
        if(flag){
            if(arr[mid] == target){
                if(mid-1 >= 0){
                    if(arr[mid-1] != target)
                        return mid;
                }
                else
                    return mid;
                
            }
            if(target <= arr[mid])
                return binarySearch(arr, start, end-1, target, flag);
            else
                return binarySearch(arr, mid+1, end, target, flag);
        }
        else{
            if(arr[mid] == target){
                if(mid+1 < arr.length){
                    if(arr[mid+1] != target)
                        return mid;
                }
                else
                    return mid;
            }
            if(target < arr[mid])
                return binarySearch(arr, start, end-1, target, flag);
            else
                return binarySearch(arr, mid+1, end, target, flag);
        }
        
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1, -1};
        int[] ans = new int[2];
        ans[0] = binarySearch(nums, 0, nums.length-1, target, true);
        if(ans[0] != -1)
            ans[1] = binarySearch(nums, ans[0], nums.length-1, target, false);
        else
            ans[1] = -1;
        return ans;
    }
}