class Solution {
    
    public void reverse(int[] nums, int start, int end){
        int temp;
        while(start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        //Method 1: find all the permutations of the array
        //Method 2: find the element just before the strictly decreasing order
        if(nums.length <= 1)
            return ;
        int i, j;
        for(i=nums.length-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                for(j=nums.length-1 ; j>i ; j--){
                    if(nums[j] > nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp ;
                        break;
                    }
                }
                break;
            }
        }
        reverse(nums, i+1, nums.length-1);
    }
}