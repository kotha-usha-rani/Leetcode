class Solution {
    public int binarySearch(int[] arr, int start, int end, int target){
		int index = end+1 ;
		while(start <= end){
            int mid = start + (end-start)/2;
			if(arr[mid] >= target){
				index = mid;
                end = mid-1;
			}
			else
				start = mid+1;
		}
		return index;
	}
    public int[] searchRange(int[] arr, int target) {
        if(arr.length==0)
			return new int[]{-1, -1};
		int first = binarySearch(arr, 0, arr.length-1, target);
        if(first < arr.length && arr[first] != target || first >= arr.length)
            return new int[]{-1, -1};
        int second = binarySearch(arr, 0, arr.length-1, target+1)-1;
        return new int[]{first, second};
    }
}