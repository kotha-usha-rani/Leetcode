class Solution {
    public int missingNumber(int[] nums) {
        // int originalSum = nums.length*(nums.length+1)/2;
        // int givenSum = 0;
        // for(int i=0 ; i<nums.length ; i++){
        //     givenSum += nums[i];
        // }
        // return originalSum - givenSum;
        
        //using xor
        int ans = 0 ;
        for(int i=0 ; i<nums. length ; i++){
            ans = ans ^ nums[i];
        }
        int temp = nums.length;
        while(temp >= 1){
            ans = ans ^ temp;
            temp--;
        }
        return ans;
    }
}