class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //using cyclic sort to sort the array :( input array is modified
        // int index = 0, i=0;
        // while(i<nums.length){
        //     index = nums[i]-1;
        //     if(index == i || nums[i] == nums[index])
        //         i++;
        //     else{
        //         int temp = nums[i];
        //         nums[i] = nums[index];
        //         nums[index] = temp;
        //     }
        // }
        // List<Integer> ans = new ArrayList<>();
        // for(i=0 ; i<nums.length ; i++){
        //     if(nums[i] != i+1)
        //         ans.add(nums[i]);
        // }
        // return ans;
        
        //mark the visited elements
        List<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
                ans.add(index+1);
            nums[index] = -nums[index];
            
        }
        return ans;
    }
}