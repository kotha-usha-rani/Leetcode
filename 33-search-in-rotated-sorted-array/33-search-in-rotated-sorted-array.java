class Solution {
    //Method 2
   public int findIndex(int[] arr, int start, int end){
       while(start <= end){
           int mid = start + (end-start)/2;
           if(mid < end && arr[mid] > arr[mid+1])
               return mid;
           if(mid>0 && arr[mid-1] > arr[mid])
               return mid-1;
           if(arr[mid] < arr[start])
               end = mid-1;
           else
               start = mid+1;
       }
       return -1;
   }
    
     //Method 2
    public int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;
            if(target < arr[mid]){
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return -1;
    }
    
    //Method 3
    public int findTarget(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[start] <= arr[mid]){
                if(target < arr[mid] && target >= arr[start])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else {
                if(target > arr[mid] && target <= arr[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        //Method 1 Linear search
        // for(int i=0 ; i<nums.length ; i++){
        //     if(nums[i] == target)
        //         return i;
        // }
        // return -1;
        
        
        //Method 2 Direct binary search is not possible
        //therefore find the index where the array was rotated
        //left of pivot is sorted in ascending order, right of pivot is sorted in                       ascending order as well, search in one part of the array
        // int index = findIndex(nums, 0, nums.length-1);
        // if(index == -1)
        //     return binarySearch(nums, 0, nums.length-1, target);
        // if(nums[index] == target)
        //     return index;
        // else if(target >= nums[0])
        //     return binarySearch(nums, 0, index-1, target);
        // else
        //     return binarySearch(nums, index+1, nums.length-1, target);
        
        
        //Method 3, O(logn) time complexity
        //one part of the array is strictly increasing, if target is not in strictly increasing order, it might be in the other half, if the target if to be found in non-increasing order, we will be left with the half that has two elemenets in it, target might be found among the two
        return findTarget(nums, 0, nums.length-1, target);
            
    }
}