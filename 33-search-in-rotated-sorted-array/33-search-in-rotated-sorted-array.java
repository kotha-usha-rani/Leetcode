class Solution {
    public int find(int[] arr, int start, int end){
		int mid;
		while(start <= end){
			mid = start + (end-start)/2;
			if(mid+1 <= end && arr[mid] > arr[mid+1]){
				return mid;
			}
			else{
				if(mid-1 >= 0 && arr[mid] > arr[mid-1]){
					if(arr[mid] < arr[arr.length-1])
						end = mid-1;
					else
						start = mid+1;
				}
				else
					return mid-1;
			}
		}
		return -1;
	}
    public int findIndex(int[] arr, int start, int end, int target){
        int mid;
        while(start <= end){
            mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int pivot = find(nums, 0, nums.length-1);
        int ans ;
        if(pivot != -1){
            ans = findIndex(nums, 0, pivot, target);
            if(ans == -1)
                ans = findIndex(nums, pivot+1, nums.length-1, target);
            return ans;
        }
        else 
            return findIndex(nums, 0, nums.length-1, target);
    }
}